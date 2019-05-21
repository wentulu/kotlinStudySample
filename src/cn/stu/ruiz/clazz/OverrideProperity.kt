package cn.stu.ruiz.clazz


open class Foo{
    open val x:Int get() {return 3}
}

class Bar:Foo(){
    override var x =7
}

fun main(){
    println("Bar.x =  ${Bar().x}")
    var bar = Bar()
    println("Bar.x =  ${bar.x}")
    bar.x=90
    println("Bar.x =  ${bar.x}")
}


/**
 *属性覆盖与方法覆盖类似；在超类中声明然后在派生类中重新声明的属性必须以 override 开头，并且它们必须具有兼容的类型。每个声明的属性可以由具有初始化器的属性或者具有 getter 方法的属性覆盖。
 *
 *
 * 你也可以用一个 var 属性覆盖一个 val 属性，但反之则不行。这是允许的，因为一个 val 属性本质上声明了一个 getter 方法，而将其覆盖为 var 只是在子类中额外声明一个 setter 方法。
 *
 * 请注意，你可以在主构造函数中使用 override 关键字作为属性声明的一部分。
 * */

interface Num{
    val count:Int
}

class NumDerived(override val count:Int):Num


class NumDerived2():Num{
    override val count:Int=0
}