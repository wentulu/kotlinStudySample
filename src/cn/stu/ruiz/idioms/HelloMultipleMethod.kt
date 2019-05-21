package cn.stu.ruiz.idioms




fun main(){

    var turtle = Turtle()
    with(turtle){
        penDown()
        for (x in 1..4){
            forWard(100.0)
            turn(90.0)
        }
        penUp()
    }

}

class Turtle {
    fun penDown() {
        println("pen down,")
    }

    fun penUp() {
        println("pen Up")
    }

    fun turn(degree: Double) {
        println("turn $degree degrees,")
    }

    fun forWard(piexls:Double){
        println("forWard $piexls piexls,")
    }

}