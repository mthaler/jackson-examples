package com.mthaler.jacksonexamples.annotation

import com.fasterxml.jackson.annotation.JsonRootName

@JsonRootName(value = "user")
class UserWithRoot(val id: Int, val name: String)