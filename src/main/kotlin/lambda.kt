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
}
