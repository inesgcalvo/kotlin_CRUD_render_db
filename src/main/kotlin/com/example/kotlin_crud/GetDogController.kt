package com.example.kotlin_crud

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.util.UUID
import java.util.Optional

@RestController
class GetDogByIdController(
    private val jpaDogRepository: JpaDogRepository
) {
    @GetMapping("/dogs/{id}")
    fun getDogById(@PathVariable id: UUID): Optional<JpaDog> {
        return jpaDogRepository.findById(id.toString())
    }
}