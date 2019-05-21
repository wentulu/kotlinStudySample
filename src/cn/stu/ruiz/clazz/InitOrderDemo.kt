package cn.stu.ruiz.clazz

class InitOrderDemo(name :String){

    constructor(name: String,age:Int):this(name){
        println("name:$name   age:$age")
    }

    val firstProperty = "First Property is $name".also(::println)

    init {
        println("First initializer block that prints $name")
    }

    val secondProperty = "Secondary Property is ${name.length}".also(::println)

    init {
        println("Second initializer block that prints ${name.length}")
    }
}



fun main(){
//    var demo = InitOrderDemo("Ruiz")

    var demo2 = InitOrderDemo("adas",23)
}


/**
 * 输出结果 demo
 * First Property is Ruiz
 *First initializer block that prints Ruiz
 *Secondary Property is 4
 *Second initializer block that prints 4
 *
 * demo2输出结果
 * First Property is adas
 *First initializer block that prints adas
 *Secondary Property is 4
 *Second initializer block that prints 4
 *name:adas   age:23
 *
 *
 * 次构造函数在主构造函数的后面执行,初始化块中的代码实际上会成为主构造函数的一部分。委托给主构造函数会作为次构造函数的第一条语句，因此所有初始化块中的代码都会在次构造函数体之前执行
 *
 * 如果类有一个主构造函数，每个次构造函数需要委托给主构造函数， 可以直接委托或者通过别的次构造函数间接委托。委托到同一个类的另一个构造函数用 this 关键字即可：
 *
 * 即使该类没有主构造函数，这种委托仍会隐式发生，并且仍会执行初始化块：
 * */