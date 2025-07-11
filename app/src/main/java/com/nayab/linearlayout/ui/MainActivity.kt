package com.nayab.linearlayout.ui

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.jakewharton.threetenabp.AndroidThreeTen
import com.nayab.linearlayout.R
import com.nayab.linearlayout.adapter.ExpenseAdapter
import com.nayab.linearlayout.data.ExpenseDatabase
import com.nayab.linearlayout.repository.ExpenseRepository
import com.nayab.linearlayout.utils.ReminderScheduler
import com.nayab.linearlayout.viewmodel.ExpenseViewModel
import com.nayab.linearlayout.viewmodel.ExpenseViewModelFactory
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    private lateinit var pieChart: PieChart
    private lateinit var btnAddExpense:Button
    private lateinit var tvTotal: TextView
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewModel: ExpenseViewModel
    private lateinit var adapter: ExpenseAdapter
    private lateinit var btnDaily: Button
    private lateinit var btnWeekly: Button
    private lateinit var btnMonthly: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Status bar dark fix
        window.statusBarColor = Color.BLACK
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility =
                window.decorView.systemUiVisibility and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
        }

        AndroidThreeTen.init(this)
        ReminderScheduler.scheduleDailyReminder(this)

        // Bind views
        pieChart = findViewById(R.id.pieChart)
        btnAddExpense = findViewById(R.id.btnAddExpense)
        tvTotal = findViewById(R.id.tvTotalExpense)
        recyclerView = findViewById(R.id.rvExpenses)
        btnDaily = findViewById(R.id.btnDaily)
        btnWeekly = findViewById(R.id.btnWeekly)
        btnMonthly = findViewById(R.id.btnMonthly)

        recyclerView.layoutManager = LinearLayoutManager(this)

        // ViewModel setup
        val dao = ExpenseDatabase.getDatabase(this).expenseDao()
        val repo = ExpenseRepository(dao)
        val factory = ExpenseViewModelFactory(repo)
        viewModel = ViewModelProvider(this, factory)[ExpenseViewModel::class.java]

        adapter = ExpenseAdapter(
            onEditClick = { expense ->
                val intent = Intent(this, AddExpenseActivity::class.java)
                intent.putExtra("id", expense.id)
                startActivity(intent)
            },
            onLongDelete = { expense ->
                viewModel.deleteExpense(expense)
                Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show()
            }
        )
        recyclerView.adapter = adapter

        // Default load all
        observeAllExpenses()

        // Filter buttons
        btnDaily.setOnClickListener { observeDailyExpenses() }
        btnWeekly.setOnClickListener { observeWeeklyExpenses() }
        btnMonthly.setOnClickListener { observeMonthlyExpenses() }

        // Add expense
        btnAddExpense.setOnClickListener {
            startActivity(Intent(this, AddExpenseActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        observeAllExpenses()
        setFilterButtonsVisible(true) // Restore buttons
    }

    private fun observeAllExpenses() {
        viewModel.getAllExpenses().observe(this) { list ->
            updateChart(list)
            adapter.submitList(list)
            updateTotal("Total", list)
            setFilterButtonsVisible(true)
        }
    }

    private fun observeDailyExpenses() {
        viewModel.getDailyExpenses().observe(this) { list ->
            updateChart(list)
            adapter.submitList(list)
            updateTotal("Today's", list)
            setFilterButtonsVisible(false)
        }
    }

    private fun observeWeeklyExpenses() {
        viewModel.getWeeklyExpenses().observe(this) { list ->
            updateChart(list)
            adapter.submitList(list)
            updateTotal("Weekly", list)
            setFilterButtonsVisible(false)
        }
    }

    private fun observeMonthlyExpenses() {
        viewModel.getMonthlyExpenses().observe(this) { list ->
            updateChart(list)
            adapter.submitList(list)
            updateTotal("Monthly", list)
            setFilterButtonsVisible(false)
        }
    }

    private fun updateTotal(label: String, list: List<com.nayab.linearlayout.data.ExpenseEntity>) {
        val total = list.sumOf { it.amount }
        tvTotal.text = "$label Spent: Rs ${String.format("%.2f", total)}"
    }

    private fun setFilterButtonsVisible(visible: Boolean) {
        val visibility = if (visible) View.VISIBLE else View.GONE
        btnDaily.visibility = visibility
        btnWeekly.visibility = visibility
        btnMonthly.visibility = visibility
        btnAddExpense.visibility = visibility
    }


    private fun updateChart(expenses: List<com.nayab.linearlayout.data.ExpenseEntity>) {
        val entries = expenses.groupBy { it.category }
            .map { (category, items) ->
                PieEntry(items.sumOf { it.amount }.toFloat(), category)
            }

        val dataSet = PieDataSet(entries, "")
        val pastelColors = listOf(
            Color.parseColor("#FF6B6B"), // Soft Red
            Color.parseColor("#4ECDC4"), // Teal
            Color.parseColor("#556270"), // Muted Blue-Gray
            Color.parseColor("#C7F464"), // Lime Green
            Color.parseColor("#FFCC5C"), // Warm Yellow
            Color.parseColor("#6C5B7B"), // Purple Gray
            Color.parseColor("#F67280")  // Coral Pink
        )
        dataSet.colors = pastelColors
        dataSet.setDrawValues(false)

        val data = PieData(dataSet)

        pieChart.data = data
        pieChart.setDrawEntryLabels(false)
        pieChart.description.isEnabled = false

        pieChart.legend.isEnabled = true
        pieChart.legend.textColor = Color.WHITE
        pieChart.legend.orientation = Legend.LegendOrientation.HORIZONTAL
        pieChart.legend.verticalAlignment = Legend.LegendVerticalAlignment.BOTTOM
        pieChart.legend.horizontalAlignment = Legend.LegendHorizontalAlignment.CENTER


        pieChart.invalidate()
    }
}
