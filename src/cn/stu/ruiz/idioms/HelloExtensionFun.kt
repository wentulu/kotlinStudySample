package cn.stu.ruiz.idioms


fun main(){
    print(Bar(12f,34f).toStrong())
}


fun Bar.toStrong():String{//动态拓展函数
    return "height = $height, length= $lenght"
}