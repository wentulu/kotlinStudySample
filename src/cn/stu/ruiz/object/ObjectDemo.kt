package cn.stu.ruiz.`object`


import org.omg.CORBA.Object
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.JComponent
import javax.swing.JWindow;

/**
 *对象表达式与
 *
 *
 * 有时候，我们需要创建一个对某个类做了轻微改动的类的对象，而不用为之显式声明新的子类。 Java 用匿名内部类 处理这种情况。 Kotlin 用对象表达式和对象声明对这个概念稍微概括了下
 * */

fun main() {

    studentTest()

    objectTest()
}

/**
 *要创建一个继承自某个（或某些）类型的匿名类的对象，我们会这么写
 */
val window: JWindow = JWindow()

fun addListener() {
    window.addMouseListener(object : MouseAdapter() {
        override fun mouseClicked(e: MouseEvent?) {
            super.mouseClicked(e)
        }

        override fun mouseMoved(e: MouseEvent?) {
            super.mouseMoved(e)
        }
    })
}


/**
 *如果超类型有一个构造函数，则必须传递适当的构造函数参数给它。 多个超类型可以由跟在冒号后面的逗号分隔的列表指定
 *
 *
 * 注意   匿名对象可以用作只在(本地)和(私有作用域)中声明的类型。
 *        如果你使用匿名对象作为公有函数的返回类型或者用作公有属性的类型，那么该函数或属性的实际类型会是匿名对象声明的超类型，如果你没有声明任何超类型，就会是 Any。在匿名对象中添加的成员将无法访问。
 * */
open class Person(name: String) {
    val mName = name
}

interface Run {
    fun run()
}

fun studentTest() {
    val student = object : Person("Ruiz"), Run {
        val age = 34
        override fun run() {
            print("$mName is running")
        }
    }

    println("student name=${student.mName}  age=${student.age}  ${student.run()}")
}

fun objectTest() {
    val adHoc = object {
        //匿名对象用作本地
        var x: Int = 0
        var y = 3
    }

    println("x = ${adHoc.x}  y = ${adHoc.y}")
}

class C {

    // 私有函数，所以其返回类型是匿名对象类型
    private fun foo() = object {
        val x = "Hello"
    }

    // 公有函数，所以其返回类型是 Any
    fun publicFoo() = object {
        val y = "World"
    }

    private val x1 = object {
        val a = 3
    }

    val x2 = object {
        val a = 6
    }

    fun bar() {
        val x1 = foo().x//正常
//        val x2 = publicFoo().y//错误的

        val a1 = this.x1.a//正常
//        val a2 = this.x2.a//错误的
    }
}

/**
 * 就像 Java 匿名内部类一样，对象表达式中的代码可以访问来自包含它的作用域的变量。 （与 Java 不同的是，这不仅限于 final 或实际相当于 final 的变量。）
 * */
fun countClick(window: JComponent) {
    var clickCount = 0
    var enteredCount = 0
    window.addMouseListener(object : MouseAdapter() {
        override fun mouseClicked(e: MouseEvent?) {
            super.mouseClicked(e)
            clickCount++
        }

        override fun mouseEntered(e: MouseEvent?) {
            super.mouseEntered(e)
            enteredCount++
        }
    })
}

/**
 *
 * 对象声明
 *
 *
 *单例模式在一些场景中很有用， 而 Kotlin（继 Scala 之后）使单例声明变得很容易
 *
 * 这称为对象声明。并且它总是在 object 关键字后跟一个名称。 就像变量声明一样，对象声明不是一个表达式，不能用在赋值语句的右边。
 *
 * 对象声明的初始化过程是线程安全的。
 *
 * 如需引用该对象，我们直接使用其名称即可：
 *
 *
 * 这些对象可以有超类型
 *
 *
 * 注意：对象声明不能在局部作用域（即直接嵌套在函数内部），但是它们可以嵌套到其他对象声明或非内部类中。
 * */
object NumMaganger {
    val collection: List<Number> = ArrayList()
    var i: Int = 0
    fun registerNum(num: Number) {
    }

    val allNums: Collection<Number>
        get() = collection
}


fun Numadd() {
    NumMaganger.registerNum(333)
}

object DefaultNum : MouseAdapter() {
    override fun mouseClicked(e: MouseEvent?) {
        super.mouseClicked(e)
    }

    override fun mouseEntered(e: MouseEvent?) {
        super.mouseEntered(e)
    }
}

/**
 * 伴生对象
 * */
class MyClass {
    companion object Factory {
        fun create(): MyClass = MyClass()
    }
}

/**
 *伴生对象的成员可通过只使用类名作为限定符来调用
 * */
fun companionDemo() {
    val instance = MyClass.create()
}

/**
 * 可以省略伴生对象的名称，在这种情况下将使用名称 Companion
 * */
class MyClazz1 {
    companion object {
        fun create(): Int = 7
    }
}

fun companionDemo2() {
    MyClazz1.Companion
}

/**
 * 其自身所用的类的名称（不是另一个名称的限定符）可用作对该类的伴生对象 （无论是否命名）的引用：
 * */
class MyClass2 {
    companion object Named {}
}

val y = MyClass2

class MyClass3 {
    companion object {}
}

val y1 = MyClass3

/**
 * 请注意，即使伴生对象的成员看起来像其他语言的静态成员，在运行时他们仍然是真实对象的实例成员，而且，例如还可以实现接口
 *
 * 当然，在 JVM 平台，如果使用 @JvmStatic 注解，你可以将伴生对象的成员生成为真正的静态方法和字段。更详细信息请参见Java 互操作性一节 。


 * */

interface Factory<T> {
    fun create(): T
}

class MyClass4 {
    companion object : Factory<MyClass4> {
        override fun create(): MyClass4 = MyClass4()
    }
}

/**
 *对象表达式和对象声明之间的语义差异
 * 对象表达式和对象声明之间有一个重要的语义差别：
 * 对象表达式是在使用他们的地方立即执行（及初始化）的；
 * 对象声明是在第一次被访问到时延迟初始化的；
 * 伴生对象的初始化是在相应的类被加载（解析）时，与 Java 静态初始化器的语义相匹配。
 * */