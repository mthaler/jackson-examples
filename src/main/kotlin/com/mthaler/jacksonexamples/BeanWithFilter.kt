package com.mthaler.jacksonexamples

import com.fasterxml.jackson.annotation.JsonFilter

@JsonFilter("myFilter")
class BeanWithFilter(val id: Int, val name: String)