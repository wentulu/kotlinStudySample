package cn.stu.ruiz.interfacep


/**
 * Kotlin 的接口与 Java 8 类似，既包含抽象方法的声明，也包含实现。与抽象类不同的是，接口无法保存状态。它可以有属性但必须声明为抽象或提供访问器实现。
 *使用关键字 interface 来定义接口
 * */
interface MyInterface {
    fun bar() {
        println("bar")
    }

    fun foo()
}

/**实现接口
 *一个类或者对象可以实现一个或多个接口。
 */
class Child : MyInterface {
    override fun foo() {
        println("foo")
    }
}


/**
 *接口中的属性
 *你可以在接口中定义属性。在接口中声明的属性要么是抽象的，要么提供访问器的实现。
 * 在接口中声明的属性不能有幕后字段（backing field），因此接口中声明的访问器不能引用它们。
 * */
interface MyInterface2 {
    val prop: Int
    val propertyWithImplementation: String
        get() = "foo"

    fun foo() {
        println(propertyWithImplementation)
    }
}

class Child2 : MyInterface2 {
    override var prop: Int = 3
}

/**
 *接口继承
 * 一个接口可以从其他接口派生，从而既提供基类型成员的实现也声明新的函数与属性。很自然地，实现这样接口的类只需定义所缺少的实现：
 * */
interface Named {
    val name: String
}

interface Person : Named {
    val firstName: String
    val lastNAme: String

    override val name: String
        get() = "Name is $firstName $lastNAme"
}

data class Student(override val firstName: String, override val lastNAme: String, val grades: Int) : Person


/**
 *解决覆盖冲突
 *实现多个接口时，可能会遇到同一方法继承多个实现的问题.
 * */
interface InterfaceA {
    fun foo() {
        println("A foo")
    }

    fun bar()
}

interface InterfaceB {
    fun foo() {
        println("B foo")
    }

    fun bar() {
        println("B bar")
    }
}

class ClazzC : InterfaceA {
    override fun bar() {
        println("ClazzC bar")
    }
}

class ClazzD : InterfaceA, InterfaceB {
    override fun bar() {
        super.bar()
    }

    override fun foo() {
        super<InterfaceA>.foo()
        super<InterfaceB>.foo()
    }

}



