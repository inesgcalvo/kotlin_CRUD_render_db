package com.example.kotlin_crud

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import java.util.UUID
import java.net.URI

@RestController
class PostDogController(
    private val dogRepository: DogRepository
) {
    @PostMapping("/dogs")
    fun addDog(@RequestBody dogRequest: DogRequest): ResponseEntity<Dog> {
        try {
            val uuid = UUID.randomUUID()
            val dog = Dog(
                id = uuid,
                name = dogRequest.name,
                breed = dogRequest.breed,
                birthdate = dogRequest.birthDate,
                mother = dogRequest.mother,
                father = dogRequest.father
            )
            val savedDog = dogRepository.save(dog)
            val location = "/${savedDog.id}"

            return ResponseEntity.created(URI.create(location)).body(savedDog)
        } catch (e: Exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
        }
    }
}

data class DogRequest(val name: String,
                      val breed: String,
                      val birthDate: String,
                      val mother: String?,
                      val father: String?)