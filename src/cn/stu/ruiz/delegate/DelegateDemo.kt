package cn.stu.ruiz.delegate


/**
 *
 * 委托，方法委托看上去是代理模式的实现
 *
 * 在kotlin中使用 by来转发到指定执行的实例
 *
 * Derived 的超类型列表中的 by-子句表示 b 将会在 Derived 中内部存储， 并且编译器将生成转发给 b 的所有 Base 的方法。
 * */


interface Base {
    fun print()
    fun getname()
}

class BaseImpl(val x: Int) : Base {

    public val name = "BaseImpl"

    override fun print() {
        print(x)
    }


    override fun getname() {
        println(name)
    }
}


class DerivedBase(b: Base) : Base by b

/**
 * 覆盖由委托实现的接口成员
 *
 * 覆盖符合预期：编译器会使用 override 覆盖的实现而不是委托对象中的。如果将 override fun printMessage() { print("abc") } 添加到 Derived，那么当调用 printMessage 时程序会输出“abc”而不是“x”：
 */
class DerivedBase1(b: BaseImpl) : Base by b {
    override fun print() {
        println("abc")
    }
}

/**
 * 但请注意，以这种方式重写的成员不会在委托对象的成员中调用 ，委托对象的成员只能访问其自身对接口成员实现：
 *
 *
 *
 * 调用哪个对象的方法则输出的是哪个对象的相关实例的属性与关联方法
 * */
class DerivedBase2(b: Base) : Base by b {
    val name = "DerivedBase2"

    override fun print() {
        println("abc")
    }

    //注释与否输出不同的值
//    override fun getname() {
//        println(name)
//    }

}

fun main() {
    val b = BaseImpl(4)

    DerivedBase2(b).getname()
}

