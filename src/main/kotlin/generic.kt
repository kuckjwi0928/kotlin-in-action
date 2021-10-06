import java.lang.Appendable
import java.lang.StringBuilder
import java.util.*

fun <T> List<T>.penultimate(): T = this[size - 2]

fun <T : Number> oneHalf(value: T): Double = value.toDouble() / 2.0

fun <T : Comparable<T>> max(first: T, second: T): T = if (first > second) first else second

fun <T> ensureTrailingPeriod(seq: T) where T : CharSequence, T : Appendable {
    if (!seq.endsWith('.')) {
        seq.append('.')
    }
}

// protect null
class Processor<T : Any> {
    fun process(value: T) {
        value.hashCode()
    }
}

inline fun <reified T> isA(value: Any) = value is T

inline fun <reified T> loadService() = ServiceLoader.load(T::class.java)

fun main() {
    println(listOf(1, 2, 3, 4, 5, 6).penultimate())
    println(oneHalf(3))
    println(max("kotlin", "java"))

    val helloWorld = StringBuilder("Hello World")
    ensureTrailingPeriod(helloWorld)
    println(helloWorld)

    val processor = Processor<String>()

    println(isA<String>("abc"))
    println(isA<Int>(123))
    println(listOf("one", 2, "three").filterIsInstance<String>())
}
