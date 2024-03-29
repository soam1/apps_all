package com.akashsoam.composabletest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.akashsoam.composabletest.ui.theme.ComposableTestTheme
import com.akashsoam.composabletest.ui.theme.color1
import com.akashsoam.composabletest.ui.theme.color2

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposableTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center) {

//                        Greeting("Android")
//                        CustomText(text = "Akash Soam")
//                        CoilImage()
                        GradientButton(
                            text = "Button",
                            textColor = Color.White,
                            gradient = Brush.horizontalGradient(
                                colors = listOf(
                                    color1, color2
                                )
                            )
                        ) {

                        }

                    }
                }
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {


//        Greeting()

//        CustomText()
//    Greeting2()


}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Box(
            modifier = Modifier
                .background(Color.Blue)
                .width(100.dp)
                .height(100.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text("I love Android", fontSize = 60.sp)

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting2() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        var password by rememberSaveable {
            mutableStateOf("")
        }

        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
            },
            placeholder = {
                Text(text = "Password")
            },
            label = { Text(text = "Password") },
            trailingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
//                    Icon(
//                    )
                }
            }

        )


    }
}

@Composable
fun CustomText() {

    SelectionContainer {
        Column {
            Text(text = "Hello world!")
            DisableSelection {
                Text(text = "Hello world!")
            }
            Text(text = "Hello world!")
        }
    }
}


@Composable
fun ColumnScope.CustomItem(weight: Float, color: Color) {
    Surface(
        modifier = Modifier
            .width(200.dp)
            .height(50.dp)
            .weight(weight), color = color
    ) {

    }
}

@Composable
fun CoilImage() {
    Box(
        modifier = Modifier
            .width(150.dp)
            .height(150.dp),
        contentAlignment = Alignment.Center
    ) {
        val painter =
            rememberAsyncImagePainter(
                ImageRequest.Builder(LocalContext.current)
                    .data(data = "https://mcdn.wallpapersafari.com/medium/78/3/G5jsyL.png")
                    .apply(block = fun ImageRequest.Builder.() {
//                        placeholder(R.drawable.ic_placeholder)
                    }).build()
            )
        val painterState = painter.state
        Image(painter = painter, contentDescription = "Logo image")
        if (painterState is AsyncImagePainter.State.Loading) {
            CircularProgressIndicator()
        }

    }
}