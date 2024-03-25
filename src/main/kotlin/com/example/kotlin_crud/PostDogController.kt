package com.example.kotlin_crud

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import java.util.UUID


// http://127.0.0.1:8080/post/dog?name={NAME}&breed={BREED}&birthDate={BIRTHDATE}&mother={MOTHER}&father={FATHER}

@RestController
class PostDogController(
    private val jpaDogRepository: JpaDogRepository
) {
    @PostMapping("/dogs")
    fun addDog(@RequestParam("name") name: String,
               @RequestParam("breed") breed: String,
               @RequestParam("birthDate") birthDate: String,
               @RequestParam("mother", required = false) mother: String?,
               @RequestParam("father", required = false) father: String?): ResponseEntity<JpaDog> {
        try {
            val uuid: String = UUID.randomUUID().toString()
            val dog = JpaDog(
                id = UUID.fromString(uuid),
                name = name,
                breed = breed,
                birthdate = birthDate,
                mother = mother,
                father = father
            )
            val savedDog = jpaDogRepository.save(dog)
            return ResponseEntity(savedDog, HttpStatus.CREATED)
        } catch (e: Exception) {
            return ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
}


