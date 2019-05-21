package cn.stu.ruiz.idioms

fun main() {
    filterX()

}

//it是一个特殊的值，如下方的所示，使用it代表自身

fun filter() {

    val list = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
    print(list.filter { it > 4 })
}

//对于表达式 x代表当前的值后方的是判断表达式
fun filterX() {

    val list = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
    print(list.filter { x -> x > 4 && x<7 })
}