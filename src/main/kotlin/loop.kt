import java.util.*

fun main() {
    for (i in 1..100) {
        print(fizzBuzz(i))
    }
    println()
    for (i in 100 downTo 1 step 2) {
        print(fizzBuzz(i))
    }
    println()
    mapIteration()
    listIteration()
    println(isLetter('a'))
    println(isNotDigit('a'))
}

fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz "
    i % 3 == 0 -> "Fizz "
    i % 5 == 0 -> "Buzz "
    else -> "$i "
}

fun mapIteration() {
    val binaryReps = TreeMap<Char, String>()
    for (c in 'A'..'F') {
        val binary = Integer.toBinaryString(c.toInt());
        binaryReps[c] = binary;
    }
    for ((letter, binary) in binaryReps) {
        println("$letter = $binary")
    }
}

fun listIteration() {
    val list = listOf("10", "11", "1001")
    for ((index, element) in list.withIndex()) {
        println("$index: $element")
    }
}

fun isLetter(c: Char) = c.toLowerCase() in 'a'..'z'

fun isNotDigit(c: Char) = c !in '0'..'9'
