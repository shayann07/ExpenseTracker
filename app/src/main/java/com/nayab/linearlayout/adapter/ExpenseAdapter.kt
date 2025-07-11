package com.nayab.linearlayout.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nayab.linearlayout.R
import com.nayab.linearlayout.data.ExpenseEntity

class ExpenseAdapter(
    private val onEditClick: (ExpenseEntity) -> Unit,
    private val onLongDelete: (ExpenseEntity) -> Unit
) : RecyclerView.Adapter<ExpenseAdapter.ExpenseViewHolder>() {

    private var expenses = listOf<ExpenseEntity>()

    inner class ExpenseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvAmount: TextView = itemView.findViewById(R.id.tvAmount)
        val tvCategory: TextView = itemView.findViewById(R.id.tvCategory)
        val tvDate: TextView = itemView.findViewById(R.id.tvDate)
        val tvNote: TextView = itemView.findViewById(R.id.tvNote)

        init {
            itemView.setOnClickListener {
                onEditClick(expenses[adapterPosition])
            }
            itemView.setOnLongClickListener {
                onLongDelete(expenses[adapterPosition])
                true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.expense_item, parent, false)
        return ExpenseViewHolder(view)
    }

    override fun getItemCount(): Int = expenses.size

    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) {
        val expense = expenses[position]
        holder.tvAmount.text = "Rs ${expense.amount}"
        holder.tvCategory.text = expense.category
        holder.tvDate.text = expense.date
        holder.tvNote.text = expense.note
    }

    fun submitList(list: List<ExpenseEntity>) {
        expenses = list
        notifyDataSetChanged()
    }
}
