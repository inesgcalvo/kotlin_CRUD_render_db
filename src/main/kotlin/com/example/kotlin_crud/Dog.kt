package com.example.kotlin_crud

import java.time.LocalDate
import java.time.ZonedDateTime

// un identificador (un número entero que lo genera la aplicación, no el usuario),
// un nombre (un string),
// una raza (un string),
// una fecha de nacimiento (un string en formato YYYY-MM-DD),
// un padre y una madre (que son otros perros y pueden ser nulos).

class Dog(var name: String,
          var breed: String?,
          var id: String,
          var birthDate: String,
          var mother: String?,
          var father: String?) {
    private var year = birthDate.substring(0, 4).toInt()
    private var month = birthDate.substring(5, 7).toInt()
    private var day = birthDate.substring(8).toInt()
    private var localDate = LocalDate.of(year, month, day)
    var age: Int = ZonedDateTime.now().year - localDate.year
    var isTrained: Boolean = false
    var isVaccinated: Boolean = false

    fun train() {
        isTrained = true
    }
    fun vaccinate() {
        isVaccinated = true
    }
}