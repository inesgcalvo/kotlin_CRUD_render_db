package com.example.kotlin_crud

import org.springframework.stereotype.Service
import jakarta.annotation.PostConstruct

@Service
class DogInitializationService(
    private val dogRepository: DogRepository,
    private val jpaDogRepository: JpaDogRepository
) {
    fun stringToInt(input: String): Int {
        return input.toInt()
    }
    @PostConstruct
    fun init() {
        val dogs = dogRepository.getAll()
        for (dog in dogs) {
            val primaryKey = stringToInt(dog.id)
            val jpaDog = JpaDog(primary_key = primaryKey, id = dog.id, name = dog.name, breed = dog.breed, birthdate = dog.birthDate, mother = dog.mother, father = dog.father)
            jpaDogRepository.save(jpaDog)
        }
    }
}