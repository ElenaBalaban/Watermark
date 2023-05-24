package watermark

import watermark.enums.WmPositions
import kotlin.system.exitProcess

fun createDiffs(position: String, diffX: Int, diffY: Int): List<Int> {

    if (position == WmPositions.GRID.type) {
        return listOf(0, 0)
    } else {
        println("Input the watermark position ([x 0-$diffX] [y 0-$diffY]):")
        val input = readln()

        val list = try {
            input.split(" ").map { it.toInt() }
        } catch (e: Exception) {
            println("The position input is invalid.")
            exitProcess(9)
        }
        if (list[0] in 0..diffX && list[1] in 0..diffY) {
            return list
        } else {
            println("The position input is out of range.")
            exitProcess(10)
        }
    }
}