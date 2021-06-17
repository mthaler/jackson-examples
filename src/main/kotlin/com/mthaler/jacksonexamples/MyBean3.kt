package com.mthaler.jacksonexamples

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

class MyBean3(val id: Int, private var name: String) {

    @JsonProperty("name")
    fun setTheName(name: String) {
        this.name = name
    }

    @JsonProperty("name")
    fun getTheName(): String {
        return name
    }
}

fun MyBean3.toJson(): String = ObjectMapper().writeValueAsString(this)
fun String.toMyBean3(): MyBean3 = jacksonObjectMapper().readerFor(MyBean3::class.java).readValue(this)
