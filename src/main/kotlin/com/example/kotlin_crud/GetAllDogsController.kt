package com.example.kotlin_crud

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GetAllDogsController(
    private val dogRepository: DogRepository
) {
    @GetMapping("/dogs")
    fun showThemAll(): MutableList<Dog> {
        return dogRepository.findAll()
    }
}