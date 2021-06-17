package com.mthaler.jacksonexamples.annotation

import com.fasterxml.jackson.annotation.JsonAnyGetter

class ExtendableBean(val name: String) {

    private var properties: MutableMap<String, String> = HashMap()

    fun add(key: String, value: String) {
        properties.put(key, value)
    }

    @JsonAnyGetter
    fun getProperties(): Map<String, String> = properties
}