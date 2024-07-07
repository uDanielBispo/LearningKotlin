package com.example.compose_quadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose_quadrant.ui.theme.Compose_QuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Compose_QuadrantTheme {
                ScreenLayout()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenLayout() {
    data class QuadrantData(val Title: String, val Description: String, val BkgColor: Color)

    val Quadrant = listOf(
        QuadrantData(
            Title = "Text composable",
            Description = "Displays text and follows the recommended Material Design guidelines.",
            BkgColor = Color(0xFFEADDFF)
        ),
        QuadrantData(
            Title = "Image composable",
            Description = "Creates a composable that lays out and draws a given Painter class object.",
            BkgColor = Color(0xFFD0BCFF)
        ),
        QuadrantData(
            Title = "Row composable",
            Description = "A layout composable that places its children in a horizontal sequence.",
            BkgColor = Color(0xFFB69DF8)
        ),
        QuadrantData(
            Title = "Column composable",
            Description = "A layout composable that places its children in a vertical sequence.",
            BkgColor = Color(0xFFF6EDFF)
        )
    )

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(modifier = Modifier.weight(1f)){
            Box(modifier = Modifier.weight(1f)){
                QuadrantCard(
                    title = Quadrant.get(0).Title,
                    description = Quadrant.get(0).Description,
                    color = Quadrant.get(0).BkgColor,
                )
            }
            Box(modifier = Modifier.weight(1f)) {
                QuadrantCard(
                    title = Quadrant.get(1).Title,
                    description = Quadrant.get(1).Description,
                    color = Quadrant.get(1).BkgColor,
                )
            }
        }
        Row(modifier = Modifier.weight(1f)){
            Box(modifier = Modifier.weight(1f)) {
                QuadrantCard(
                    title = Quadrant.get(2).Title,
                    description = Quadrant.get(2).Description,
                    color = Quadrant.get(2).BkgColor,
                )
            }
            Box(modifier = Modifier.weight(1f)) {
                QuadrantCard(
                    title = Quadrant.get(3).Title,
                    description = Quadrant.get(3).Description,
                    color = Quadrant.get(3).BkgColor,
                )
            }
        }
    }
}


@Composable
fun QuadrantCard(title: String, description: String, color: Color, modifier: Modifier = Modifier){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .background(color = color)
            .padding(16.dp).fillMaxSize()
    ) {
        QuadrantTitle(title)
        QuadrantDescription(description)
    }
}

@Composable
fun QuadrantTitle(message: String, modifier: Modifier = Modifier){
    Text(
        text = message,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(bottom = 16.dp)
    )
}

@Composable
fun QuadrantDescription(message: String, modifier: Modifier = Modifier){
    Text(
        text = message,
        modifier = Modifier.padding(bottom = 16.dp),
        textAlign = TextAlign.Justify
    )
}