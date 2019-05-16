package cn.stu.ruiz.conditionalexpression


fun main(){
    println("3  , 5  Max is ${ifConditionalMaxExpress(3,5)}")
}


fun ifconditionalMax(a:Int , b:Int):Int{
    if (a>b) {
        return a
    }else {
        return b
    }
}

//可以直接将表达式的值赋值给方法
fun ifConditionalMaxExpress(a:Int ,b:Int) = if (a>b) a else b