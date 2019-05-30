package cn.stu.ruiz.functions

import kotlin.math.max

class IntTransformer : (Int) -> Int {
    override fun invoke(p1: Int): Int {
        return 1 + p1
    }
}

val intFunction: (Int) -> Int = IntTransformer()


val d = { i: Int -> i + 1 }


val repeatFun: String.(Int) -> String = { times -> this.repeat(times) }

val repeatFun2: (String, Int) -> String = { str, i -> str.repeat(i) }


fun transformation(f: (String, Int) -> String): String {
    return f("Hello", 3)
}

fun transformation2(f: String.(Int) -> String): String {
    return f("Hello", 3)
}


fun transformation3(str: String, n: Int, f: String.(Int) -> String): String {
    return f(str, n)
}


val sum: (a: Int, b: Int) -> Int = Sum()

class Sum : (Int, Int) -> Int {
    override fun invoke(p1: Int, p2: Int): Int {
        return p1 + p2
    }
}

fun main() {
    println(intFunction(3))

    println(d(3))

    println(transformation3("World", 3) { i ->
        this.repeat(i)
    })

    println(transformation(repeatFun))
    println(transformation(repeatFun2))

    val str = transformation(repeatFun2)
//    Runnable {
//        val a = 3
//        println(a)
//    }.run()

    val str2 = str.filter { it=='o' }.map { it.toUpperCase()+" 0" }
    println("str2 = $str2")

    val map = mapOf<String,String>("a" to "Hello","b" to "World")
    map.forEach{key,value-> println("key:value = $key:$value")}
}