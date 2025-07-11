package com.nayab.linearlayout.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nayab.linearlayout.data.ExpenseEntity

class ChartViewModel : ViewModel() {
    private val _chartData = MutableLiveData<List<ExpenseEntity>>()
    val chartData: LiveData<List<ExpenseEntity>> get() = _chartData

    fun setChartData(data: List<ExpenseEntity>) {
        _chartData.value = data
    }
}