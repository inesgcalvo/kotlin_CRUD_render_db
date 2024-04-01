package com.example.kotlin_crud

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
class DelDogController(
    private val dogRepository: DogRepository
) {
    @DeleteMapping("/dogs/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteDogById(@PathVariable id: UUID) {
        if (dogRepository.existsById(id)) {
            dogRepository.deleteById(id)
        } else {
            throw DogNotFoundException("Dog with ID $id not found")
        }
    }
}

@ResponseStatus(HttpStatus.NOT_FOUND)
class DogNotFoundException(message: String) : RuntimeException(message)