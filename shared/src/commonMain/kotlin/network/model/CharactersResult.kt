package network.model

import kotlinx.serialization.Serializable

@Serializable
data class CharactersResult(
    var id       : Int?              = null,
    var name     : String?           = null,
    var status   : String?           = null,
    var species  : String?           = null,
    var type     : String?           = null,
    var gender   : String?           = null,
    var origin   : Origin?           = Origin(),
    var location : Location?         = Location(),
    var image    : String?           = null,
    var episode  : List<String> = arrayListOf(),
    var url      : String?           = null,
    var created  : String?           = null
)