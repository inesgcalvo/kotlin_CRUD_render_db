package com.example.kotlin_crud

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import java.util.UUID

@RestController
class PutDogController(
    private val jpaDogRepository: JpaDogRepository
) {
    @PutMapping("/dogs/{id}")
    fun updateDog(
        @PathVariable id: UUID,
        @RequestBody dogUpdateRequest: DogUpdateRequest
    ): ResponseEntity<JpaDog> {
        val selectedDogOptional = jpaDogRepository.findById(id.toString())
        if (selectedDogOptional.isEmpty) {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }

        val selectedDog = selectedDogOptional.get()
        val updatedDog = selectedDog.copyWith(
            newName = dogUpdateRequest.newName,
            newBreed = dogUpdateRequest.breed,
            newBirthdate = dogUpdateRequest.birthDate,
            newMother = dogUpdateRequest.mother,
            newFather = dogUpdateRequest.father
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