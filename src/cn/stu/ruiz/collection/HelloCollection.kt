package cn.stu.ruiz.collection

fun main() {

    unZipDemo()
}


fun iterateCollection() {
    val items = listOf("apple", "banana", "kiwifruit")
    for (item in items) {
        println(item)
    }
}

fun checkContains() {
    val items = setOf("apple", "banana", "kiwifruit")
    when {//只会执行第一个符合的选项
        "orange" in items -> println("juicy")
        "banana" in items -> println("banana in items")
        "apple" in items -> println("apple is fine too")
    }
}

fun lambda() {
    val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
    fruits
        .filter { it.startsWith("a") }
        .sortedBy { it }
        .map { it.toUpperCase() }
        .forEach { println(it) }
}
/*===============总数操作符====================*/
fun anyDemo() {
    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
    println(list.any {
        println(it)
        it > 9
    })

    println(list.any { i ->
        println(i)
        i % 5 == 0
    })


}

fun allDemo() {
    val list = listOf(2, 3, 4, 5, 6, 7, 8)

    println(list.all { it >= 2 })

    println(list.all { it > 5 })
}


fun countDemo() {
    val list = listOf(2, 3, 4, 5, 6, 7, 8)
    println(list.count { it >= 4 })
}

//类似的reduce
fun foldDemo() {
    val list = listOf(2, 3, 4, 5, 6, 7, 8)
    println(list.fold(0) { total, next ->
        total + next
    })
}
//reduceRight
fun foldRightDemo() {
    val list = listOf(2, 3, 4, 5, 6, 7, 8)
    println(list.foldRight(0) { total, next ->
        total + next
    })
}

fun forEzchDemo() {
    val list = listOf(2, 3, 4, 5, 6, 7, 8)
    list.forEach { println(it) }
}

fun foreachIndexedDemo() {
    val list = listOf(2, 3, 4, 5, 6, 7, 8)
    list.forEachIndexed { index, i ->
        println("poc $index = value $i ")
    }
}

fun maxDemo() {
    val list = listOf(2, 3, 4, 5, 6, 7, 8)
    println(list.max())
    val listc = listOf("2", "3", "4", "a", "5", "6", "7", "8")
    println(listc.max())
}


fun maxbyDemo() {
    val list = listOf(2, 3, 4, 5, 6, 7, 8)
    println(list.maxBy { -it })//输出为2
}

//对应的还有min和minBy



fun noneDemo(){//没有匹配返回true
    val list = listOf(2, 3, 4, 5, 6, 7, 8)
    println(list.none{it%2==0})
    println(list.none{it>8})
}


fun sumByDemo(){
    val list = listOf(2, 3, 4, 5, 6, 7, 8)
    println(list.sumBy { it/2 })
}

/*====================过滤操作符=========================*/

fun dropDemo(){
    val list = listOf(2, 3, 4, 5, 6, 7, 8)
    println(list.drop(3))
}

fun dropWhileDemo(){//一旦有输出则会一直输出
    val list = listOf(2, 3, 4, 5, 6, 7, 8)
    println(list.dropWhile { it<5 })//[5, 6, 7, 8]
    println(list.dropWhile { it>=5 })//[2, 3, 4, 5, 6, 7, 8]
}

fun dropLastWhileDemo(){
    val list = listOf(2, 3, 4, 5, 6, 7, 8)
    println(list.dropLastWhile { it<5 })//[2, 3, 4, 5, 6, 7, 8]
    println(list.dropLastWhile { it>=5 })//[2, 3, 4]
}

fun filterDemo(){

    val list = listOf(2, 3, 4, 5, 6, 7, 8)
    println(list.filter { it%2==0 })//[2, 4, 6, 8]
}


fun filterNotDemo(){
    val list = listOf(2, 3, 4, 5, 6, 7, 8)
    println(list.filterNot { it%2==0 })//[3, 5, 7]
}

fun filterNotnullDemo(){
    val list = listOf("2","", "3", "4"," 5", "6", "7", "8")
    println(list.filterNotNull())
}

fun sliceDemo(){
    val list = listOf(2, 3, 4, 5, 6, 7, 8)
    println(list.slice(1..3))//[3, 4, 5]
}

fun takeDemo(){
    val list = listOf(2, 3, 4, 5, 6, 7, 8)
    println(list.take(4))
}

fun takeLastDemo(){
    val list = listOf(2, 3, 4, 5, 6, 7, 8)
    println(list.takeLast(4))//[5, 6, 7, 8]
}


fun takeWhileDemo(){
    val list = listOf(2, 3, 4, 5, 6, 7, 8)
    println(list.takeWhile { it>4 })//[]
    println(list.takeWhile { i ->  i<4})//[2, 3]
}


//映射操作
fun flatMapDemo(){
    val list = listOf(2, 3, 4, 5, 6, 7, 8)
    println(list.flatMap { listOf(it,it*it) })//[2, 4, 3, 9, 4, 16, 5, 25, 6, 36, 7, 49, 8, 64]
//    println(list.flatMap { it*it })
}


fun groupByDemo(){
    val list = listOf(2, 3, 4, 5, 6, 7, 8)
    println(list.groupBy { if (it%2==0)"even" else "odd" })
}


fun mapDemo(){
    val list = listOf(2, 3, 4, 5, 6, 7, 8)
    println(list.map { it*2 })//[4, 6, 8, 10, 12, 14, 16]
}


fun mapIndexedDemo(){
    val list = listOf(2, 3, 4, 5, 6, 7, 8)
    println(list.mapIndexed { index, it ->  index*it})//[4, 6, 8, 10, 12, 14, 16]

}
fun mapNotNull(){
    val list = listOf(2, 3, 4, 5, 6, 7, 8)
    println(list.mapNotNull { it+2 })//[4, 5, 6, 7, 8, 9, 10]
}
/*==================元素操作符====================*/
//contain
//elementAt
//elementAtOrElse
//elementAtOrNull
//first 返回第一个符合条线的元素
//firstOrNull 没有返回null


fun indexOfDemo(){//返回指针
    val list = listOf(2, 3, 4, 5, 6, 7, 8)
    println(list.indexOf(3) )
}

fun indexOfFirst(){
    val list = listOf(2, 3, 4, 5, 6, 7, 8)
    list.indexOfFirst { it%2==0 }
}

fun indexOfLast(){
    val list = listOf(2, 3, 4, 5, 6, 7, 8)
    list.indexOfLast { it%2==0 }
}

//last
//lastIndexOF
//lastOrNull
//single
//singleOrNull

/*================生产操作符============*/
//merge
//partition

fun mergeDemo(){//没有了merge

    val list = listOf(2, 3, 4, 5, 6, 7, 8)
    val list2 = listOf("a","b","c","d","e","f","g","h")
    println()
//    list.merge()
}

fun partitionDemo(){
    val list = listOf(2, 3, 4, 5, 6, 7, 8)
    println(list.partition { it%2==0 })
}


fun plusDemo(){
    val list = listOf(2, 3, 4, 5, 6, 7, 8)
    println(list+ listOf(1,9))//[2, 3, 4, 5, 6, 7, 8, 1, 9]
}


fun zipDemo(){
    val list = listOf(2, 3, 4, 5, 6, 7, 8)
    val list2 = listOf("a","b","c","d","e","f","g","h")
    println(list.zip(list2))//[(2, a), (3, b), (4, c), (5, d), (6, e), (7, f), (8, g)]
}

fun unZipDemo(){
//    Pair(listOf(5,6), listOf(7,8)),
    println(listOf(Pair(5,7),Pair(6,8)).unzip())//([5, 6], [7, 8])
}

/*=================顺序操作符===============*/
//reverse
//sort
//sortBy
//sortDescending
//sortDescendingBy
