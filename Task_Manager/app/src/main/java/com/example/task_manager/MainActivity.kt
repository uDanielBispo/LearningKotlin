package com.example.task_manager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.task_manager.ui.theme.Task_ManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Task_ManagerTheme {
                ScreenLayout()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenLayout(modifier: Modifier = Modifier){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        TaskCompletedImg()
        FirstText(message = stringResource(R.string.all_task_completed))
        SecondText(message = stringResource(R.string.nice_work))
    }
}

@Composable
fun TaskCompletedImg(modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.taskmanagerimg)

    Image(
        painter = image,
        contentDescription = stringResource(R.string.task_completed_img_description)
    )
}

@Composable
fun FirstText(message: String, modifier: Modifier = Modifier){
    Text(
        text = message,
        modifier = Modifier.padding(0.dp, 24.dp, 0.dp, 8.dp),
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun SecondText(message: String, modifier: Modifier = Modifier){
    Text(
        text = message,
        fontSize = 16.sp
    )
}