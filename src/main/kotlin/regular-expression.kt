fun main() {
    println("12.345-6.A".split(".", "-"))
    parsePath("/Users/kuckjwi/source/test.txt")
    parsePathWithRegex("/Users/kuckjwi/source/test.txt")
}

fun parsePath(path: String) {
    val directory = path.substringBeforeLast("/")
    val fullName = path.substringAfterLast("/")
    val extension = fullName.substringAfterLast(".")
    println(directory)
    println(fullName)
    println(extension)
}

fun parsePathWithRegex(path: String) {
    val regex = """(.+)/(.+)\.(.+)""".toRegex()

    regex.matchEntire(path)?.let {
        val (dir, name, ext) = it.destructured
        println(dir)
        println(name)
        println(ext)
    }
}