package com.example.classes_in_kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.classes_in_kotlin.ui.theme.Classes_In_KotlinTheme
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Classes_In_KotlinTheme {
                main()
            }
        }
    }
}

open class SmartDevice protected constructor(val name: String, val category: String) {

    var deviceStatus = "on"
        protected set(value) {
            field = value
        }

    protected open val deviceType = "Unknown"

    open fun printDeviceInfo(){
        println("Device name: " + this.name + " \nCategory: " + this.category)
    }

    open fun turnOn(){
        deviceStatus = "on"
    }

    open fun turnOff(){
        deviceStatus = "off"
    }
}

// IS-A relationship
class SmartTvDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart TV"

    private var speakerVolume by RangeRegulator(initialValue = 50, minValue = 0, maxValue = 100)

    private var channelNumber by RangeRegulator(initialValue = 100, minValue = 0, maxValue = 200)


    override fun printDeviceInfo(){
        println("Device name: " + this.name + " \nCategory: " + this.category + " \nDevice type: " + this.deviceType)
    }

    fun increaseSpeakerVolume() {
        speakerVolume++
        println("Speaker volume increased to $speakerVolume.")
    }

    fun decreaseSpeakerVolume() {
        speakerVolume--
        println("Speaker volume decreased to $speakerVolume.")
    }

    fun nextChannel() {
        channelNumber++
        println("Channel number increased to $channelNumber.")
    }

    fun prevousChannel() {
        channelNumber--
        println("Channel number decreased to $channelNumber.")
    }

    override fun turnOn() {
        super.turnOn()
        println(
            "$name is turned on. Speaker volume is set to $speakerVolume and channel number is " +
                    "set to $channelNumber."
        )
    }

    override fun turnOff() {
        super.turnOff()
        println("$name turned off")
    }
}

// IS-A relationship
class SmartLightDevice(deviceName: String, deviceCategory: String) :
        SmartDevice(name = deviceName, category = deviceCategory){

    override val deviceType = "Smart Light"
    private var brightnessLevel by RangeRegulator(initialValue = 0, minValue = 0, maxValue = 100)


    override fun printDeviceInfo(){
        println("Device name: " + this.name + " \nCategory: " + this.category + " \nDevice type: " + this.deviceType)
    }

    fun increaseBrightness() {
        brightnessLevel++
        println("Brightness increased to $brightnessLevel.")
    }

    fun decreaseBrightness() {
        brightnessLevel--
        println("Brightness decreased to $brightnessLevel.")
    }

    override fun turnOn() {
        super.turnOn()
        brightnessLevel = 2
        println("$name turned on. The brightness level is $brightnessLevel.")
    }

    override fun turnOff() {
        super.turnOff()
        brightnessLevel = 0
        println("Smart Light turned off")
    }
}

// HAS-A relationship
class SmartHome(
    val smartTvDevice: SmartTvDevice,
    val smartLightDevice: SmartLightDevice
)
{

    var deviceTurnOnCount = 0
        private set

    fun turnOnTv() {
        if(this.smartTvDevice.deviceStatus == "off") {
            deviceTurnOnCount++
            smartTvDevice.turnOn()
        }else{print("This operation can't be done since the device is already on")}
    }

    fun turnOffTv() {
        if(this.smartLightDevice.deviceStatus == "on") {
            deviceTurnOnCount--
            smartTvDevice.turnOff()
        }else{print("This operation can't be done since the device is off")}
    }

    fun turnOnLight() {
        if(this.smartLightDevice.deviceStatus == "off") {
            deviceTurnOnCount++
            smartLightDevice.turnOn()
        }else{print("This operation can't be done since the device is already on")}
    }

    fun turnOffLight() {
        if(this.smartLightDevice.deviceStatus == "on") {
            deviceTurnOnCount--
            smartLightDevice.turnOff()
        }else{print("This operation can't be done since the device is off")}

    }

    fun increaseTvVolume() {
        if(this.smartTvDevice.deviceStatus == "on") {
            smartTvDevice.increaseSpeakerVolume()
        }else{print("This operation can't be done since the device is off")}
    }

    fun decreaseTvVolume() {
        if(this.smartTvDevice.deviceStatus == "on") {
            smartTvDevice.decreaseSpeakerVolume()
        }else{print("This operation can't be done since the device is off")}
    }

    fun changeTvChannelToNext() {
        if(this.smartTvDevice.deviceStatus == "on") {
            smartTvDevice.nextChannel()
        }else{print("This operation can't be done since the device is off")}
    }

    fun changeTvChannelToPrevious() {
        if(this.smartTvDevice.deviceStatus == "on") {
            smartTvDevice.prevousChannel()
        }else{print("This operation can't be done since the device is off")}
    }

    fun increaseLightBrightness() {
        if(this.smartLightDevice.deviceStatus == "on") {
            smartLightDevice.increaseBrightness()
        }else{print("This operation can't be done since the device is off")}

    }

    fun decreaseLightBrightness() {
        if(this.smartLightDevice.deviceStatus == "on") {
            smartLightDevice.decreaseBrightness()
        }else{print("This operation can't be done since the device is off")}

    }

    fun printSmartTvInfo(){
        this.smartTvDevice.printDeviceInfo()
    }

    fun printSmartLightInfo(){
        this.smartLightDevice.printDeviceInfo()
    }

    fun turnOffAllDevices() {
            turnOffTv()
            turnOffLight()
    }
}

class RangeRegulator(
    initialValue: Int,
    private val minValue: Int,
    private val maxValue: Int
) : ReadWriteProperty<Any?, Int>
{

    var fieldData = initialValue

    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldData
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if(value in minValue..maxValue){
            fieldData = value
        }
    }
}

fun main() {

    var smartDevice: SmartTvDevice = SmartTvDevice("Android TV", "Entertainment")
    smartDevice.turnOn()
    smartDevice.printDeviceInfo()
    smartDevice.decreaseSpeakerVolume()
    smartDevice.nextChannel()
    smartDevice.prevousChannel()
    smartDevice.printDeviceInfo()

    var smartDevice2: SmartLightDevice = SmartLightDevice("Google Light", "Utility")
    smartDevice2.turnOn()
    smartDevice2.printDeviceInfo()
    smartDevice2.decreaseBrightness()

    var smartHome: SmartHome = SmartHome(smartDevice, smartDevice2)
    smartHome.decreaseTvVolume()
    smartHome.changeTvChannelToPrevious()
    smartHome.printSmartTvInfo()
    smartHome.printSmartLightInfo()
    smartHome.decreaseLightBrightness()

}


class Carro{
    var nome: String? = ""
    var marca: String? = ""
    var modelo: String? = ""

    fun Andar(distancia: Number, unidade: String):String{
        return ("O carro " +this.nome+ " andou " + distancia.toString() + " " + unidade)
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val fucao = Carro()
    fucao.nome = "Fusca"
    fucao.modelo = "Ret"
    fucao.marca = "Wolkswagen"

    Text(text = fucao.Andar(30, "Km"))
}