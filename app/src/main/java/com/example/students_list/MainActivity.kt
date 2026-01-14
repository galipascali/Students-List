package com.example.students_list

import android.os.Bundle
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
            Student("1", "Alice", "123-456-7890", "123 Main St", false),
            Student("2", "Bob", "234-567-8901", "456 Park Ave", true),
            Student("3", "Charlie", "345-678-9012", "789 Elm St", false)
        )

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = StudentsAdapter(students)
    }

}