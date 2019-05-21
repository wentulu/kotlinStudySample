package cn.stu.ruiz.returnskiplabel

fun main(){
    foo4()
}



fun breakSample(){
   for (i in 1..15){
       println("i = $i")
        for (c in 1..10){
            print("$i -> $c  \t")
            if (c>i)
                break

        }
       println()
    }

}


fun continueSample(){
    loop@for (i in 1..15){
        println("i = $i")
        for (c in 1..10){
            print("$i -> $c  \t")
            if (c>i)
                continue@loop

        }
        println()
    }
}

//标签可以直接返回当前的迭代，不加标签直接返回方法
fun foo(){
    val array = arrayOf(1,2,3,4,5,6,7,8)
    array.forEach itera@{
        if (it==3) return@itera
        print(it)
    }
    println("The end")
}
//隐式标签
fun foo2(){
    val array = arrayOf(1,2,3,4,5,6,7,8)
    array.forEach {
        if (it==3) return@forEach
        print(it)
    }
    println("The end")

}

fun foo3(){
    val array = arrayOf(1,2,3,4,5,6,7,8)
    run loop@{
        array.forEach {
            if (it == 3) return@loop
            print(it)
        }
    }
    println("The end")
}

fun foo4(){
    val array = arrayOf(1,2,3,4,5,6,7,8)
    val result = run loop@{
        array.forEach {
            if (it == 3) return@loop 4
            print(it)
        }
    }
    println("\nresult = $result")
    println("The end")
}