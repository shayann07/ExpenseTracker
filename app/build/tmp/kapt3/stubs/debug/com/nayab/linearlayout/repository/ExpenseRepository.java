package com.nayab.linearlayout.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\u000eJ\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0086@\u00a2\u0006\u0002\u0010\u0015J\"\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0011J\u001a\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u001a\u001a\u00020\u0011J\u0016\u0010\u001b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\u000eJ\u0016\u0010\u001c\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\u000eR\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/nayab/linearlayout/repository/ExpenseRepository;", "", "dao", "Lcom/nayab/linearlayout/data/ExpenseDao;", "(Lcom/nayab/linearlayout/data/ExpenseDao;)V", "allExpenses", "Landroidx/lifecycle/LiveData;", "", "Lcom/nayab/linearlayout/data/ExpenseEntity;", "getAllExpenses", "()Landroidx/lifecycle/LiveData;", "delete", "", "expense", "(Lcom/nayab/linearlayout/data/ExpenseEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDailyExpenses", "date", "", "getExpenseById", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getExpensesBetween", "start", "end", "getMonthlyExpenses", "month", "insert", "update", "app_debug"})
public final class ExpenseRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.nayab.linearlayout.data.ExpenseDao dao = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.nayab.linearlayout.data.ExpenseEntity>> allExpenses = null;
    
    public ExpenseRepository(@org.jetbrains.annotations.NotNull()
    com.nayab.linearlayout.data.ExpenseDao dao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.nayab.linearlayout.data.ExpenseEntity>> getAllExpenses() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.nayab.linearlayout.data.ExpenseEntity>> getExpensesBetween(@org.jetbrains.annotations.NotNull()
    java.lang.String start, @org.jetbrains.annotations.NotNull()
    java.lang.String end) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.nayab.linearlayout.data.ExpenseEntity expense, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object update(@org.jetbrains.annotations.NotNull()
    com.nayab.linearlayout.data.ExpenseEntity expense, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object delete(@org.jetbrains.annotations.NotNull()
    com.nayab.linearlayout.data.ExpenseEntity expense, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getExpenseById(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.nayab.linearlayout.data.ExpenseEntity> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.nayab.linearlayout.data.ExpenseEntity>> getDailyExpenses(@org.jetbrains.annotations.NotNull()
    java.lang.String date) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.nayab.linearlayout.data.ExpenseEntity>> getMonthlyExpenses(@org.jetbrains.annotations.NotNull()
    java.lang.String month) {
        return null;
    }
}