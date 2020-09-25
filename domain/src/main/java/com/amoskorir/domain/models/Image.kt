package com.amoskorir.domain.models

import java.io.Serializable

data class Image(
    val id: String,
    val link: String,
    val title: String
) : Serializable