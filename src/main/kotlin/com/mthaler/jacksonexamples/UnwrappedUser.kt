package com.mthaler.jacksonexamples

import com.fasterxml.jackson.annotation.JsonUnwrapped
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

class UnwrappedUser(val id: Int, @JsonUnwrapped val name: Name) {

    data class Name(val firstName: String, val lastName: String)
}

fun UnwrappedUser.toJson(): String = jacksonObjectMapper().writeValueAsString(this)