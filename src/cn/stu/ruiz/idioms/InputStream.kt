package cn.stu.ruiz.idioms

import java.nio.file.Files
import java.nio.file.Paths


fun main(){

    val steam = Files.newInputStream(Paths.get("src/cn/stu/ruiz/idioms/HelloInstance.kt"))
    steam.buffered().reader().use { x->
        println(x.readText())
     }

}
