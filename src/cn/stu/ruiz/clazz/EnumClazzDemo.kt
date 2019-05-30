package cn.stu.ruiz.clazz

import java.util.function.BinaryOperator
import java.util.function.IntBinaryOperator

fun main() {
    println(EnumClazzDemo1.AUTUMN)
    println(SeasonsDemo2.AUTUMN.seasonName)

    val a = 13
    val b = 31
    for (f in IntArithemtics.values()){
        println("$f($a,$b) = ${f.applyAsInt(a,b)} ")
    }

    println("SPRING =  ${EnumClazzDemo1.valueOf("SPRING")}")

    println("EnumClazzDemo1 = ${EnumClazzDemo1.values().joinToString { it.name }}")

}

enum class EnumClazzDemo1 {
    SPRING, SUMMER, AUTUMN, WINTER
}

enum class SeasonsDemo2(val seasonName: String) {
    SPRING("春天"),
    SUMMER("夏天"),
    AUTUMN("秋天"),
    WINTER("冬天")
}

enum class ProtocolState {
    WAITING {
        override fun signal(): ProtocolState {
            return TALKING
        }
    },
    TALKING {
        override fun signal(): ProtocolState = WAITING
    };


    abstract fun signal(): ProtocolState
}

enum class IntArithemtics : BinaryOperator<Int>, IntBinaryOperator {

    PLUS {
        override fun apply(t: Int, u: Int): Int = t + u
    },
    TIMES {

        override fun apply(t: Int, u: Int): Int = t * u
    };

    override fun applyAsInt(left: Int, right: Int): Int = apply(left, right)

}

