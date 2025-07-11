package com.nayab.linearlayout.ui

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.nayab.linearlayout.R
import com.nayab.linearlayout.data.ExpenseDatabase
import com.nayab.linearlayout.data.ExpenseEntity
import com.nayab.linearlayout.repository.ExpenseRepository
import com.nayab.linearlayout.viewmodel.ExpenseViewModel
import com.nayab.linearlayout.viewmodel.ExpenseViewModelFactory
import java.util.*

class AddExpenseActivity : AppCompatActivity() {

    private lateinit var viewModel: ExpenseViewModel
    private var isEditMode = false
    private var expenseId: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_expense)

        // ✅ ViewModel Setup (fixed shadowing issue)
        val dao = ExpenseDatabase.getDatabase(this).expenseDao()
        val repo = ExpenseRepository(dao)
        val factory = ExpenseViewModelFactory(repo)
        viewModel = ViewModelProvider(this, factory)[ExpenseViewModel::class.java]

        // UI References
        val etAmount = findViewById<EditText>(R.id.etAmount)
        val etCategory = findViewById<EditText>(R.id.etCategory)
        val etNote = findViewById<EditText>(R.id.etNote)
        val etDate = findViewById<EditText>(R.id.etDate)
        val btnSave = findViewById<Button>(R.id.btnSaveExpense)

        // Date Picker
        etDate.setOnClickListener {
            val calendar = Calendar.getInstance()
            DatePickerDialog(
                this,
                { _, year, month, dayOfMonth ->
                    val selectedDate = String.format("%04d-%02d-%02d", year, month + 1, dayOfMonth)
                    etDate.setText(selectedDate)
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

        // ✅ Check if in Edit Mode (fixed intent key)
        expenseId = intent.getIntExtra("expense_id", -1)
        if (expenseId != -1) {
            isEditMode = true
            viewModel.getExpenseById(expenseId).observe(this) { expense ->
                expense?.let {
                    etAmount.setText(it.amount.toString())
                    etCategory.setText(it.category)
                    etNote.setText(it.note)
                    etDate.setText(it.date)
                    btnSave.text = "Update Expense"
                }
            }
        }

        // ✅ Save Button Click with validation
        btnSave.setOnClickListener {
            val amount = etAmount.text.toString().toDoubleOrNull() ?: 0.0
            val category = etCategory.text.toString()
            val note = etNote.text.toString()
            val date = etDate.text.toString()

            // Basic field validation
            if (category.isBlank() || note.isBlank() || date.isBlank()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val expense = ExpenseEntity(
                id = if (isEditMode) expenseId else 0,
                amount = amount,
                category = category,
                note = note,
                date = date
            )

            if (isEditMode) {
                viewModel.updateExpense(expense)
                Toast.makeText(this, "Expense Updated", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.insertExpense(expense)
                Toast.makeText(this, "Expense Added", Toast.LENGTH_SHORT).show()
            }

            finish()
        }
    }
}
