package network.model

import kotlinx.serialization.Serializable

@Serializable
data class Info (
    var count : Int? = 0,
    var pages : Int? = 0,
    var next  : String? = "",
    var prev  : String? = ""
)
