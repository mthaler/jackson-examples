package com.mthaler.jacksonexamples.annotation

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

class ExtendableBean(val name: String) {

    private var properties: MutableMap<String, String> = HashMap()

    @JsonAnySetter
    fun add(key: String, value: String) {
        properties.put(key, value)
    }

    @JsonAnyGetter
    fun getProperties(): Map<String, String> = properties
}

fun ExtendableBean.toJson(): String = jacksonObjectMapper().writeValueAsString(this)
fun String.toExtendableBean(): ExtendableBean = jacksonObjectMapper().readerFor(ExtendableBean::class.java).readValue<ExtendableBean>(this)