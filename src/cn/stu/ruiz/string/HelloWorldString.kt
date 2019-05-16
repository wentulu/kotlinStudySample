package cn.stu.ruiz.string

fun main(){
    var a=1
    var str = "a is $a"
    println(str)

    a=2
    println("a is $a but ${str.replace("is","was")}")
}