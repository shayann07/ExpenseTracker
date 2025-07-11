package com.nayab.linearlayout.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ExpenseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(expense: ExpenseEntity)

    @Update
    suspend fun update(expense: ExpenseEntity)

    @Delete
    suspend fun delete(expense: ExpenseEntity)

    @Query("SELECT * FROM expense_table WHERE date BETWEEN :start AND :end ORDER BY date DESC")
    fun getExpensesBetween(start: String, end: String): LiveData<List<ExpenseEntity>>

    @Query("SELECT * FROM expense_table ORDER BY date DESC")
    fun getAllExpenses(): LiveData<List<ExpenseEntity>>

    @Query("SELECT * FROM expense_table WHERE id = :id")
    suspend fun getExpenseById(id: Int): ExpenseEntity

    @Query("SELECT * FROM expense_table WHERE date = :today")
    fun getDailyExpenses(today: String): LiveData<List<ExpenseEntity>>

    @Query("SELECT * FROM expense_table WHERE date BETWEEN :start AND :end")
    fun getWeeklyExpenses(start: String, end: String): LiveData<List<ExpenseEntity>>

    @Query("SELECT * FROM expense_table WHERE date LIKE :month || '%'")
    fun getMonthlyExpenses(month: String): LiveData<List<ExpenseEntity>>
}
