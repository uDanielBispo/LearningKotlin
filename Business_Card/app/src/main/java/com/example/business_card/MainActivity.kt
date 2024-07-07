package com.example.business_card

import android.graphics.Paint.Align
import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.business_card.ui.theme.Business_CardTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Search
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Business_CardTheme {
                ScreenLayout()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenLayout() {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PresentationCard()
        ContactCards()
    }
}

@Composable
fun PresentationCard(modifier: Modifier = Modifier){
    Column(
        modifier = Modifier.padding(16.dp).padding(bottom = 100.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            Icons.Rounded.Person,
            contentDescription = "Localized description",
            modifier = Modifier.size(100.dp),
            tint = Color.DarkGray
        )
        PresentationCardTitle("Daniel Bispo")
        PresentationCardSubTitle("Business Card")
    }

}

@Composable
fun PresentationCardTitle(message: String){
    Text(
        text = message,
        fontSize = 45.sp,
        fontWeight = FontWeight.Bold,
        color = Color.DarkGray
    )
}

@Composable
fun PresentationCardSubTitle(message: String){
    Text(
        text = message,
        fontSize = 20.sp,
        color = Color.DarkGray
    )
}

@Composable
fun DetailsText(message: String){
    Text(
        text = message
    )
}

@Composable
fun ContactCards(){
    Column() {
        SingleContactCard(
            message = "+55 (15) 996000216",
            icon = Icons.Rounded.Phone,
            description = "Phone Contact"
        )
        SingleContactCard(
            message = "danielbispo3015@hotmail.com",
            icon = Icons.Rounded.Email,
            description = "Email contact"
        )
        SingleContactCard(
            message = "@uDanielBispo (GitHub)",
            icon = Icons.Rounded.Search,
            description = "Test"
        )

    }
}

@Composable
fun SingleContactCard(message: String, icon: ImageVector, description: String){
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            icon,
            contentDescription = description,
            modifier = Modifier.size(50.dp).padding(end = 10.dp),
            tint = Color.DarkGray
        )
        ContactCardText(message)
    }
}

@Composable
fun ContactCardText(message: String){
    Text(
        text = message,
        fontSize = 18.sp,
        color = Color.DarkGray

    )
}