package cn.stu.ruiz.`when`

fun main(){

    println(" 1 is ${describe(1)}")
    println(" Hello is ${describe("Hello")}")
    println(" 800L is ${describe(800L)}")
    println(" 2 is ${describe(2)}")
    println(" other is ${describe("other")}")
}

fun describe(obj : Any):String =
        when(obj) {
            1 -> "One"
            "Hello" -> "Greeting"
            is Long -> "Long"
            !is String -> "Not a String"
            else ->"UnKnow"
        }