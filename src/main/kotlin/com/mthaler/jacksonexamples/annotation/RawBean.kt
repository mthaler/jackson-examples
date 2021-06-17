package com.mthaler.jacksonexamples.annotation

import com.fasterxml.jackson.annotation.JsonRawValue
import com.fasterxml.jackson.databind.ObjectMapper

class RawBean(val name: String, @JsonRawValue val json: String)

fun RawBean.toJson(): String = ObjectMapper().writeValueAsString(this)