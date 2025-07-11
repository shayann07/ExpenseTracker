package com.nayab.linearlayout.viewmodel

import androidx.lifecycle.*
import com.nayab.linearlayout.data.ExpenseEntity
import com.nayab.linearlayout.repository.ExpenseRepository
import kotlinx.coroutines.launch
import org.threeten.bp.LocalDate
import org.threeten.bp.DayOfWeek

class ExpenseViewModel(private val repository: ExpenseRepository) : ViewModel() {

    fun insertExpense(expense: ExpenseEntity) = viewModelScope.launch {
        repository.insert(expense)
    }

    fun deleteExpense(expense: ExpenseEntity) = viewModelScope.launch {
        repository.delete(expense)
    }

    fun updateExpense(expense: ExpenseEntity) = viewModelScope.launch {
        repository.update(expense)
    }

    fun getExpenseById(id: Int) = liveData {
        emit(repository.getExpenseById(id))
    }

    fun getAllExpenses(): LiveData<List<ExpenseEntity>> = repository.allExpenses

    fun getDailyExpenses(): LiveData<List<ExpenseEntity>> = repository.getDailyExpenses(getToday())

    fun getWeeklyExpenses(): LiveData<List<ExpenseEntity>> =
        repository.getExpensesBetween(getStartOfWeek(), getEndOfWeek())

    fun getMonthlyExpenses(): LiveData<List<ExpenseEntity>> =
        repository.getMonthlyExpenses(getCurrentMonth())

    // Utility functions
    private fun getToday(): String = LocalDate.now().toString()

    private fun getStartOfWeek(): String = LocalDate.now().with(DayOfWeek.MONDAY).toString()

    private fun getEndOfWeek(): String = LocalDate.now().with(DayOfWeek.SUNDAY).toString()

    private fun getCurrentMonth(): String {
        val now = LocalDate.now()
        return "${now.year}-${String.format("%02d", now.monthValue)}"
    }
}
