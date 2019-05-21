package cn.stu.ruiz.idioms

fun main(){

    downtoSample()

}


fun inSample(){
    for (i in 1..100){//[1,100]闭合的区间  closed range
        println(i)
    }
}

fun untilSample(){
    for (i in 1 until 100){//[1,100)半开区间 half-open range
        println(i)
    }
}

fun untilDescSample(){
    for (i in 100 until 1){//until 不支持倒叙
        println(i)
    }
}


fun stepSample(){
    for (i in 1..100 step 2){
        println(i)
    }
}

fun downtoSample(){
    for (i in 100 downTo 23){
        println(i)
    }
}