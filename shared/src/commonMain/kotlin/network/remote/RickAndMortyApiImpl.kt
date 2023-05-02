package network.remote

import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import network.model.BaseCharactersModel

class RickAndMortyApiImpl : RickAndMortyApiInterface {

    private fun HttpRequestBuilder.getCharactersList() {
        url {
            takeFrom("https://rickandmortyapi.com/api/character")
        }
    }

    override suspend fun getCharactersList(): BaseCharactersModel {
        return client.get {
            getCharactersList()
        }.body()
    }
}