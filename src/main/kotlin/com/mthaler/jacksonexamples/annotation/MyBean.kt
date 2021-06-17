package com.mthaler.jacksonexamples.annotation

import com.fasterxml.jackson.annotation.JsonGetter
import com.fasterxml.jackson.databind.ObjectMapper

class MyBean(val id: Int, val name: String) {

    @JsonGetter("name")
    fun getTheName(): String = name
}

fun MyBean.toJson(): String = ObjectMapper().writeValueAsString(this)