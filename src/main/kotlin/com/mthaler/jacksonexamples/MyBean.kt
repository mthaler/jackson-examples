package com.mthaler.jacksonexamples

import com.fasterxml.jackson.annotation.JsonGetter
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonSetter
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

@JsonInclude(JsonInclude.Include.NON_NULL)
class MyBean(val id: Int, var name: String?) {

    @JsonGetter("name")
    fun getTheName(): String? = name

    @JsonSetter("name")
    fun setTheName(name: String?) {
        this.name = name!!
    }
}

fun MyBean.toJson(): String = ObjectMapper().writeValueAsString(this)
fun String.toMyBean(): MyBean = jacksonObjectMapper().readerFor(MyBean::class.java).readValue(this)