# Expense Tracker

[![Platform](https://img.shields.io/badge/Platform-Android-3DDC84?logo=android&logoColor=white)]()
[![Language](https://img.shields.io/badge/Language-Kotlin-7F52FF?logo=kotlin&logoColor=white)]()
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

> Track daily expenses by category, filter by date range, and see your spending broken down in a pie chart. Comes with a daily reminder so you don't forget to log.

---

## 📖 Overview

Track daily expenses by category, filter by date range, and see your spending broken down in a pie chart. Comes with a daily reminder so you don't forget to log.

---

## ✨ Key Features

- Record expenses with amount, category, free-form note, and a picked date.
- List recorded expenses in a `RecyclerView` with newest dates first.
- Tap an item to open the editor; long-press to delete.
- Filter the list and chart by today, the current Mon–Sun week, or the current month.
- Show a category breakdown of the active list as a `MPAndroidChart` pie chart with a category legend.
- Show a running total label for the active filter.
- Schedule a daily reminder notification through `WorkManager` to log expenses.

---

## 🛠️ Technology Stack

| Component / Layer | Technology |
|---|---|
| **Platform** | Android |
| **Primary Language** | Kotlin |
| **Architecture** | MVVM / Clean Architecture |
| **License** | Open Source (MIT) |

---

## 🚀 Getting Started

### Prerequisites
- Android Studio Ladybug (or newer)
- JDK 17 / 21
- Android SDK 34 / 35

### Build & Run
1. Clone the repository:
   ```bash
   git clone https://github.com/shayann07/ExpenseTracker.git
   cd ExpenseTracker
   ```
2. Open the project in **Android Studio**.
3. Sync Gradle dependencies and run on an emulator or physical device.

---

## 📄 License

This project is licensed under the [MIT License](LICENSE) — Copyright (c) 2026 [shayann07](https://github.com/shayann07).
