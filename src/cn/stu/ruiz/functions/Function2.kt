package cn.stu.ruiz.functions

class HTML{
    fun body(){

    }
}


fun html(init:HTML.()->Unit):HTML{
    val html = HTML()
    html.init()
    return html
}


fun main(){
    html { println("$this init") }
}
