package com.example.kotlin_crud

import org.springframework.data.jpa.repository.JpaRepository

interface JpaDogRepository: JpaRepository<JpaDog, String> {
    fun findByName(name: String): JpaDog?
}