package cn.stu.ruiz.idioms

fun main() {

    traversingMap()
    traversingList()
}


fun traversingMap() {

    val map: HashMap<String, String> = HashMap()
    map.put("a", "aaa")
    map.put("b", "bbb")

    for ((K, V) in map) {
        println("$K -> $V")
    }

}


fun traversingList() {
    val lista = listOf("a", "b", "c", "d", "e")
    for (k in lista.indices) {
        println("$k -> ${lista[k]}")
    }
}
