package com.mthaler.jacksonexamples.annotation

import com.fasterxml.jackson.annotation.JacksonInject

class BeanWithInject(@JacksonInject val id: Int, val name: String)