package cn.stu.ruiz.clazz

open class Base{
    open fun v(){
        println("Base y()")
    }

    fun nv(){
        println("Base nv()")
    }
}


open class Derived():Base(){

    final override fun v() {
//        super.v()
        println("Dirived v()")
    }
//
//    override fun nv(){
//
//    }

    open fun nv(age:Int){

    }
}

//Dirived类必须添加open
class DerivedSecond():Derived(){
    override fun nv(age: Int) {
        super.nv(age)
        println("DerivedSecond mv $age")
    }
}

fun main(){
    Derived().v()
    DerivedSecond().v()
}


/**
 * Derived.v() 函数上必须加上 override 修饰符。如果没写，编译器将会报错。
 * 如果函数没有标注 open 如 Base.nv()，那么子类中不允许定义相同签名的函数，
 * 不论加不加 override。将 open 修饰符添加到 final 类（即没有 open 的类）的成员上不起作用。
 *
 * 标记为 override 的成员本身是开放的，也就是说，它可以在子类中覆盖。如果你想禁止再次覆盖，使用 final 关键字：
 * */