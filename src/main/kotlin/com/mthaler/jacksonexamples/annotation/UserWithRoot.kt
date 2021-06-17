package com.mthaler.jacksonexamples.annotation

import com.fasterxml.jackson.annotation.JsonRootName
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature

@JsonRootName(value = "user")
class UserWithRoot(val id: Int, val name: String)

fun UserWithRoot.toJson(): String {
    val mapper = ObjectMapper()
    mapper.enable(SerializationFeature.WRAP_ROOT_VALUE)
    return mapper.writeValueAsString(this)
}