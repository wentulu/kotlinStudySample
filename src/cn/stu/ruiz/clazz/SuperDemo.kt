package cn.stu.ruiz.clazz


open class BaseSuper{
    open fun f(){
        println("BaseSuper f")
    }

    open val x:Int get() = (1).also { println("BaseSuper x=$it") }
}


/**派生类中的代码可以使用 super 关键字调用其超类的函数与属性访问器的实现：*/
class DerivedSuper:BaseSuper(){

    override fun f() {
        super.f()
        println("DerivedSuper f")
    }

    override val x: Int
        get() = (super.x+1).also { println("DerivedSuper x=$it") }

}

fun main(){
//    OutClazz().SuperInner().g()
    DerivedOverrideMe().f()
}


/**
 * 在一个内部类中访问外部类的超类，可以通过由外部类名限定的 super 关键字来实现：super@Outer：
 * */
class OutClazz:BaseSuper(){
    override fun f() {
        super.f()
        println("OutClazz f")
    }

    override val x: Int
        get() = (super.x+1).also { println("OutClazz x = $it") }

    inner class SuperInner{
        fun g(){
            super@OutClazz.f()
            super@OutClazz.x
        }
    }
}


open class OverrideSameMethod{
    open fun f(){
        println("OverrideSameMethod f()")
    }

    fun a(){println("a")}
}

interface OverrideSameMethodIF{
     fun f(){
        println("OverrideSameMethodIF f()")
    }

    fun b(){println("b")}
}

class DerivedOverrideMe:OverrideSameMethod(),OverrideSameMethodIF{
    override fun f() {
        super<OverrideSameMethod>.f()
        super<OverrideSameMethodIF>.f()
    }
}


