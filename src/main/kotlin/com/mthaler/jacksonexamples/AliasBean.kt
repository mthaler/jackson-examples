package com.mthaler.jacksonexamples

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

class AliasBean(@JsonAlias("fname") val firstName: String, val lastName: String)

fun AliasBean.toJson(): String = jacksonObjectMapper().writeValueAsString(this)
fun String.toAliasBean(): AliasBean = jacksonObjectMapper().readValue(this, AliasBean::class.java)