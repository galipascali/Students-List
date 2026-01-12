package com.example.students_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.studentsRecyclerView)

        // Dummy data (temporary)
        val students = mutableListOf(
            Pair("Alice", false),
            Pair("Bob", true),
            Pair("Charlie", false)
        )

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = StudentsAdapter(students)
    }

    class StudentsAdapter(
        private val students: MutableList<Pair<String, Boolean>>
    ) : RecyclerView.Adapter<StudentsAdapter.StudentViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.student_row, parent, false)
            return StudentViewHolder(view)
        }

        override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
            val student = students[position]
            holder.nameTextView.text = student.first
            holder.checkBox.isChecked = student.second

            holder.checkBox.setOnCheckedChangeListener { _, isChecked ->
                students[position] = student.copy(second = isChecked)
            }
        }

        override fun getItemCount() = students.size

        class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
            val checkBox: CheckBox = itemView.findViewById(R.id.checkBox)
        }
    }
}
