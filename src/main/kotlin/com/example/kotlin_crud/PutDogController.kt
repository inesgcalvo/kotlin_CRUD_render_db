package com.example.kotlin_crud

import org.springframework.web.bind.annotation.*

// http://127.0.0.1:8080/put/{NAME}/?newName={NEW_NAME}2&breed={BREED}&birthDate={BIRTHDATE}&mother={MOTHER}&father={FATHER}

@RestController
class PutDogController(
    private val dogRepository: DogRepository,
    private val jpaDogRepository: JpaDogRepository
) {

    @PutMapping("/put/{name}/")
    fun updateDog(
        @PathVariable name: String,
        @RequestParam("newName") newName: String,
        @RequestParam("breed") breed: String?,
        @RequestParam("birthDate") birthDate: String?,
        @RequestParam("mother", required = false) mother: String?,
        @RequestParam("father", required = false) father: String?
    ): JpaDog {
        val selectedDog = jpaDogRepository.findByName(name)

        val dog = JpaDog(
            primary_key = selectedDog!!.primary_key,
            id = selectedDog!!.id,
            name = newName,
            breed = breed,
            birthdate = birthDate,
            mother = mother,
            father = father)
        return jpaDogRepository.save(dog)
        }
    }