package ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import moe.tlaster.precompose.navigation.Navigator
import network.ResponseState
import network.model.CharactersResult
import ui.component.CharactersList
import ui.component.ProgressIndicator

@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = HomeScreenViewModel()
) {
    LaunchedEffect(true) {
        viewModel.getCharactersList()
    }
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        viewModel.charactersResponse.collectAsState().value?.let {
            when (it) {
                is ResponseState.Loading -> {
                    ProgressIndicator()
                }

                is ResponseState.Success<List<CharactersResult>> -> {
                    CharactersList(it.data, { id -> })
                }

                is ResponseState.Error ->{
                    Text("Error :${it.exception}")
                }
            }
        }
    }

}