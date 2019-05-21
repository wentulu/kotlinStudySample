package cn.stu.ruiz.idioms

import java.lang.Exception

fun main(){
    val color =try {

        transform2("Red")
    }catch (e:Exception){
        null
    }

    print(color)
}

fun transform(color: String): Int {
    return when (color) {
        "Red" -> 0
        "Green" -> 1
        "Blue" -> 2
        else -> throw IllegalArgumentException("Invalid color param value")
    }
}

fun transform2(color: String) = when (color) {
        "Red" -> 0
        "Green" -> 1
        "Blue" -> 2
        else -> throw IllegalArgumentException("Invalid color param value")
    }
