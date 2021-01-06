import java.lang.Exception

fun smartPrint(something: Any) {
    println("" + something)
}

fun guard(condition:Boolean, error:String){
    if (condition){
        throw Exception(error)
    }
}

fun guardValue(value:Any?, error:String) {
    guard(value == null, error)
}

annotation class TestAnnotation{

}