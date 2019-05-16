package cn.stu.ruiz.range

fun main() {

//    rangeIn()

   rangestep()

}


fun rangeIn() {
    val x = 10
    var y = 9
    if (x in 1..y + 1) {
        println("fits in range")
    }
}


fun unin() {
    val list = listOf("a", "b", "c")

    if (-1 !in 0..list.lastIndex) {
        println("-1 is out of range")
    }
    if (list.size !in list.indices) {
        println("list size is out of valid list indices range, too")
    }

    if ("a" in list){
        println("a is in ${list}")
    }
}


fun iterateRange() {
    for (x in 1..5) {
        print(x)
    }
}

fun rangestep(){
    for (x in 1..10 step 2){
        println(x)
    }

    for (x in 10 downTo 1 step 3){
        println(x)
    }
}