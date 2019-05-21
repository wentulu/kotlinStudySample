package cn.stu.ruiz.idioms

import java.io.File
import java.lang.IllegalStateException

//fun main(){
//    var files = File("out/production").listFiles()
//    println(files?.size)
//    println(files?.size?:"empty")
//}


//fun main(){
//    val values = mapOf("aa" to "aaa")
//    val mainEmail = values["email"]?:throw IllegalStateException("Email is missing")
//    println(mainEmail)
//}


//fun main(){
////    val emails = listOf("dfas","adsf")
//    val emails = listOf<String>()
//    val mainEmail = emails.firstOrNull()?:"Empty"
//    println(mainEmail)
//}


//fun main(){
//    val value ="aaa"
//
//    val values =value?.let { x->x+"let" }
//
//    println(value + "         $values")
//}


fun main() {
    val value :String? = null

    val values = value?.let { x -> x + "let" } ?: throw IllegalStateException("empty")
    println(values)
}