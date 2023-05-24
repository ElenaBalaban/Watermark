package watermark.check

import watermark.enums.WmPositions
import java.util.*
import kotlin.system.exitProcess


fun checkPositionInput(): String {
    println("Choose the position method (single, grid):")
    try {
        val input = readln().lowercase(Locale.getDefault())
        if(input in listOf(WmPositions.GRID.type, WmPositions.SINGLE.type)) {
           return input
        } else {
            println("The position method input is invalid.")
            exitProcess(8)
        }
    } catch (e: Exception){
        println("The position method input is invalid.")
        exitProcess(8)
    }
}