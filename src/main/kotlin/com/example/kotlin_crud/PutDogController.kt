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
class PutDogController(
    private val jpaDogRepository: JpaDogRepository
) {
    @PutMapping("/dogs/{name}")
    fun updateDog(
        @PathVariable name: String,
        @RequestBody dogUpdateRequest: DogUpdateRequest
    ): ResponseEntity<JpaDog> {
        val selectedDog = jpaDogRepository.findByName(name)
        if (selectedDog == null) {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }

        val updatedDog = selectedDog.copy(
            name = dogUpdateRequest.newName,
            breed = dogUpdateRequest.breed,
            birthdate = dogUpdateRequest.birthDate,
            mother = dogUpdateRequest.mother,
            father = dogUpdateRequest.father
        )

        val savedDog = jpaDogRepository.save(updatedDog)
        return ResponseEntity(savedDog, HttpStatus.OK)
    }
}

data class DogUpdateRequest(
    val newName: String,
    val breed: String?,
    val birthDate: String?,
    val mother: String?,
    val father: String?
)

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