package watermark.check

import java.awt.image.BufferedImage
import java.util.*

fun alphaChannelCheck(watermark: BufferedImage):Boolean {

    return if (watermark.colorModel.hasAlpha()) {
        println("Do you want to use the watermark's Alpha channel?")
        val value = readln().lowercase(Locale.getDefault())
        value == "yes"
    } else {
        false
    }
}
