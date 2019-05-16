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

class Rectangle(var height:Double , var length:Double):Shape(listOf(length,height,length,height)),RectangleProperties{


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