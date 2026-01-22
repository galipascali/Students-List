package com.example.students_list

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val viewModel: StudentsListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.studentsRecyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = StudentsAdapter(viewModel.students)

        val addButton = findViewById<Button>(R.id.addStudentButton)
        addButton.setOnClickListener {
            val intent = Intent(this, NewStudentActivity::class.java)
            startActivity(intent)
        }


    }
    override fun onResume() {
        super.onResume()

        val recyclerView = findViewById<RecyclerView>(R.id.studentsRecyclerView)

        recyclerView.adapter = StudentsAdapter(viewModel.students)
    }

}