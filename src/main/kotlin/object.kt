import java.io.File

object CaseInsensitiveFileComparator : Comparator<File> {
    override fun compare(o1: File, o2: File): Int {
        return o1.path.compareTo(o2.path, ignoreCase = true)
    }
}

private data class Person(val name: String) {
    object NameComparator : Comparator<Person> {
        override fun compare(o1: Person, o2: Person): Int {
            return o1.name.compareTo(o2.name)
        }
    }
}

fun main() {
    val files = listOf(File("/Z"), File("/a"))
    println(CaseInsensitiveFileComparator.compare(File("/User"), File("/user")))
    println(files.sortedWith(CaseInsensitiveFileComparator))

    val person = listOf(Person("kuckjwi"), Person("isis"))
    println(person.sortedWith(Person.NameComparator))
}
