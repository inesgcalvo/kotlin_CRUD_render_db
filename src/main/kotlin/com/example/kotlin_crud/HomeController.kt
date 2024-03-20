package com.example.kotlin_crud

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HomeController {
    @GetMapping("/")
    fun execute(): String {
        return "HOME"
    }
}