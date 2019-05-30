属性委托要求
这里我们总结了委托对象的要求。

对于一个只读属性（即 val 声明的），委托必须提供一个名为 getValue 的函数，该函数接受以下参数：

thisRef —— 必须与 属性所有者 类型（对于扩展属性——指被扩展的类型）相同或者是它的超类型；
property —— 必须是类型 KProperty<*> 或其超类型。
这个函数必须返回与属性相同的类型（或其子类型）。

对于一个可变属性（即 var 声明的），委托必须额外提供一个名为 setValue 的函数，该函数接受以下参数：

thisRef —— 同 getValue()；
property —— 同 getValue()；
new value —— 必须与属性同类型或者是它的超类型。
getValue() 或/与 setValue() 函数可以通过委托类的成员函数提供或者由扩展函数提供。 当你需要委托属性到原本未提供的这些函数的对象时后者会更便利。 两函数都需要用 operator 关键字来进行标记。

委托类可以实现包含所需 operator 方法的 ReadOnlyProperty 或 ReadWriteProperty 接口之一。 这俩接口是在 Kotlin 标准库中声明的：

interface ReadOnlyProperty<in R, out T> {
    operator fun getValue(thisRef: R, property: KProperty<*>): T
}
​
interface ReadWriteProperty<in R, T> {
    operator fun getValue(thisRef: R, property: KProperty<*>): T
    operator fun setValue(thisRef: R, property: KProperty<*>, value: T)
}

翻译规则
在每个委托属性的实现的背后，Kotlin 编译器都会生成辅助属性并委托给它。 例如，对于属性 prop，生成隐藏属性 prop$delegate，而访问器的代码只是简单地委托给这个附加属性：

class C {
    var prop: Type by MyDelegate()
}
​
// 这段是由编译器生成的相应代码：
class C {
    private val prop$delegate = MyDelegate()
    var prop: Type
        get() = prop$delegate.getValue(this, this::prop)
        set(value: Type) = prop$delegate.setValue(this, this::prop, value)
}
Kotlin 编译器在参数中提供了关于 prop 的所有必要信息：第一个参数 this 引用到外部类 C 的实例而 this::prop 是 KProperty 类型的反射对象，该对象描述 prop 自身。

请注意，直接在代码中引用绑定的可调用引用的语法 this::prop 自 Kotlin 1.1 起才可用。