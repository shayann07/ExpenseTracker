# Expense Tracker

A small Kotlin Android app that records personal expenses in a local Room database and visualizes them with a category pie chart and date-range filters.

## Status

Educational/portfolio project. Single-module Android app with two screens, one Room entity, and a daily reminder via WorkManager. No backend, accounts, or cloud sync.

## Features

- Record expenses with amount, category, free-form note, and a picked date.
- List recorded expenses in a `RecyclerView` with newest dates first.
- Tap an item to open the editor; long-press to delete.
- Filter the list and chart by today, the current Mon–Sun week, or the current month.
- Show a category breakdown of the active list as a `MPAndroidChart` pie chart with a category legend.
- Show a running total label for the active filter.
- Schedule a daily reminder notification through `WorkManager` to log expenses.

## Tech Stack

- **Language:** Kotlin (JVM target 11).
- **UI:** Android Views with `AppCompat`, Material Components, `ConstraintLayout`, and `RecyclerView`.
- **Persistence:** Room 2.6.1 (`ExpenseDatabase`, `ExpenseDao`, `ExpenseEntity`) with KAPT compiler.
- **Architecture:** Activity + manual `ViewModelProvider.Factory` wiring an `ExpenseRepository` over the DAO; LiveData observed in the activity.
- **Concurrency:** `kotlinx-coroutines-android` and `viewModelScope` for DAO calls.
- **Background work:** `androidx.work:work-runtime-ktx` periodic worker (`ReminderWorker`).
- **Charts:** `MPAndroidChart` v3.1.0 for the pie chart.
- **Date handling:** `ThreeTenABP` for `LocalDate`/`DayOfWeek` on older Android API levels.
- **Misc:** `lottie-android` declared in dependencies.

## Architecture

- `MainActivity` hosts the chart, filter buttons, total label, and expense list. It builds the Room database, repository, and view model directly, then observes one of four LiveData streams depending on the active filter.
- `AddExpenseActivity` collects the expense fields, opens a `DatePickerDialog`, and inserts or updates a row through the same view model.
- `ExpenseRepository` is a thin pass-through over `ExpenseDao`. The DAO exposes LiveData for list queries and `suspend` functions for single-row writes.
- `ExpenseViewModel` derives "today", week start/end, and the current `YYYY-MM` prefix using ThreeTenABP and forwards them to the DAO.
- `ReminderScheduler` enqueues a unique daily `PeriodicWorkRequest` from `MainActivity.onCreate`, requiring battery-not-low. `ReminderWorker` posts a notification to the `expense_reminder_channel` if `POST_NOTIFICATIONS` is granted on Android 13+.

## Project Structure

```
app/
├── build.gradle.kts
└── src/main/
    ├── AndroidManifest.xml
    ├── java/com/nayab/linearlayout/
    │   ├── adapter/ExpenseAdapter.kt
    │   ├── data/
    │   │   ├── ExpenseDao.kt
    │   │   ├── ExpenseDatabase.kt
    │   │   └── ExpenseEntity.kt
    │   ├── repository/ExpenseRepository.kt
    │   ├── ui/
    │   │   ├── AddExpenses.kt        // declares AddExpenseActivity
    │   │   └── MainActivity.kt
    │   ├── utils/
    │   │   ├── ReminderScheduler.kt
    │   │   └── ReminderWorker.kt
    │   └── viewmodel/
    │       ├── ChartViewModel.kt
    │       ├── ExpenseViewModel.kt
    │       └── ExpenseViewModelFactory.kt
    └── res/
        ├── drawable/
        ├── layout/
        │   ├── activity_add_expense.xml
        │   ├── activity_main.xml
        │   └── expense_item.xml
        └── values/
```

The application id and namespace are `com.nayab.linearlayout`; the app label resource is `@string/app_name`.

## Getting Started

### Prerequisites

- Android Studio with the Android Gradle Plugin and Kotlin support configured for the wrapper version in `gradle/wrapper`.
- JDK 11 (matches `compileOptions`/`kotlinOptions`).
- Android SDK with `compileSdk = 35` and `minSdk = 24`.

### Run

```bash
git clone https://github.com/shayann07/ExpenseTracker.git
```

Open the project in Android Studio, let Gradle sync, then run the `app` configuration on an emulator or device.

### Build

```bash
./gradlew :app:assembleDebug
```

The repository tracks a `local.properties` file; replace its `sdk.dir` value with the path on your machine before building.

## Usage Notes

- Categories are entered as free text in the editor. The chart legend uses whatever category strings are saved.
- Dates are stored as `YYYY-MM-DD` strings, which is what the daily, weekly, and monthly queries expect.
- The notification channel is created on first reminder fire; on Android 13+ the user must grant `POST_NOTIFICATIONS` for it to display.

## Limitations

- No authentication, accounts, sync, or remote backup. All data lives in the local Room database `expense_db`.
- Editing from the list does not currently load the existing record into the editor: `MainActivity` passes the expense id under the `"id"` key, but `AddExpenseActivity` reads `"expense_id"`. The save path then inserts a new row instead of updating.
- `ExpenseDatabase` does not declare migrations; future schema changes will require migration code or a destructive fallback.
- DAO list queries return `LiveData`, and `MainActivity` re-subscribes on every filter button click without removing previous observers, so older observers keep firing while the activity is alive.
- `ExpenseAdapter.submitList` calls `notifyDataSetChanged`; there is no `DiffUtil`.
- Field validation is limited to non-empty checks; amount is parsed with `toDoubleOrNull() ?: 0.0`.
- `ChartViewModel` is defined but is not wired into the active screens.
- Only generated example tests are present, and there is no license file.
