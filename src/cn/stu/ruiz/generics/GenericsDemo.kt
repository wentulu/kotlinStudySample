package cn.stu.ruiz.generics

fun main() {

    //一般来说，要创建这样类的实例，我们需要提供类型参数：
    var box1: Box<Double> = Box(3.2)
    //但是如果类型参数可以推断出来，例如从构造函数的参数或者从其他途径，允许省略类型参数
    var box2 = Box(3.2)

}

//与 Java 类似，Kotlin 中的类也可以有类型参数：
class Box<T>(t: T) {
    val value = t
}


