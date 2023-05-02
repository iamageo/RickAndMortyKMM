package network.repository

import kotlinx.coroutines.flow.flow
import network.ResponseState
import network.remote.RickAndMortyApiImpl

class RickAndMortyRepository {

    private val api = RickAndMortyApiImpl()

    fun getCharactersList() = flow {
        emit(ResponseState.Loading)
        try {
            val result = api.getCharactersList()
            emit(ResponseState.Success(result.results))
        } catch (e: Exception) {
            emit(ResponseState.Error(e))
        }
    }

}