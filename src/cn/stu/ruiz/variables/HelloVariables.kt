package cn.stu.ruiz.variables


//顶级的变量定义
val Pi = 3.14
var a = 3

fun incrementX() {
    a += 2
}

fun topLevelVariables() {
    println("PI = $Pi a=$a")
    incrementX()
    print("incrementX()")
    println("PI = $Pi a=$a")
}

fun main() {
//    valvariables()
//    varVariables()

    topLevelVariables()
}


//定义只读局部local变量 使用val关键字  也就是常量  只接受一次赋值assigned
fun valvariables() {
    val PI = 3.14
    val b = 3
    val c: Int
    c = 7
//    c = 10 //这一行会报错  c  cannot  be reassigned 不可以再次被赋值
    print("PI = $PI  b = $b  c = $c")
}


//可以多次赋值的变量 使用var关键字   也就是变量   可以接受多次赋值reassigned
fun varVariables() {
    var x = 5
    x += 1
    print("x = $x")
}