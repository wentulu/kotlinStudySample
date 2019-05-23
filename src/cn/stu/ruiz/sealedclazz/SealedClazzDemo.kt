package cn.stu.ruiz.sealedclazz

fun main() {
    val op: Operator = Add(1, 2)
    println(unbindStruc(op))
}

fun unbindStruc(op: Operator): Int? = when (op) {

    is Add -> op.a + op.b
    is Minus -> op.a - op.b
    is MultiplyM -> op.a * op.b
    is Divide -> op.a/op.b
}

sealed class Operator


class Add(val a: Int, val b: Int) : Operator(

)

class Minus(val a: Int, val b: Int) : Operator()

class MultiplyM(val a: Int, val b: Int) : Operator()

class Divide(val a: Int, val b: Int) : Operator()


