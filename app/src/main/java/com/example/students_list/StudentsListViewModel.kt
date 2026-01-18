package com.example.students_list

import androidx.lifecycle.ViewModel

class StudentsListViewModel : ViewModel() {

    val students = StudentsRepository.students
}
