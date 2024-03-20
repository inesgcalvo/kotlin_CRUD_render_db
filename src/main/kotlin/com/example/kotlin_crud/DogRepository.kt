package com.example.kotlin_crud

import org.springframework.stereotype.Repository
import java.util.Hashtable

@Repository
class DogRepository {
    private val hashtable: Hashtable<String, Dog> = Hashtable()
    private var lastId: Int = 0

    init {
        val dog = Dog("Gauss", "German Shorthaired Pointer", "001", "2020-11-06", "Yara", null)
        dog.vaccinate()
        dog.train()
        add(dog)

        val dog2 = Dog("Manhattan", null, "002", "2012-06-15", null, null)
        dog2.vaccinate()
        dog2.train()
        add(dog2)

        val dog3 = Dog("Max", "Labrador Retriever", "003", "2019-05-15", null, "Buddy")
        add(dog3)

        val dog4 = Dog("Buddy", "Golden Retriever", "004", "2020-07-20", null, null)
        add(dog4)

        val dog5 = Dog("Bailey", "Beagle", "005", "2018-10-25", null, null)
        add(dog5)
    }

    fun add(dog: Dog) {
        val formattedId = String.format("%03d", ++lastId)
        dog.id = formattedId
        hashtable[dog.name] = dog
    }
    fun get(name: String): Dog? {
        return hashtable[name]
    }
    fun update(dog: Dog) {
        if (hashtable.containsKey(dog.name)) {
            hashtable[dog.name] = dog
        } else {
            println("We are very sorry to announce that in this dog house there is no dog called ${dog.name}.")
        }
    }
    fun delete(name: String) {
        hashtable.remove(name)
    }
    fun getAll(): MutableCollection<Dog> {
        return hashtable.values
    }
}
