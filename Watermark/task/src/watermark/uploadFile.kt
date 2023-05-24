package watermark

import watermark.enums.FileType
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO
import kotlin.system.exitProcess

val VALID_SIZE = listOf(24, 32)

fun uploadFile(type: FileType): BufferedImage {

    when (type) {
        FileType.IMAGE -> println("Input the image filename:")
        FileType.WATERMARK -> println("Input the watermark image filename:")
    }

    val imageFileName = readln()
    if (!File(imageFileName).exists()) {
        println("The file $imageFileName doesn't exist.")
        exitProcess(1)
    }

    val file: BufferedImage = ImageIO.read(File(imageFileName))
    if (file.colorModel.numColorComponents != 3) {
        println("The number of $type color components isn't 3.")
        exitProcess(2)
    } else if (file.colorModel.pixelSize !in VALID_SIZE) {
        println("The $type isn't 24 or 32-bit.")
        exitProcess(3)
    }

    return file
}
