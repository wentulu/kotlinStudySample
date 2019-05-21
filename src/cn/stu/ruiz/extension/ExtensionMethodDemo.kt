package cn.stu.ruiz.extension

/**
 * 扩展函数
 *
 * */


fun main() {
    checkClassOrExtensionMethod()
}


/**
 * 声明一个扩展函数，我们需要用一个 接收者类型 也就是被扩展的类型来作为他的前缀。
 *
 * 这个 this 关键字在扩展函数内部对应到接收者对象（传过来的在点符号前的对象）
 * */

fun String.sumlength(): Int? {
    return this.length
}

fun MutableList<Int>.swap(indexA: Int, indexB: Int) {
    var temp = this[indexA]
    this[indexA] = this[indexB]
    this[indexB] = temp
}

fun <T> MutableList<T>.swap2(indexA: Int, indexB: Int) {
    this[indexA] = this[indexB].also {
        println("it = $it")
        this[indexB] = this[indexA]
        println("it = $it")
    }
}

fun swapDemo() {
    val list = mutableListOf<Int>(1, 2, 3, 4, 5, 6)
    list.swap2(3, 5)
    println(list.toString())
}

/**
 *扩展是静态解析的，根据参数类型类来执行的
 * 扩展不能真正的修改他们所扩展的类。通过定义一个扩展，你并没有在一个类中插入新成员， 仅仅是可以通过该类型的变量用点表达式去调用这个新函数。
 *
 * 我们想强调的是扩展函数是静态分发的，即他们不是根据接收者类型的虚方法。 这意味着调用的扩展函数是由函数调用所在的表达式的类型来决定的， 而不是由表达式运行时求值结果决定的。
 * 此处重点在于检查多态的情况下父类的扩展没有覆盖子类
 * */

open class C
class D:C()

fun C.foo()= println("C")

fun D.foo()= println("D")

fun printFoo(c:C){
    c.foo()
}
//printFoo(D()) 运行结果 C  说明这个跟实例没有关系


/**
 * 对于类中定义的函数和扩展函数的优先级问题
 * 1、同名且签名相同
 *      类中定义的优先于扩展函数
 *      当类中定义的函数为私有时则调用了扩展函数
 * 2、同名签名不同
 *
 * */
class ExtensionClazz1{
    private fun f(){
        println("Class Method f")
    }

    override fun toString(): String {
        return super.toString()+" ExtensionClazz1"
    }
}

fun ExtensionClazz1.f(){
    println("Extension Method f")

}

fun ExtensionClazz1?.fScope(){
    if (this==null) return

}

fun checkClassOrExtensionMethod(){
    var m = ExtensionClazz1()
    m.f()
    println(m.m())
}

fun ExtensionClazz1?.m():String{
    if(this==null)  return "null"
    //空检测之后，this会自动转换为非空类型 多以下面的toString()会被解析为ExtensionClazz1的toString
    return this.toString()
}
