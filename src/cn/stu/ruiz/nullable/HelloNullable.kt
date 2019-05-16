package cn.stu.ruiz.nullable

fun parseInt(str :String) :Int?{

    return str.toIntOrNull();
}



fun printProduct(str1: String,str2: String){

    val num1 = parseInt(str1)
    val num2 = parseInt(str2)

    if (num1!=null && num2!=null){
        println(num1*num2)
    }else{
        println("either $str1 or $str2 is not a number !")
    }

}



fun main(){
    printProduct("1","2")
    printProduct("1b","2")
    printProduct("1","b2")
    printProduct("c","d")
}