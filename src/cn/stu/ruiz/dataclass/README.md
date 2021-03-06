<h4>数据类</h4>

只保存数据的类。 在这些类中，一些标准函数往往是从数据机械推导而来的。在 Kotlin 中，这叫做 数据类 并标记为 data<br>

1、data 
编译器自动从主构造函数中声明的所有属性导出以下成员：
      
      equals()/hashCode() 对；
      toString() 格式是 "User(name=John, age=42)"；
      componentN() 函数 按声明顺序对应于所有属性；
      copy() 函数（见下文）。
      为了确保生成的代码的一致性以及有意义的行为，数据类必须满足以下要求：
      
      主构造函数需要至少有一个参数；
      主构造函数的所有参数需要标记为 val 或 var；
      数据类不能是抽象、开放、密封或者内部的；
      （在1.1之前）数据类只能实现接口。
      
      
      
      此外，成员生成遵循关于成员继承的这些规则：
      
      如果在数据类体中有显式实现 equals()、 hashCode() 或者 toString()，或者这些函数在父类中有 final 实现，那么不会生成这些函数，而会使用现有函数；
      如果超类型具有 open 的 componentN() 函数并且返回兼容的类型， 那么会为数据类生成相应的函数，并覆盖超类的实现。如果超类型的这些函数由于签名不兼容或者是 final 而导致无法覆盖，那么会报错；
      从一个已具 copy(……) 函数且签名匹配的类型派生一个数据类在 Kotlin 1.2 中已弃用，并且在 Kotlin 1.3 中已禁用。
      不允许为 componentN() 以及 copy() 函数提供显式实现。
      
      
      
      
      在 JVM 中，如果生成的类需要含有一个无参的构造函数，则所有的属性必须指定默认值。 （参见构造函数）。
      
      data class User(val name: String = "", val age: Int = 0)