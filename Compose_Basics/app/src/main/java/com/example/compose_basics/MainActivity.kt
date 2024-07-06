package com.example.compose_basics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose_basics.ui.theme.Compose_BasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Compose_BasicsTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    ScreenLayout()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ScreenLayout()
}

@Composable
fun HeaderImage(modifier: Modifier = Modifier){
    val image = painterResource(id = R.drawable.composebasicsimg)

    Image(
        painter = image,
        contentDescription = stringResource(R.string.header_description),
        contentScale = ContentScale.Fit,
        modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 8.dp)
    )
}

@Composable
fun Title(message: String, modifier: Modifier = Modifier){
    Text(
        text = message,
        fontSize = 24.sp,
        modifier = Modifier.padding(8.dp)
    )
}

@Composable
fun Description(message: Array<String>, modifier: Modifier = Modifier){
    for(paragraph in message) {
        Text(
            text = paragraph,
            modifier = Modifier.padding(8.dp),
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun ScreenLayout(modifier: Modifier = Modifier){
    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxSize()
    ){
        HeaderImage()

        Title(stringResource(R.string.jetpack_compose_tutorial))

        Description(message = arrayOf(
                stringResource(R.string.jetpack_description),
                stringResource(R.string.jetpack_description2)
            )
        )
    }
}