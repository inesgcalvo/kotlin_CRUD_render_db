package com.example.kotlin_crud

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GetAllDogsController(
    private val jpaDogRepository: JpaDogRepository
) {
    @GetMapping("/dogs")
    fun showThemAll(): MutableList<JpaDog> {
        return jpaDogRepository.findAll()
    }
}