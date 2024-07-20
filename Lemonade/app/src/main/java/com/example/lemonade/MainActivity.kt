package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme
import java.util.stream.IntStream.range

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                PageLayout()
            }
        }
    }
}

class LemonCard(val image: Int, val imageDescription: String, val message: String){
    constructor(image: Int, imageDescription: String, message: String, tapTimes: Int) : this(
        image = image,
        imageDescription = imageDescription,
        message = message
    )
}

val lemonCards: List<LemonCard> = listOf(
    LemonCard(
        image = R.drawable.lemon_tree,
        imageDescription = R.string.three_desc.toString(),
        message = R.string.three_text.toString()
    ),
    LemonCard(
        image = R.drawable.lemon_squeeze,
        imageDescription = R.string.lemon_desc.toString(),
        message = R.string.tap_the_lemon.toString(),
        tapTimes = 1
    ),
    LemonCard(
        image = R.drawable.lemon_drink,
        imageDescription = R.string.glass_with_lemon_juice_desc.toString(),
        message = R.string.drink_lemon.toString()
    ),
    LemonCard(
        image = R.drawable.lemon_restart,
        imageDescription = R.string.empty_glass_desc.toString(),
        message = R.string.empty_glass.toString()
    )
)

@Preview(showBackground = true)
@Composable
fun PageLayout() {


    Column(){
        Header()
        LemonadeContent()
    }
}

@Composable
fun Header(modifier: Modifier = Modifier){
    val haderColor: Color = Color(0xFFEBE195)

    Text(
        text = stringResource(id = R.string.app_name),
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .background(color = haderColor)
            .height(50.dp)
            .wrapContentSize(Alignment.Center),
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun LemonadeContent(modifier: Modifier = Modifier){
    val imgBackg: Color = Color(0xFFD2E7DA)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Button(
            shape = RoundedCornerShape(30.dp),
            colors = ButtonDefaults.buttonColors(imgBackg),
            onClick = {  }
        ) {
            Image(
                painter = painterResource(lemonCards.get(0).image),
                contentDescription = stringResource(id = R.string.three_desc),
                modifier = Modifier
                    .width(200.dp)
                    .height(230.dp),
            )
        }
        Text(
            text = stringResource(id = R.string.three_text),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp)
        )
    }
}

