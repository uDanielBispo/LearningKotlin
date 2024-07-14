package com.example.function_types_and_lambda_expressions

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.function_types_and_lambda_expressions.ui.theme.Function_Types_And_Lambda_ExpressionsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Function_Types_And_Lambda_ExpressionsTheme {
              main()
            }
        }
    }
}
fun main() {
    val treatFunction = trickOrTreat(false){"$it quarters"}
    val trickFunction = trickOrTreat(true, null)

    repeat(4){treatFunction()}
    trickFunction()
}

fun trickOrTreat(isTrick: Boolean, extraTreat: ((Int) -> String)?): () -> Unit {
    if(isTrick) {return trick}
    else{
        if(extraTreat != null) println(extraTreat(5))
        return treat
    }
}

val trick = {println("No treats!")}
val treat: () -> Unit = {println("Have a treat!")}


