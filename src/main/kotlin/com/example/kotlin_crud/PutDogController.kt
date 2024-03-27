package com.example.kotlin_crud


import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.PathVariable
//import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import java.util.UUID

// http://127.0.0.1:8080/dogs/{id}/?newName={NAME}2&breed={BREED}&birthDate={BIRTHDATE}&mother={MOTHER}&father={FATHER}

@RestController
class UpdateDogController(
    private val jpaDogRepository: JpaDogRepository
) {
    @PutMapping("/dogs/{id}")
    fun updateDog(
        @PathVariable("id") id: UUID,
        @RequestBody dogRequest: DogRequest
    ): ResponseEntity<JpaDog> {
        val existingDog = jpaDogRepository.findById(id.toString())
        return if (existingDog.isPresent) {
            try {
                val dog = existingDog.get().apply {
                    name = dogRequest.name
                    breed = dogRequest.breed
                    birthdate = dogRequest.birthDate
                    mother = dogRequest.mother
                    father = dogRequest.father
                }
                val updatedDog = jpaDogRepository.save(dog)
                ResponseEntity(updatedDog, HttpStatus.OK)
            } catch (e: Exception) {
                ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
            }
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
}

//@RestController
//class PutDogController(
//    private val jpaDogRepository: JpaDogRepository
//) {
//    @PutMapping("/dogs/{name}")
//    fun updateDog(
//        @PathVariable name: String,
//        @RequestParam("newName") newName: String,
//        @RequestParam("breed") breed: String?,
//        @RequestParam("birthDate") birthDate: String?,
//        @RequestParam("mother", required = false) mother: String?,
//        @RequestParam("father", required = false) father: String?
//    ): JpaDog {
//        val selectedDog = jpaDogRepository.findByName(name)
//        val dog = JpaDog(
//            id = selectedDog!!.id,
//            name = newName,
//            breed = breed,
//            birthdate = birthDate,
//            mother = mother,
//            father = father)
//        return jpaDogRepository.save(dog)
//        }
//    }