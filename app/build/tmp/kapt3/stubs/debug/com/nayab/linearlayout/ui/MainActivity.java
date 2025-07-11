package com.nayab.linearlayout.ui;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\u0012\u0010\u0017\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u0013H\u0014J\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0016\u0010\u001e\u001a\u00020\u00132\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 H\u0002J\u001e\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020!0 H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/nayab/linearlayout/ui/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "adapter", "Lcom/nayab/linearlayout/adapter/ExpenseAdapter;", "btnAddExpense", "Landroid/widget/Button;", "btnDaily", "btnMonthly", "btnWeekly", "pieChart", "Lcom/github/mikephil/charting/charts/PieChart;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "tvTotal", "Landroid/widget/TextView;", "viewModel", "Lcom/nayab/linearlayout/viewmodel/ExpenseViewModel;", "observeAllExpenses", "", "observeDailyExpenses", "observeMonthlyExpenses", "observeWeeklyExpenses", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "setFilterButtonsVisible", "visible", "", "updateChart", "expenses", "", "Lcom/nayab/linearlayout/data/ExpenseEntity;", "updateTotal", "label", "", "list", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.github.mikephil.charting.charts.PieChart pieChart;
    private android.widget.Button btnAddExpense;
    private android.widget.TextView tvTotal;
    private androidx.recyclerview.widget.RecyclerView recyclerView;
    private com.nayab.linearlayout.viewmodel.ExpenseViewModel viewModel;
    private com.nayab.linearlayout.adapter.ExpenseAdapter adapter;
    private android.widget.Button btnDaily;
    private android.widget.Button btnWeekly;
    private android.widget.Button btnMonthly;
    
    public MainActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    private final void observeAllExpenses() {
    }
    
    private final void observeDailyExpenses() {
    }
    
    private final void observeWeeklyExpenses() {
    }
    
    private final void observeMonthlyExpenses() {
    }
    
    private final void updateTotal(java.lang.String label, java.util.List<com.nayab.linearlayout.data.ExpenseEntity> list) {
    }
    
    private final void setFilterButtonsVisible(boolean visible) {
    }
    
    private final void updateChart(java.util.List<com.nayab.linearlayout.data.ExpenseEntity> expenses) {
    }
}