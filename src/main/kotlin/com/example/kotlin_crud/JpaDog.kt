package com.example.kotlin_crud

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity(name = "dogrepository")
@Table(name = "dogrepository", schema = "public")

data class JpaDog(
    @Id
    @Column(nullable = false)
    var primary_key: Int,

    @Column(nullable = false)
    var id: String?,

    @Column(nullable = false)
    var name: String,

    @Column(nullable = true)
    var breed: String?,

    @Column(nullable = false)
    var birthdate: String?,

    @Column(nullable = true)
    var mother: String?,

    @Column(nullable = true)
    var father: String?
)