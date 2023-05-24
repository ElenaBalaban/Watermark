package watermark

import java.awt.image.BufferedImage
import kotlin.system.exitProcess

fun compareFiles(image: BufferedImage, watermark: BufferedImage): List<Int> {
    if ((image.width <= watermark.width || image.height <= watermark.height)) {
        println("The watermark's dimensions are larger.")
        exitProcess(4)
    } else {
        return listOf(image.width - watermark.width, image.height - watermark.height)
    }
}