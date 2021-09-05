class DelegatingCollection<T> (
    innerList: Collection<T> = ArrayList()
) : Collection<T> by innerList {}

class CountingSet<T> (
    val innerSet: MutableCollection<T> = HashSet()
) : MutableCollection<T> by innerSet {
    var objectsAdded = 0
    override fun add(element: T): Boolean {
        objectsAdded++
        return innerSet.add(element)
    }
    override fun addAll(collection: Collection<T>): Boolean {
        objectsAdded += collection.size
        return innerSet.addAll(collection)
    }
}

fun main() {
    val cset = CountingSet<Int>()
    cset.addAll(listOf(1, 1, 2))
    println(cset.objectsAdded)
    println(cset.size)
}
