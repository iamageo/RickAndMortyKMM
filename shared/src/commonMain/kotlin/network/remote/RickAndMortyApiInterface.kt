package network.remote

import network.model.BaseCharactersModel

interface RickAndMortyApiInterface {

    suspend fun getCharactersList() : BaseCharactersModel

}