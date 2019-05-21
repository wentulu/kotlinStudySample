package cn.stu.ruiz.clazz

open class BaseAbstract{
    open fun f(){
        println("BaseAbstract f")
    }
}


abstract class AbstractClazza : BaseAbstract(){
    abstract override fun f()
}

class DerivedAbstractClazz:AbstractClazza(){
    override fun f() {
        println("DerivedAbstractClazz f")
    }
}

fun main(){
    DerivedAbstractClazz().f()
}
