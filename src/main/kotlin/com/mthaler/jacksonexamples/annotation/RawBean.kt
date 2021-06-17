package com.mthaler.jacksonexamples.annotation

import com.fasterxml.jackson.annotation.JsonRawValue

class RawBean(val name: String, @JsonRawValue val json: String)