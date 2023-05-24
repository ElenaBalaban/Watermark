package watermark

import watermark.check.alphaChannelCheck
import watermark.enums.FileType


fun main() {
    val image = uploadFile(FileType.IMAGE)
    val watermark = uploadFile(FileType.WATERMARK)
    val diffs = compareFiles(image, watermark)
    val alphaChannel = alphaChannelCheck(watermark)
    val newPicture = generateNewImage(image, watermark, alphaChannel, diffs)
    saveFile(newPicture)
}

val map = buildMap<String, String> {
    putAll(
        mapOf(
            "Apple" to "Green",
            "Banana" to "Yellow",
            "Strawberry" to "Red"
        )
    )
}


