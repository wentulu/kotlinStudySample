package cn.stu.ruiz.idioms

fun main() {

    print(sum(2))//可以省略后面的，前面的值怎么省略
}


fun sum(a: Int = 0, b: Int = 1): Int {

    return a + b
}