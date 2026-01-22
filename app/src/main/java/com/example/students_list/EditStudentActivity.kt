package com.example.students_list

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class EditStudentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_student)
        supportActionBar?.title = "Edit Student"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val studentId = intent.getStringExtra("STUDENT_ID") ?: return

        val student = StudentsRepository.getStudentById(studentId) ?: return

        val idEditText = findViewById<EditText>(R.id.idEditText)
        val nameEditText = findViewById<EditText>(R.id.nameEditText)
        val phoneEditText = findViewById<EditText>(R.id.phoneEditText)
        val addressEditText = findViewById<EditText>(R.id.addressEditText)
        val checkBox = findViewById<CheckBox>(R.id.checkBox)
        val saveButton = findViewById<Button>(R.id.saveButton)
        val deleteButton = findViewById<Button>(R.id.deleteButton)

        idEditText.setText(student.id)
        nameEditText.setText(student.name)
        phoneEditText.setText(student.phone)
        addressEditText.setText(student.address)
        checkBox.isChecked = student.isChecked

        saveButton.setOnClickListener {
            student.id = idEditText.text.toString()
            student.name = nameEditText.text.toString()
            student.phone = phoneEditText.text.toString()
            student.address = addressEditText.text.toString()
            student.isChecked = checkBox.isChecked

            setResult(RESULT_OK)
            finish()
        }

        deleteButton.setOnClickListener {
            StudentsRepository.removeStudent(student)
            setResult(RESULT_OK)
            finish()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
