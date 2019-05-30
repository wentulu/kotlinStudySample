package cn.stu.ruiz


fun main(){

    val name = Name("Ruiz")
    name.greet()

}

/**
 * 内联类
 * 有时候，业务逻辑需要围绕某种类型创建包装器。
 * 然而，由于额外的堆内存分配问题，它会引入运行时的性能开销。
 * 此外，如果被包装的类型是原生类型，性能的损失是很糟糕的，因为原生类型通常在运行时就进行了大量优化，然而他们的包装器却没有得到任何特殊的处理。
 *
 *
 * 这就是内联类的主要特性，它灵感来源于 “inline” 这个名称：类的数据被 “内联”到该类使用的地方（类似于内联函数中的代码被内联到该函数调用的地方）
 *
 *
 * 然而，内联类的成员也有一些限制：
 *   内联类不能含有 init 代码块
 *   内联类不能含有幕后字段
 *   因此，内联类只能含有简单的计算属性（不能含有延迟初始化/委托属性）
 * */

inline class Password(val name:String)

val securePassword = Password("Don't try this in production")

inline class Name(val s:String){
    val length get() = s.length
    fun greet(){
        println("Hello , $s")
    }

}


/**
 * 继承
 * 内联类允许去继承接口
 *
 *
 * 禁止内联类参与到类的继承关系结构中。这就意味着内联类不能继承其他的类而且必须是 final
 */
interface Printable{
    fun prettyPrint():String
}

inline class Name2(val name:String):Printable{
    override fun prettyPrint(): String {
        return "let's $name"
    }
}



