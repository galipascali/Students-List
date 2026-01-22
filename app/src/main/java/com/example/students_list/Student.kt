package com.example.students_list

data class Student(
    var id: String,
    var name: String,
    var phone: String,
    var address: String,
    var isChecked: Boolean,
    val imageResId: Int = R.drawable.default_avatar

)
