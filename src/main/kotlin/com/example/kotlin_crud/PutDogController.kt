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
    private val dogRepository: DogRepository
) {
    @PutMapping("/dogs/{id}")
    fun updateDog(
        @PathVariable id: UUID,
        @RequestBody dogUpdateRequest: DogUpdateRequest
    ): ResponseEntity<Dog> {
        val selectedDogOptional = dogRepository.findById(id)
        if (selectedDogOptional.isEmpty) {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }

        val selectedDog = selectedDogOptional.get()
        val updatedDog = selectedDog.copyWith(
            newName = dogUpdateRequest.name,
            newBreed = dogUpdateRequest.breed,
            newBirthdate = dogUpdateRequest.birthDate,
            newMother = dogUpdateRequest.mother,
            newFather = dogUpdateRequest.father
        )

        val savedDog = dogRepository.save(updatedDog)
        return ResponseEntity(savedDog, HttpStatus.OK)
    }
}

data class DogUpdateRequest(
    val name: String,
    val breed: String?,
    val birthDate: String?,
    val mother: String?,
    val father: String?
)