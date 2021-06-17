package com.mthaler.jacksonexamples

import com.fasterxml.jackson.annotation.JacksonInject

class BeanWithInject(@JacksonInject val id: Int, val name: String)