package com.mthaler.jacksonexamples

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class PrivateBean(private val id: Int, private val name: String)

fun PrivateBean.toJson(): String = jacksonObjectMapper().writeValueAsString(this)
fun String.toPrivateBean(): PrivateBean = jacksonObjectMapper().readValue(this, PrivateBean::class.java)