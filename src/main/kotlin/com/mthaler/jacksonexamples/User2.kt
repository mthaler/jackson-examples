package com.mthaler.jacksonexamples

import com.fasterxml.jackson.annotation.JsonIgnoreType
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

class User2(val id: Int, val name: Name = Name("", "")) {

    @JsonIgnoreType
    data class Name(val firstName: String, val lastName: String)
}

fun User2.toJson(): String = jacksonObjectMapper().writeValueAsString(this)
fun String.toUser2(): User2 = jacksonObjectMapper().readValue(this, User2::class.java)