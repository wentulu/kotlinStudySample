<h4>属性与字段</h4>


1、声明属性<br><p>
  Kotlin 类中的属性既可以用关键字 var 声明为可变的，也可以用关键字 val 声明为只读的。
  <code>
  class Address {<br>
            var name: String = ……<br>
            var street: String = ……<br>
            var city: String = ……<br>
            var state: String? = ……<br>
            var zip: String = ……<br>
   }
   </code>
   </p>
2、Getters 与 Setters
  声明一个属性的完整语法是
  
  var <propertyName>[: <PropertyType>] [= <property_initializer>]
      [<getter>]
      [<setter>]<br>
  其初始器（initializer）、getter 和 setter 都是可选的。属性类型如果可以从初始器 （或者从其 getter 返回值，如下文所示）中推断出来，也可以省略。
  
3、幕后字段
    <br>
    <h6>field  </h6>field 标识符只能用在属性的访问器内<br>
4、幕后属性
    <br>
    
5、编译期常量<br>
    已知值的属性可以使用 const 修饰符标记为 编译期常量。 这些属性需要满足以下要求：
    
    位于顶层或者是 object 声明 或 companion object 的一个成员
    以 String 或原生类型值初始化
    没有自定义 getter
    这些属性可以用在注解中：
    
    const val SUBSYSTEM_DEPRECATED: String = "This subsystem is deprecated"
    ​
    @Deprecated(SUBSYSTEM_DEPRECATED) fun foo() { …… }
6、延迟初始化属性与变量<br>
    一般地，属性声明为非空类型必须在构造函数中初始化。 然而，这经常不方便。例如：属性可以通过依赖注入来初始化， 或者在单元测试的 setup 方法中初始化。 这种情况下，你不能在构造函数内提供一个非空初始器。 但你仍然想在类体中引用该属性时避免空检查。
    为处理这种情况，你可以用 lateinit 修饰符标记该属性：
    
    public class MyTest {
        lateinit var subject: TestSubject
    ​
        @SetUp fun setup() {
            subject = TestSubject()
        }
    ​
        @Test fun test() {
            subject.method()  // 直接解引用
        }
    }
    
该修饰符只能用于在类体中的属性（不是在主构造函数中声明的 var 属性，并且仅当该属性没有自定义 getter 或 setter 时），而自 Kotlin 1.2 起，也用于顶层属性与局部变量。该属性或变量必须为非空类型，并且不能是原生类型。
检测一个 lateinit var 是否已初始化（自 1.2 起）
要检测一个 lateinit var 是否已经初始化过，请在该属性的引用上使用 .isInitialized：

if (foo::bar.isInitialized) {
    println(foo.bar)
}
此检测仅对可词法级访问的属性可用，即声明位于同一个类型内、位于其中一个外围类型中或者位于相同文件的顶层的属性。

7、覆盖属性
<br>

8、委托属性
<br>