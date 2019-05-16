package cn.stu.ruiz.functions

fun main() {

   printstr(3,6)
}

//方法的定义
fun sum(a: Int, b: Int): Int {

    return a + b
}

//表达式代表方法
fun sum2(a: Int, b: Int) = a + b

//没有返回值的方法   使用UInt  代表返回一个没有意义的值
fun printstr(message: String): Unit {
    print("这是一个没有返回值的方法 $message")
}

//Unit 没有意义的返回值可以被省略
fun printstr(a:Int,b:Int){
    println("这是一个没有返回值的方法 $a + $b = ${a+b}")
}