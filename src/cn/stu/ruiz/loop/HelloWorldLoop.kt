package cn.stu.ruiz.loop

fun main() {

    whileLoop()
}


fun forLoop() {
    val items = listOf<String>("1", "2", "3", "4")
    for (item in items) {
        print("$item \n")
    }
}


fun forIndices(){
    val items = listOf<String>("1", "2", "3", "4")
    for (index in items.indices) {
        print("${items[index]} \n")
    }
}


fun whileLoop(){
    val items = listOf<String>("aaa","bbb","ccc","ddd")
    var index =0;
    while (index< items.size){
        println(items[index])
        index++
    }
}