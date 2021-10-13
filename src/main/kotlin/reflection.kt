import kotlin.reflect.full.memberProperties

class Test(val name: String, val age: Int)

fun foo(x: Int) = println(x)

fun sum(x: Int, y: Int) = x + y

val counter = 1

fun main() {
    val test = Test("kuckjwi", 30)
    val kClass = test.javaClass.kotlin
    println(kClass.simpleName)

    kClass.memberProperties.forEach { println(it) }

    val kFunction = ::foo
    kFunction.call(42)

    val kFunction2 = ::sum
    println(kFunction2.invoke(2, 4))

    val kProperty = ::counter
    println(kProperty.get())

    val memberProperty = Test::age
    println(memberProperty.get(test))
}
