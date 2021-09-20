private data class People(
    val name: String,
    val age: Int,
)

fun main() {
    val max = listOf(1,2,3,4).maxByOrNull { it }
    println(max)

    val sum = { x: Int, y: Int -> x + y }
    println(sum(5, 5))

    run { println("Lambda run!") }

    println(listOf("kuckjwi", "isis").joinToString(separator = ",") { it })

    var counter = 0
    val inc = { counter++ }
    inc()
    println(counter)
    inc()
    println(counter)

    val list = listOf(1,2,3,4)
    println(list.filter { it > 1 })
    println(list.map { it * it })

    val peoples = listOf(People("kuckjwi", 30), People("kuckjwi2", 30), People("isis", 29))
    val maxAge = peoples.maxByOrNull(People::age)?.age
    // collection method is eager create
    println(peoples.filter { it.age == maxAge })
    println(peoples.all { it.age >= 30 })
    println(peoples.any { it.age >= 30 })
    println(peoples.count { it.age >= 29 })
    println(peoples.find { it.age >= 29 })
    println(peoples.groupBy { it.age })

    val numbers = mapOf(0 to "zero", 1 to "one")
    println(numbers.mapValues { it.value.toUpperCase() })

    val strings = listOf("abc", "def")
    println(strings.flatMap { it.toList() })

    // sequence
    // lazy
    println(peoples.asSequence()
        .map(People::name)
        .filter { it.startsWith("ku") }
        .toList())

    val naturalNumbers = generateSequence(0) { it + 1 }
    println(naturalNumbers.takeWhile{ it <= 100 }.sum())

    fun alphabet(): String {
        return with(StringBuilder()) {
            for (letter in 'A'..'Z') {
                append(letter)
            }
            toString()
        }
    }
    println(alphabet())

    fun alphabet2() = StringBuilder().apply {
        for (letter in 'A'..'Z') {
            append(letter)
        }
    }.toString()
    println(alphabet2())

    fun alphabet3() = buildString {
        for (letter in 'A'..'Z') {
            append(letter)
        }
    }
    println(alphabet3())
}
