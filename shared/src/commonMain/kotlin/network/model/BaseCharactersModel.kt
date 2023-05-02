package network.model

import kotlinx.serialization.Serializable

@Serializable
class BaseCharactersModel(
   var info   : Info?= Info(),
   var results : List<CharactersResult> = arrayListOf()
)