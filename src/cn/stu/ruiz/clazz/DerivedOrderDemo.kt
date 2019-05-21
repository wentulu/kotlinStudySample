package cn.stu.ruiz.clazz

open class Person(name: String) {


    open val size: Int = name.length.also { println("Initializing size in Person $it") }

    init {
        println("Person init $name")
    }

}


class Student(name: String, school: String) : Person(name) {

    init {
        println("Student init $name   $school")
    }

    override val size: Int//如果使用get()可以直接使用构造函数的,此处的school如果使用get()没加变量val无法访问
            = (super.size + school.length).also { println("Initializing Size in Student is $it") }

}


fun main() {
    Student("Ruiz", "High School")
}
/**
 * 在构造派生类的新实例的过程中，第一步完成其基类的初始化（在之前只有对基类构造函数参数的求值），因此发生在派生类的初始化逻辑运行之前。
 *
 * 这意味着，基类构造函数执行时，派生类中声明或覆盖的属性都还没有初始化。
 * 如果在基类初始化逻辑中（直接或通过另一个覆盖的 open 成员的实现间接）使用了任何一个这种属性，那么都可能导致不正确的行为或运行时故障。
 * 设计一个基类时，应该避免在构造函数、属性初始化器以及 init 块中使用 open 成员。
 *
 * 派生类中的代码可以使用 super 关键字调用其超类的函数与属性访问器的实现.
 *
 * 在一个内部类中访问外部类的超类，可以通过由外部类名限定的 super 关键字来实现：super@Outer
 * */
