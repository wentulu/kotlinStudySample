package cn.stu.ruiz.idioms



data class Customer(var name:String , var age:Int)

//copy 相当于克隆？？？？？？

fun main(){
    var customer = Customer("ruiz",23)

    var customer2 = customer.copy()

//    println(customer)
//
//    customer.age = 37

//    println(customer.toString())
//
//    println(customer.hashCode())

//    customer.name="gg"

    println(customer.equals(customer2))

}


