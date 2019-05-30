package cn.stu.ruiz.clazz


fun main() {
    println("nestedClazz = $demo")

    println("innerClazz = $innerClazz")
}


/**
 * 嵌套类
 * */
class Outer {
    private val bar: Int = 1

    class Nested {
        fun foo() = 3
    }
}

val demo = Outer.Nested().foo()

/**
 *内部类
 */
class Outer1 {
    private val bar: Int = 2

    inner class InnerClazz {
        fun foo() = bar
    }
}

val innerClazz = Outer1().InnerClazz().foo()

/**
 *Anonymous Inner Class
 * 匿名内部类
 * */

interface AB {
    fun a()
    fun b()
}

val d = object : AB {
    override fun a() {
    }

    override fun b() {
    }
}


interface A {
    fun a()
}

/**
 *
 * 如果对象是函数式 Java 接口（即具有单个抽象方法的 Java 接口）的实例， 你可以使用带接口类型前缀的lambda表达式创建它：
 * val listener = ActionListener { println("clicked") }
 *下方是错误的
 */
//val a = A { print("a") }
