package cn.stu.ruiz.idioms

fun main() {

    var a = 1
    var b = 2
    a = b.also { b = a }

    print("a=$a  b=$b")

}