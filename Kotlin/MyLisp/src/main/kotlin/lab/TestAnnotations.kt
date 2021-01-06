package lab

//import kotlin.reflect.full
//import kotlin.reflect.KType
import kotlin.reflect.KClass
import kotlin.reflect.full.findAnnotation

enum class TestSizes { SMALL, MEDIUM, LARGE }

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class TestSize(val size: TestSizes)

@TestSize(TestSizes.SMALL)
//class Tests { ... }
class Tests {}

//fun getTestSize(cls: KClass<*>): TestSizes? =
//    cls.findAnnotation<TestSize>()?.size
fun getTestSize(cls: KClass<*>): TestSizes? {
//fun getTestSize(cls: KClass<*>){
    return cls.findAnnotation<TestSize>()?.size
//    println(cls.annotations)
//    return cls.annotations?.size
//    findAnnotation<TestSize>()?.size
}

fun testAnnotations() =
    println(getTestSize(Tests::class))
