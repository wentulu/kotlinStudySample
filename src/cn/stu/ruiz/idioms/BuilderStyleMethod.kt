package cn.stu.ruiz.idioms

import java.lang.StringBuilder

fun main(){

    val array = arrayOf(4)
    println(array.toString1())

   for (i in array){
       print(i)
   }
}

fun arrayOfMinusOnes(size:Int):IntArray{
    return IntArray(size).apply { fill(1,2,3) }
}

fun IntArray.toString1():String{
    var values = StringBuilder()
    for (x in this){
        values.append("$x ")
    }
    return values.toString()
}

fun arrayOf(size: Int)=IntArray(size).apply { fill(8) }