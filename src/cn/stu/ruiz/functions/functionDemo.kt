package cn.stu.ruiz.functions


fun <T, R> Collection<T>.fold(initial: R, combine: (acc: R, nextElement: T) -> R): R {
    var accumulator: R = initial
    for (element: T in this) {
        accumulator = combine(accumulator, element)
    }
    return accumulator
}

val a: (aa: String, element: Int) -> String = { aa, element ->
    "${aa + " " + element}"
}

val onclick: () -> Int = {

    2


}
val c: () -> (Int) -> Int = {
    val c = 7
    (c)
    { l ->
        6 + l
    }
}

fun main() {
    var collection: Collection<Int> = listOf(1, 2, 3, 4, 5, 6, 7, 8)

    val result = collection.fold(0) { acc, nextElement ->
        acc + nextElement
    }

    println(result)


    collection.fold(1, { acc, nextElement ->

        println("acc = $acc  nextElement = $nextElement")

        val currentResult: Int = acc + nextElement
        println("currentResult = $currentResult")

        currentResult

    })

    val string = collection.fold("Elements", a)
    println("string = $string")


    val joindStr = collection.fold("Elements", { acc, i -> acc + "  " + i })

    println(joindStr)

    println()
    println(collection.fold(1, Int::times))

    println("${c()}")
}