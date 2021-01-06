import com.github.salomonbrys.kotson.*
import com.google.gson.JsonArray
import lab.testAnnotations

fun main(args: Array<String>) {
//    evaluate()
//    testJson()
    testAnnotations()
}

fun testJson() {
//    val list = mutableListOf(Bean(0, "123"), Bean(1, "456"))
//    var json = TestDatas.astl9.toJson()
//    var list = [+, 1, 2, 1]
//    var
    val arr: JsonArray = jsonArray("one", "two", 42, 21.5)
    smartPrint(arr)
//    smartPrint(TestDatas.ast1)
//    smartPrint(TestDatas.astl9)
}



fun evaluate() {
    var env = Env()
//    smartPrint(TestDatas.ast1)
//    smartPrint(TestDatas.ast3)
//    smartPrint(TestDatas.ast5)
//    smartPrint(TestDatas.ast8)
//    smartPrint(TestDatas.ast9)

//    calc(TestDatas.ast1)
//    var result = calc(listOf("+", 10, 55))

//    var result = calc(TestDatas.ast1,env)
//    var result = calc(TestDatas.ast2,env)
//    var result = calc(TestDatas.ast3,env)
//    var result = calc(TestDatas.ast4,env)
//    var result = calc(TestDatas.ast5,env)
//    var result = calc(TestDatas.ast6,env)
//    var result = calc(TestDatas.ast7,env)
//    var result = calc(TestDatas.ast8,env)
//    var result = calc(TestDatas.ast9)
//    var result = calc(TestDatas.ast10)
//    var result = calc(TestDatas.ast11)
//    var result = calc(TestDatas.ast12)

//    var result = calc(TestDatas.astl11)
//    var result = calc(TestDatas.astl12)
//    var result = calc(TestDatas.astl2)
//    var result = calc(TestDatas.astl3)
//    var result = calc(TestDatas.astl4)
//    var result = calc(TestDatas.astl5)
//    var result = calc(TestDatas.astl7)
    var result = calc(TestDatas.astl9)

    smartPrint("caculate result: $result")

//    JSONArray
}

