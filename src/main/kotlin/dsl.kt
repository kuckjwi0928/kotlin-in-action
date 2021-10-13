import java.time.LocalDate
import java.time.Period

fun buildString(action: StringBuilder.() -> Unit): String = StringBuilder().apply(action).toString()

open class Tag(val name: String) {
    private val children = mutableListOf<Tag>()
    protected fun <T: Tag> doInit(child: T, init: T.() -> Unit) {
        child.init()
        children.add(child)
    }
    override fun toString(): String = "<$name>${children.joinToString("")}</$name>"
}

fun table(init: TABLE.() -> Unit) = TABLE().apply(init)

class TABLE : Tag("table") {
    fun tr(init: TR.() -> Unit) = doInit(TR(), init)
}

class TR : Tag("tr") {
    fun td(init: TD.() -> Unit) = doInit(TD(), init)
}

class TD : Tag("td")

fun createTable() = table {
    tr {
        td {
        }
    }
}

class Greeter(private val greeting: String) {
    operator fun invoke(name: String) {
        println("$greeting, $name")
    }
}

data class Issue(
    val id: String,
    val project: String,
    val type: String,
    val priority: String,
    val description: String
)

class ImportantIssuesPredicate(val project: String) : (Issue) -> Boolean {
    override fun invoke(p1: Issue): Boolean {
        return p1.project == project && p1.isImportant()
    }

    private fun Issue.isImportant(): Boolean {
        return type == "BUG" && (priority == "Major" || priority == "Critical")
    }
}

interface Matcher<T> {
    fun test(value: T)
}

object start

infix fun String.should(x: start): StartWrapper = StartWrapper(this)

class StartWrapper(val value: String) {
    infix fun with(prefix: String) {
        if (!value.startsWith(prefix)) {
            throw AssertionError("String does not start with $prefix: $value")
        }
    }
}


val Int.days: Period
    get() = Period.ofDays(this)

val Period.ago: LocalDate
    get() = LocalDate.now() - this

val Period.fromNow: LocalDate
    get() = LocalDate.now() + this

fun main() {
    val s = buildString {
        append("kuckjwi")
    }
    println(s)
    println(createTable())

    val g = Greeter("hello!")
    g("kuckjwi")

    val result = listOf(
        Issue("KUCKJWI-1", "IDEA", "BUG", "Major", "It's bug"),
        Issue("KUCKJWI-2", "IDEA", "QUESTION", "medium", "It's not bug")
    )
        .filter(ImportantIssuesPredicate("IDEA"))

    println(result)

    "kotlin" should start with "kotlin"

    println(1.days.ago)
    println(1.days.fromNow)
}
