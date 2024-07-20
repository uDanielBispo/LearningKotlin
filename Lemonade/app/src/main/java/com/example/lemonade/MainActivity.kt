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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
class LemonCard(val image: Int, val imageDescription: String, val message: String, var tapTimes: Int){
}

val lemonCards: List<LemonCard> = listOf(
    LemonCard(
        image = R.drawable.lemon_tree,
        imageDescription = R.string.three_desc.toString(),
        message = R.string.three_text.toString(),
        tapTimes = 0
    ),
    LemonCard(
        image = R.drawable.lemon_squeeze,
        imageDescription = R.string.lemon_desc.toString(),
        message = R.string.tap_the_lemon.toString(),
        tapTimes = (2..4).random()
    ),
    LemonCard(
        image = R.drawable.lemon_drink,
        imageDescription = R.string.glass_with_lemon_juice_desc.toString(),
        message = R.string.drink_lemon.toString(),
        tapTimes = 0
    ),
    LemonCard(
        image = R.drawable.lemon_restart,
        imageDescription = R.string.empty_glass_desc.toString(),
        message = R.string.empty_glass.toString(),
        tapTimes = 0
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
    var actualCard: Int by remember { mutableStateOf(0) }
    var lemons = lemonCards.get(1).tapTimes

    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Button(
            shape = RoundedCornerShape(30.dp),
            colors = ButtonDefaults.buttonColors(imgBackg),
            onClick = {
                when(actualCard){
                    0 -> actualCard++
                    1 -> if(lemons > 0){
                        lemons--
                        print(lemons)
                    }else{
                        actualCard++
                        print(actualCard)
                    }
                    2 -> actualCard++
                    else -> actualCard = 0
                }
            }
        ) {
            Image(
                painter = painterResource(lemonCards.get(actualCard).image),
                contentDescription = stringResource(id = lemonCards.get(actualCard).imageDescription.toInt()),
                modifier = Modifier
                    .width(200.dp)
                    .height(230.dp),
            )
        }
        Text(
            text = stringResource(id = lemonCards.get(actualCard).message.toInt()),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp)
        )
    }
}



