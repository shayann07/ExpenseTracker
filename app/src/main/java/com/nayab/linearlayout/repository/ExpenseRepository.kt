package com.nayab.linearlayout.repository

import androidx.lifecycle.LiveData
import com.nayab.linearlayout.data.ExpenseDao
import com.nayab.linearlayout.data.ExpenseEntity

class ExpenseRepository(private val dao: ExpenseDao) {
    val allExpenses = dao.getAllExpenses()

    // Make sure this matches the DAO's date type
    fun getExpensesBetween(start: String, end: String) = dao.getExpensesBetween(start, end)

    suspend fun insert(expense: ExpenseEntity) = dao.insert(expense)
    suspend fun update(expense: ExpenseEntity) = dao.update(expense)
    suspend fun delete(expense: ExpenseEntity) = dao.delete(expense)
    suspend fun getExpenseById(id: Int): ExpenseEntity = dao.getExpenseById(id)


    fun getDailyExpenses(date: String): LiveData<List<ExpenseEntity>> = dao.getDailyExpenses(date)

    fun getMonthlyExpenses(month: String): LiveData<List<ExpenseEntity>> = dao.getMonthlyExpenses(month)

}
