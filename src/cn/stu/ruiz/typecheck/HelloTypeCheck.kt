package cn.stu.ruiz.typecheck

fun main(){

    println(" \"aaa\"'s length is  ${getStringLength("aaa")}")
    println("111's length is ${getStringLength(111)}")
    println(" 's length is ${getStringLength("")}")

}


fun getStringLength(string: Any):Int?{
    if (string is String){
        return string.length
    }
    return null
}

//fun getStringLength(string: Any):Int?{
//    if (string !is String){
//        return null
//    }
//    return string.length
//}

//fun getStringLength(string: Any):Int?{
//    if (string is String && string.length>0){
//        return string.length
//    }
//    return null
//}