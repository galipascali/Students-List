package com.example.students_list

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class StudentDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)
        supportActionBar?.title = "Student Details"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val studentId = intent.getStringExtra("STUDENT_ID") ?: return

        val student = StudentsRepository.getStudentById(studentId) ?: return

        val idTextView = findViewById<TextView>(R.id.idTextView)
        val nameTextView = findViewById<TextView>(R.id.nameTextView)
        val phoneTextView = findViewById<TextView>(R.id.phoneTextView)
        val addressTextView = findViewById<TextView>(R.id.addressTextView)
        val checkBox = findViewById<CheckBox>(R.id.checkBox)
        val editButton = findViewById<Button>(R.id.editButton)

        idTextView.text = "ID: ${student.id}"
        nameTextView.text = "Name: ${student.name}"
        phoneTextView.text = "Phone: ${student.phone}"
        addressTextView.text = "Address: ${student.address}"
        checkBox.isChecked = student.isChecked

        editButton.setOnClickListener {
            val intent = Intent(this, EditStudentActivity::class.java)
            intent.putExtra("STUDENT_ID", student.id)
            startActivityForResult(intent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1 && resultCode == RESULT_OK) {
            finish()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
