package watermark.check

import kotlin.system.exitProcess

fun percentCheck(): Int{
    println("Input the watermark transparency percentage (Integer 0-100):")
    val percent = try {
        readln().toInt()
    } catch (e: Exception) {
        println("The transparency percentage isn't an integer number.")
        exitProcess(5)
    }
    if (percent !in 0..100) {
        println("The transparency percentage is out of range.")
        exitProcess(7)
    } else {
        return percent
    }
}