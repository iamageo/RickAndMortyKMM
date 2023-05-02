package ui

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import moe.tlaster.precompose.viewmodel.ViewModel
import network.ResponseState
import network.model.CharactersResult
import network.repository.RickAndMortyRepository

class HomeScreenViewModel: ViewModel() {

    private val viewModelScope = CoroutineScope(Dispatchers.Main)
    private val repo = RickAndMortyRepository()
    val charactersResponse = MutableStateFlow<ResponseState<List<CharactersResult>>>(ResponseState.Loading)

    fun getCharactersList() {
        viewModelScope.launch(Dispatchers.Main) {
            repo.getCharactersList().collectLatest {
                charactersResponse.value = it
            }
        }
    }

}