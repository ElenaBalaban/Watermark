package watermark

import watermark.enums.FileFormat
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO
import kotlin.system.exitProcess

fun saveFile(newPicture: BufferedImage) {
    println("Input the output image filename (jpg or png extension):")
    val outputFilename: String = readln()
    if(outputFilename.split(".").last() !in listOf(FileFormat.JPG.type, FileFormat.PNG.type)) {
        println("The output file extension isn't \"jpg\" or \"png\".")
        exitProcess(8)
    }

    val outputFile = File(outputFilename)
    ImageIO.write(newPicture, outputFilename.split(".").last(), outputFile)

    println("The watermarked image $outputFilename has been created.")
}
