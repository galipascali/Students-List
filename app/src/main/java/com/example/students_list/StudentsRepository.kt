package com.example.students_list

object StudentsRepository {

    val students = mutableListOf(
        Student("1", "Alice", "123-456-7890", "123 Main St", false),
        Student("2", "Bob", "234-567-8901", "456 Park Ave", true),
        Student("3", "Charlie", "345-678-9012", "789 Elm St", false)
    )

    fun addStudent(student: Student) {
        students.add(student)
    }

    fun removeStudent(student: Student) {
        students.remove(student)
    }

    fun getStudentById(id: String): Student? {
        return students.find { it.id == id }
    }
}
