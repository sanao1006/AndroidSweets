package app.sanao1006.androidsweets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import app.sanao1006.androidsweets.nav.AndroidSweetsNavHost

@Composable
fun SweetsApp(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {},
        bottomBar = { Text(text = "hello")},
    ) { paddingValues->
        Column(modifier = modifier
            .fillMaxSize()
            .padding(paddingValues)) {
            AndroidSweetsNavHost()
        }
    }
}
