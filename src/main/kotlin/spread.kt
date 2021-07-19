fun main(args: Array<String>) {
    val list = listOf(*args)
    println(list)

    // to - infix
    val map = mapOf(1 to "one", 7 to "seven", 53 to "fifty-three")
    println(map)

    val (number, name) = 1 to "one"

    println(number)
    println(name)
}
