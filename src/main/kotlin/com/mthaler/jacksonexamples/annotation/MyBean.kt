package com.mthaler.jacksonexamples.annotation

import com.fasterxml.jackson.annotation.JsonGetter

class MyBean(val id: Int, val name: String) {

    @JsonGetter("name")
    fun getTheName(): String = name
}