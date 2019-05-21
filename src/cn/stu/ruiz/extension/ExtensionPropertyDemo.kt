package cn.stu.ruiz.extension

fun main(){

   val list =  listOf<String>("1","2" ,"3","4","5")
    println("The last Index = ${list.lastIndex}")

}

/**
 * 由于扩展没有实际的将成员插入类中，因此对扩展属性来说幕后字段是无效的。这就是为什么扩展属性不能有初始化器。他们的行为只能由显式提供的 getters/setters 定义。
 * val <T> List<T>.lastIndex = 1是报错的
 * */
val <T> List<T>.lastIndex get() = size-1

