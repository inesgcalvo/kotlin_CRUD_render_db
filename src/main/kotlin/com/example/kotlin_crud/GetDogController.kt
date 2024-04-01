package com.example.kotlin_crud

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import java.util.UUID

@RestController
class GetDogByIdController(
    private val dogRepository: DogRepository
) {
    @GetMapping("/dogs/{id}")
    fun getDogById(@PathVariable id: UUID): ResponseEntity<Dog> {
        val dogOptional = dogRepository.findById(id)
        return dogOptional.map {
            ResponseEntity.ok(it)
        }.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null))
    }
}