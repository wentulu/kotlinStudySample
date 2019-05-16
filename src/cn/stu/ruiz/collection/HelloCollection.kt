package cn.stu.ruiz.collection

fun main(){
    lambda()
}


fun iterateCollection(){
    val items = listOf("apple", "banana", "kiwifruit")
    for (item in items) {
        println(item)
    }
}

fun checkContains(){
    val items = setOf("apple", "banana", "kiwifruit")
    when {//只会执行第一个符合的选项
        "orange" in items -> println("juicy")
        "banana" in items -> println("banana in items")
        "apple" in items -> println("apple is fine too")
    }
}

fun lambda(){
    val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
    fruits
        .filter { it.startsWith("a") }
        .sortedBy { it }
        .map { it.toUpperCase() }
        .forEach { println(it) }
}