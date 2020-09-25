package com.amoskorir.data.mappers

import com.amoskorir.data.apiresponse.Data
import com.amoskorir.domain.models.Image

class ImageMapper {
    companion object {
        fun transform(it: Data): Image {
            return Image(it.id, it.link, it.title)
        }
    }
}