package ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.seiko.imageloader.rememberAsyncImagePainter
import network.model.CharactersResult

@Composable
internal fun CharactersList(listItems: List<CharactersResult>, onclick: (id: Int) -> Unit) {
    LazyVerticalGrid(columns = GridCells.Fixed(2),
        modifier = Modifier.padding(start = 5.dp, end = 5.dp, top = 10.dp),
        content = {
            items(listItems.size) {
                val painter = listItems[it].image?.let { it1 -> rememberAsyncImagePainter(url = it1) }
                Column(
                    modifier = Modifier.padding(
                        start = 5.dp, end = 5.dp, top = 0.dp, bottom = 10.dp
                    )
                ) {
                    if (painter != null) {
                        Image(
                            painter = painter,
                            contentDescription = "Forest Image",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    }
                    Text("${listItems[it].name}")
                }
            }
        })
}