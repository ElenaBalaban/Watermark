package watermark.check

import java.awt.image.BufferedImage
import java.util.*
import kotlin.system.exitProcess

fun rgbCheck(watermark: BufferedImage): List<Int> {
    if (!watermark.colorModel.hasAlpha()) {
        println("Do you want to set a transparency color?")
        if (readln().lowercase(Locale.getDefault()) == "yes") {
            println("Input a transparency color ([Red] [Green] [Blue]):")
            val rgb = try {
                readln().split(" ").map { it.toInt() }
            } catch (e: Exception) {
                println("The transparency color input is invalid.")
                exitProcess(6)
            }
            if (rgb.size == 3 && rgb.all { it in 0..255 }) {
                return rgb
            } else {
                println("The transparency color input is invalid.")
                exitProcess(6)
            }
        }
        return listOf(0, 0, 0)
    }
    return listOf(0, 0, 0)
}