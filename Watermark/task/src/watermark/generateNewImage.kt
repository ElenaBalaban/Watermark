package watermark

import watermark.check.checkPositionInput
import watermark.check.percentCheck
import watermark.check.rgbCheck
import watermark.enums.WmPositions
import java.awt.Color
import java.awt.image.BufferedImage

fun generateNewImage(
    image: BufferedImage,
    watermark: BufferedImage,
    alphaChannel: Boolean,
    diffs: List<Int>,
): BufferedImage {

    val rgb = rgbCheck(watermark)
    val weight = percentCheck()
    val position = checkPositionInput()
    val (difX, difY) = createDiffs(position, diffs[0], diffs[1])

    val myImage = BufferedImage(image.width, image.height, BufferedImage.TYPE_INT_ARGB)

    for (x in 0 until image.width) {
        for (y in 0 until image.height) {
            val img = Color(image.getRGB(x, y))
            val (wX, wY) = if (position == WmPositions.GRID.type) {
                x % watermark.width to y % watermark.height
            } else {
                x - difX to y - difY
            }

            val wtmk = if (wX in 0 until watermark.width && wY in 0 until watermark.height)
                Color(watermark.getRGB(wX, wY), alphaChannel)
            else
                Color(0, 0, 0, 0)

            val newColor = if (wtmk.alpha == 0 || wtmk.rgb == Color(rgb[0], rgb[1], rgb[2]).rgb) {
                img
            } else {
                Color(
                    (weight * wtmk.red + (100 - weight) * img.red) / 100,
                    (weight * wtmk.green + (100 - weight) * img.green) / 100,
                    (weight * wtmk.blue + (100 - weight) * img.blue) / 100
                )
            }
            myImage.setRGB(x, y, newColor.rgb)
        }
    }
    return myImage
}