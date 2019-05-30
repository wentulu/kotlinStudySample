package cn.stu.ruiz.clazz

import java.io.File

/**
 *类型别名
 * 类型别名为现有类型提供替代名称。 如果类型名称太长，你可以另外引入较短的名称，并使用新的名称替代原类型名。
 * 它有助于缩短较长的泛型类型。
 * */

typealias NodeSet = Set<Int>

typealias FileTable<K> = MutableMap<K, MutableList<File>>

/**
 * 你可以为函数类型提供另外的别名
 * */

typealias MyHandler = (Int, String, Int) -> Int

typealias Predicate<T> = (T) -> Boolean


fun perdicate() {
    val a: MyHandler = { i, s, any -> i + s.length + any }

    val b: Predicate<Int> = { i -> i > 4 }


}

/**
 * 你可以为内部类和嵌套类创建新名称
 * */
class A1 {
    inner class Inner
}


class A2 {
    inner class Inner
}


typealias AInner = A1.Inner
typealias BINner = A2.Inner


/**
 * 类型别名不会引入新类型。
 * 它们等效于相应的底层类型。
 * 当你在代码中添加 typealias Predicate<T> 并使用 Predicate<Int> 时，Kotlin 编译器总是把它扩展为 (Int) -> Boolean。
 * 因此，当你需要泛型函数类型时，你可以传递该类型的变量，反之亦然
 * */
fun foo(p:Predicate<Int>, num:Int) = p(num)

fun main(){
    val f:Predicate<Int> = {i -> i>8 }

    print("9-> ${foo(f,9)}")
    println(" 7-> ${foo(f,7)}")

    print("1,2,3,4,5,6,7,8,9  -> ${listOf<Int>(1,2,3,4,5,6,7,8,9).filter(f)}")

    println()
    println(listOf(1,2,3,4,5,6,7,8,9).filter{i ->  i>3})

}

