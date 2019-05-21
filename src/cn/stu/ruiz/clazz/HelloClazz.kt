package cn.stu.ruiz.clazz

fun main() {

    val rectangle = Rectangle(10.0,5.0)
    val triangle = Triangle(3.0,4.0,5.0)

    println("Area of Rectangle(10.0,5.0) is ${rectangle.caculateArea()}, its perimeter is ${rectangle.perimeter}")

    println("Area of Triangle(3.0,4.0,5.0) is ${triangle.caculateArea()}, its perimeter is ${triangle.perimeter}")

}


abstract class Shape(val sides: List<Double>) {
    val perimeter: Double get() = sides.sum()
    abstract fun caculateArea(): Double
}

interface RectangleProperties {
    val isSquare: Boolean
}

class Rectangle constructor( height:Double ,  length:Double):Shape(listOf(length,height,length,height)),RectangleProperties{

    val length =length
    val height = height

    override fun caculateArea(): Double {
        return length*height
    }

    override val isSquare: Boolean
        get() = true
}


class Triangle(var sideA:Double ,var sideB:Double,var sideC:Double):Shape(listOf(sideA,sideB,sideC)),RectangleProperties{
    override val isSquare: Boolean
        get() = false


    override fun caculateArea(): Double {
        val s = perimeter/2
        return Math.sqrt((s*(s-sideA)*(s-sideB)*(s-sideC)))
    }
}


/**
 * 对于属性的两种声明方式，在
 *
 * 主构造函数或者{声明属性以及从主构造函数初始化属性，Kotlin 有简洁的语法：如上方的Triangle}
 *
 *
 * 在初始化中都可以{主构造的参数可以在初始化块中使用。它们也可以在类体内声明的属性初始化器中使用Rectangle}
 *
 * 如果构造函数有注解或可见性修饰符，这个 constructor 关键字是必需的，并且这些修饰符在它前面：
 * 初始化块中的代码实际上会成为主构造函数的一部分。委托给主构造函数会作为次构造函数的第一条语句，因此所有初始化块中的代码都会在次构造函数体之前执行。即使该类没有主构造函数，这种委托仍会隐式发生，并且仍会执行初始化块
 */