package com.example.kotlin_crud

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID

@Entity(name = "dogrepository")
@Table(name = "dogrepository", schema = "public")
data class JpaDog(
    @Id
    @Column(nullable = false)
    var id: UUID,

    @Column(nullable = false)
    var name: String,

    @Column(nullable = true)
    var breed: String?,

    @Column(nullable = true)
    var birthdate: String?,

    @Column(nullable = true)
    var mother: String?,

    @Column(nullable = true)
    var father: String?
) {
    fun copyWith(
        newId: UUID = this.id,
        newName: String = this.name,
        newBreed: String? = this.breed,
        newBirthdate: String? = this.birthdate,
        newMother: String? = this.mother,
        newFather: String? = this.father
    ): JpaDog {
        return JpaDog(newId, newName, newBreed, newBirthdate, newMother, newFather)
    }
}