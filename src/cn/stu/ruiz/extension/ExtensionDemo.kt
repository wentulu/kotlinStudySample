package cn.stu.ruiz.extension


fun main(){
    C1().caller(DO())
    C2().caller(DO())
    C1().caller(D1())
}


/**
 * 扩展声明为成员
 * 在一个类内部你可以为另一个类声明扩展。在这样的扩展内部，有多个 隐式接收者 —— 其中的对象成员可以无需通过限定符访问。如在EC。ED.fof()中调用ED.bar()无需类限定符。
 * 扩展声明所在的类的实例称为 分发接收者（EC），扩展方法调用所在的 接收者类型 的 实例 称为 扩展接收者(ED)
 *
 * 对于分发接收者与扩展接收者的成员名字冲突的情况，扩展接收者优先。要引用分发接收者的成员你可以使用 限定的 this 语法。
 * 优先调用被扩展的类的方法
 *
 * */
class ED{//扩展接收者
    fun bar(){
        println("ED bar()")
    }
}

class EC{//分发接受者
    fun baz(){
        println("EC baz()")
    }
    fun bar(){
        println("EC bar()")
    }
    fun ED.foo(){
        println("Extension ED.foo()")
        this.bar()
        this@EC.bar()
        baz()
    }
    fun caller(d:ED){
        println("EC caller(d:ED)")
        d.foo()
    }

}

/**
 * 声明为成员的扩展可以声明为 open 并在子类中覆盖。这意味着这些函数的分发对于分发接收者类型是虚拟的，但对于扩展接收者类型是静态的。
 * */
open class DO{}
class D1:DO(){}
open class C1{
    open fun DO.bar(){
        println("C1 DO bar")
    }

    open fun D1.bar(){
        println("C1 D1 bar")
    }

    fun caller(d0:DO){
//        println("C1 caller(d0:DO)")
        d0.bar()
    }

}

class C2:C1(){
    override fun DO.bar() {
        println("C2 D0.bar")
    }
    override fun D1.bar() {
        println("C2 D1.bar")
    }
}

/**
 *关于可见性的说明
 *扩展的可见性与相同作用域内声明的其他实体的可见性相同。例如：
 * 在文件顶层声明的扩展可以访问同一文件中的其他 private 顶层声明
 * 如果扩展是在其接收者类型外部声明的，那么该扩展不能访问接收者的 private 成员
 * */


/**
 * 动机
在Java中，我们将类命名为“*Utils”：FileUtils、StringUtils 等，著名的 java.util.Collections 也属于同一种命名方式。 关于这些 Utils-类的不愉快的部分是代码写成这样：

// Java
Collections.swap(list, Collections.binarySearch(list,
Collections.max(otherList)),
Collections.max(list));
这些类名总是碍手碍脚的，我们可以通过静态导入达到这样效果：

// Java
swap(list, binarySearch(list, max(otherList)), max(list));
这会变得好一点，但是我们并没有从 IDE 强大的自动补全功能中得到帮助。如果能这样就更好了：

// Java
list.swap(list.binarySearch(otherList.max()), list.max());
但是我们不希望在 List 类内实现这些所有可能的方法，对吧？这时候扩展将会帮助我们。
 * */