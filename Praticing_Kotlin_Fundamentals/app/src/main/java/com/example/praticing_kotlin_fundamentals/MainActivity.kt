package com.example.praticing_kotlin_fundamentals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.praticing_kotlin_fundamentals.ui.theme.Praticing_Kotlin_FundamentalsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Praticing_Kotlin_FundamentalsTheme {
                exercise3()
            }
        }
    }
}

fun exercise1(){
    // Expected output:
    // You have 51 notifications.
    // Your phone is blowing up! You have 99+ notifications.

    fun printNotificationSummary(numberOfMessages: Int) {
        if(numberOfMessages > 99) println("Your phone is blowing up! You have 99+ notifications.")
        else println("You have $numberOfMessages notifications")
    }

    val morningNotification = 51
    val eveningNotification = 135

    printNotificationSummary(morningNotification)
    printNotificationSummary(eveningNotification)
}

fun exercise2(){
    // Spected output:
    // The movie ticket price for a person aged 5 is $15.
    // The movie ticket price for a person aged 28 is $25.
    // The movie ticket price for a person aged 87 is $20.
    fun ticketPrice(age: Int, isMonday: Boolean): Int {
        if(age in 0..100)
            when (age){
                in 0..12 -> return 15
                in 13..60 -> if(isMonday) return 25 else return 30
                else -> return 20
            }
        else return -1
    }

    val child = 5
    val adult = 28
    val senior = 87

    val isMonday = true

    println("The movie ticket price for a person aged $child is \$${ticketPrice(child, isMonday)}.")
    println("The movie ticket price for a person aged $adult is \$${ticketPrice(adult, isMonday)}.")
    println("The movie ticket price for a person aged $senior is \$${ticketPrice(senior, isMonday)}.")

}

fun exercise3(){
    // Spected output:
    // 27.0 degrees Celsius is 80.60 degrees Fahrenheit.
    // 350.0 degrees Kelvin is 76.85 degrees Celsius.
    // 10.0 degrees Fahrenheit is 260.93 degrees Kelvin.

    fun printFinalTemperature(
        initialMeasurement: Double,
        initialUnit: String,
        finalUnit: String,
        conversionFormula: (Double) -> Double = {
            if (initialUnit == "Celsius" && finalUnit == "Fahrenheit") {
                (9.0 / 5.0) * it + 32
            } else if (initialUnit == "Kelvin" && finalUnit == "Celsius") {
                it - 273.15
            } else if (initialUnit == "Fahrenheit" && finalUnit == "Kelvin") {
                (5.0 / 9.0) * (it - 32.0) + 273.15
            } else {
                -1.0
            }
        }
    ) {
        val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement)) // two decimal places
        println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
    }

        printFinalTemperature(27.0, initialUnit = "Celsius", finalUnit = "Fahrenheit")
        printFinalTemperature(350.0, initialUnit = "Kelvin", finalUnit = "Celsius")
        printFinalTemperature(10.0, initialUnit = "Fahrenheit", finalUnit = "Kelvin")
}

fun ecercise4(){

    class Song internal constructor(
        title: String,
        artist: String,
        publishedYear: String,
        playCount: Int
    ){
        internal val title: String = title
        internal val artist: String = artist
        internal val publishedYear: String = publishedYear
        internal val playCount: Int = playCount
        internal val isPopular: Boolean = if(playCount > 1000) true else false

        internal fun printSong(){
            print("${this.title}, performed by ${this.artist}, was released in ${this.publishedYear}." +
                    "\n This song is considered: " +
                    "${if (isPopular) "Polular" else "Unpopular"}")
        }
    }


    val song1: Song = Song(title = "Song1", artist = "Daniel", publishedYear = "2024", playCount = 2)
    print(song1.title)
}

fun exercise5(){
    // Spected output:
    // Name: Amanda
    // Age: 33
    // Likes to play tennis. Doesn't have a referrer.

    // Name: Atiqah
    // Age: 28
    // Likes to climb. Has a referrer named Amanda, who likes to play tennis.

class Person(val name: String, val age: Int, val hobby: String?, val referrer: Person?) {
    fun showProfile() {
        println("Name: ${this.name}\n" +
                "Age: ${this.age}\n" +
                "Likes to ${this.hobby}. ${if(this.referrer != null)
                    "Has a referrer named ${referrer.name}, who likes to ${referrer.hobby}"
                else "Doesn't have a referrer"}.\n")
        }
    }

    val amanda = Person("Amanda", 33, "play tennis", null)
    val atiqah = Person("Atiqah", 28, "climb", amanda)

    amanda.showProfile()
    atiqah.showProfile()
}

fun exercise6(){
    open class Phone(var isScreenLightOn: Boolean = false){
        open fun switchOn() {
            isScreenLightOn = true
        }

        fun switchOff() {
            isScreenLightOn = false
        }

        fun checkPhoneScreenLight() {
            val phoneScreenLight = if (isScreenLightOn) "on" else "off"
            println("The phone screen's light is $phoneScreenLight.")
        }
    }

    class foldablePhone(isScreenLightOn: Boolean = false, var isFolded: Boolean) :
        Phone(isScreenLightOn = isScreenLightOn){
            override fun switchOn(){
                if(isFolded) isScreenLightOn = true
            }

            fun foldPhone(){
                var isNotFolded: Boolean = !isFolded
                if(isNotFolded) isFolded = true
            }

            fun unFoldPhone(){
                if(isFolded) isFolded = false
            }

        }
}

fun exercise7(){
    val winningBid = Bid(5000, "Private Collector")

    println("Item A is sold at ${auctionPrice(winningBid, 2000)}.")
    println("Item B is sold at ${auctionPrice(null, 3000)}.")
}

class Bid(val amount: Int, val bidder: String)

fun auctionPrice(bid: Bid?, minimumPrice: Int): Int {
    if(bid != null)
        return bid.amount
    else
        return minimumPrice
}