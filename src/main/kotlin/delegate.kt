import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

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
    override fun addAll(elements: Collection<T>): Boolean {
        objectsAdded += elements.size
        return innerSet.addAll(elements)
    }
}

class LazyPerson(val name: String) {
    val emails by lazy { loadEmails() }
}

fun loadEmails(): List<String> = listOf("rnrghks09@gmail.com")

open class PropertyChangeAware {
    protected val changeSupport = PropertyChangeSupport(this)

    fun addPropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.addPropertyChangeListener(listener)
    }

    fun removePropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.removePropertyChangeListener(listener)
    }
}

class PersonProperty(val name: String, age: Int, salary: Int) : PropertyChangeAware() {
    private val observer = {
        prop: KProperty<*>, oldValue: Int, newValue: Int -> changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }

    var age: Int by Delegates.observable(age, observer)
    var salary: Int by Delegates.observable(salary, observer)
}

class PersonProperty2 {
    private val _attributes = hashMapOf<String, String>()
    val name: String by _attributes

    fun setAttributes(attrName: String, value: String) {
        _attributes[attrName] = value
    }
}

fun main() {
    val cset = CountingSet<Int>()
    cset.addAll(listOf(1, 1, 2))
    println(cset.objectsAdded)
    println(cset.size)

    println(LazyPerson("kuckjwi").emails)

    val p = PersonProperty("kuckjwi", 30, 100000000)
    p.addPropertyChangeListener { event -> println("Property ${event.propertyName} changed from ${event.oldValue} to ${event.newValue}") }
    p.age = 20
    p.salary = 10000000

    val p2 = PersonProperty2()
    p2.setAttributes("name", "kuckjwi")
    println(p2.name)
}
