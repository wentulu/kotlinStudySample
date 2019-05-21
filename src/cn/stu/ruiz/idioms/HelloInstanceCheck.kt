package cn.stu.ruiz.idioms

fun main() {

    var foo = Foo(1f, 2f)
    var bar = Bar(2f, 4f)

    isType(foo)
    isType(bar)
    isType("aa")

}

fun isType(obj: Any) {
    when(obj){
        is Foo -> println("$obj is Foo")
        is Bar -> println("$obj is Bar")
        else -> println("$obj is Unknown type")
    }
}

class Foo(val height: Float, val lenght: Float) {

}

class Bar(val height: Float, val lenght: Float) {

}