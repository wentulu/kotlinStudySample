package cn.stu.ruiz.propertyfield

import java.lang.AssertionError


fun main() {

    val student = Students()
    student.size=2
    println(student.size)
    println(student.isEmpty)
    student.ll="World"
    println(student.ll)
    println(student.name)
}


class Students {

    var size: Int = 0

    val isEmpty: Boolean
        get() = this.size == 0

    override fun toString(): String {
        return super.toString() + " size = $size"
    }

    //幕后字段
    var ll: String = "Hello"
        get() {
            return "$field getter"
        }
        set(value) {
            field = value.also { println("$value setter") }
        }

    //幕后属性
    private var _name: String? = null
    var name: String? = null
        get() {
            if (_name == null)
                _name = String() //"Empty"
            return _name?:throw AssertionError()
        }
}