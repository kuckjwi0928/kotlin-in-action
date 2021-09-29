class Destruct(val x: Int, val y: Int) {
    operator fun component1() = x
    operator fun component2() = y
}

data class NameComponents(val name: String, val extension: String)

fun spiltFileName(fullName: String): NameComponents {
    val (name, ext) = fullName.split(".", limit = 2)
    return NameComponents(name, ext)
}

fun main() {
    val destruct = Destruct(1, 2)
    val (x, y) = destruct
    println(x)
    println(y)

    val (name, ext) = spiltFileName("example.kt")
    println(name)
    println(ext)
}
