package com.example.students_list

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class NewStudentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_student)
        supportActionBar?.title = "New Student"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val idEditText = findViewById<EditText>(R.id.idEditText)
        val nameEditText = findViewById<EditText>(R.id.nameEditText)
        val phoneEditText = findViewById<EditText>(R.id.phoneEditText)
        val addressEditText = findViewById<EditText>(R.id.addressEditText)
        val saveButton = findViewById<Button>(R.id.saveButton)

        saveButton.setOnClickListener {
            val id = idEditText.text.toString()
            val name = nameEditText.text.toString()
            val phone = phoneEditText.text.toString()
            val address = addressEditText.text.toString()

            if (id.isNotEmpty() && name.isNotEmpty()) {
                // Add new student to repository
                val newStudent = Student(id, name, phone, address, false)
                StudentsRepository.addStudent(newStudent)

                // Close this activity and return to list
                finish()
            } else {
                // Show a simple error
                if (id.isEmpty()) idEditText.error = "ID required"
                if (name.isEmpty()) nameEditText.error = "Name required"
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
