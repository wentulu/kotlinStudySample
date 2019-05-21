package cn.stu.ruiz.idioms

fun main() {
    println(BarInstance.bar.toStrong())
}

object BarInstance {
    val bar: Bar = Bar(12f, 32f)
}