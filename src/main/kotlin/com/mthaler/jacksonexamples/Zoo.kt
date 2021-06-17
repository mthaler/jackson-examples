package com.mthaler.jacksonexamples

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.fasterxml.jackson.annotation.JsonTypeName
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

class Zoo(val animal: Animal) {

    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
    @JsonSubTypes(
        JsonSubTypes.Type(value = Dog::class, name = "dog"),
        JsonSubTypes.Type(value = Cat::class, name = "cat")
    )
    sealed abstract class Animal(name: String)
    @JsonTypeName("dog")
    data class Dog(val name: String, val barkVolume: Double): Animal(name)
    @JsonTypeName("cat")
    data class Cat(val name: String, val likesCream: Boolean): Animal(name)
}

fun Zoo.toJson(): String = jacksonObjectMapper().writeValueAsString(this)
fun String.toZoo(): Zoo = jacksonObjectMapper().readValue(this, Zoo::class.java)