package cn.stu.ruiz.dataclass

fun main(){
    jieStruct()

}


data class Person(val name:String ,val age:Int)



data class Student(val name:String ="",val grade:Int=0)

data class Employee(val name: String){
    var position :String
    init {
        position = "Student"
    }
}

fun copyDemo(){
    val a = Person("Jack",12)
    val olderA = a.copy(age = 18)

    println("a = $a    olderA = $olderA")
}
/**
 * 数据类与解结构
 * */
fun jieStruct(){
    val a = Person("Jack",12)
    val (name,age) = a
    print("$name, $age years of age")
}
