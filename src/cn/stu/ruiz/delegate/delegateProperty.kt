package cn.stu.ruiz.delegate

import cn.stu.ruiz.clazz.Foo
import javax.jws.soap.SOAPBinding
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/**
 *
 * 委托属性 有一些常见的属性类型，虽然我们可以在每次需要的时候手动实现它们， 但是如果能够为大家把他们只实现一次并放入一个库会更好。例如包括：
延迟属性（lazy properties）: 其值只在首次访问时计算；
可观察属性（observable properties）: 监听器会收到有关此属性变更的通知；
把多个属性储存在一个映射（map）中，而不是每个存在单独的字段中。

为了涵盖这些（以及其他）情况，Kotlin 支持 委托属性:

class Example {
var p: String by Delegate()
}

语法是：
val/var <属性名>: <类型> by <表达式>。
在 by 后面的表达式是该 委托， 因为属性对应的 get()（与 set()）会被委托给它的 getValue() 与 setValue() 方法。
属性的委托不必实现任何的接口，但是需要提供一个 getValue() 函数（与 setValue()——对于 var 属性）
 * */


class PropertyDemo {

    var nameT: String by DelegateProperty()
}

class DelegateProperty {
    var value: String = ""
    operator fun getValue(ref: Any?, property: KProperty<*>): String {
        return "${property.name} of ${ref.toString()} is ${value}"
    }

    operator fun setValue(ref: Any?, property: KProperty<*>, value: String) {
        this.value = value
        println("Set ${property.name} to $value")
    }
}

val lazyValue: String by lazy(LazyThreadSafetyMode.NONE) {
    println("init lazyValue")
    "123"
}

/**
 * Delegates.observable() 接受两个参数：初始值与修改时处理程序（handler）。 每当我们给属性赋值时会调用该处理程序（在赋值后执行）。它有三个参数：被赋值的属性、旧值与新值
 * */
class User {
    var name: String by Delegates.observable("<no-name>") { property, oldValue, newValue ->
        println("USER name from $oldValue to $newValue")
    }

    var age: Int by Delegates.vetoable(0) { property, oldValue, newValue ->
        if (newValue >= oldValue) {
            true
        } else {
            false
        }
    }
}


/**
 * 把属性储存在映射中
 *
 * 一个常见的用例是在一个映射（map）里存储属性的值。 这经常出现在像解析 JSON 或者做其他“动态”事情的应用中。 在这种情况下，你可以使用映射实例自身作为委托来实现委托属性。
 *
 * 这也适用于 var 属性，如果把只读的 Map 换成 MutableMap 的话：
 * */
class User1( map: Map<String, Any?>) {
    val name: String by map
    val age: Int by map
}


/**
 * 局部委托属性（自 1.1 起）
 * 你可以将局部变量声明为委托属性。 例如，你可以使一个局部变量惰性初始化：
 * */
fun example(computeFoo:()->Foo){
    val memoizedFoo by lazy(computeFoo){

    }
}


fun main() {
    val demo = PropertyDemo()
    demo.nameT = "4545"
    println(demo.nameT)

    println(lazyValue)

    println(lazyValue)

    var user = User()
    user.name = "First"
    user.name = "Second"
    user.age = 3
    println(user.age)
    user.age = 4
    println(user.age)
    user.age = 1
    println(user.age)

    val user1 = User1(
        mapOf(
            "name" to "Hello",
            "age" to 4
        )
    )

    println(user1.name)
    println(user1.age)


    example { Foo() }
}