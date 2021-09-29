import java.time.LocalDate

// + : plus
// - : minus
// * : times
// / : div
// % : rem
data class Point(var x: Int, var y: Int): Comparable<Point> {
    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }
    operator fun plusAssign(other: Point) {
        this.x += other.x
        this.y += other.y
    }
    operator fun minus(other: Point): Point {
        return Point(x - other.x, y - other.y)
    }
    operator fun times(other: Point): Point {
        return Point(x * other.x, y * other.y)
    }
    operator fun div(other: Point): Point {
        return Point(x / other.x, y / other.y)
    }
    operator fun rem(other: Point): Point {
        return Point(x % other.x, y % other.y)
    }
    operator fun unaryMinus(): Point {
        return Point(-x, -y)
    }
    operator fun inc(): Point {
        return Point(x++, y++)
    }
    operator fun get(index: Int): Int {
        return when(index) {
            0 -> x
            1 -> y
            else -> throw IndexOutOfBoundsException("Invalid coordinate $index")
        }
    }
    operator fun set(index: Int, value: Int) {
        when(index) {
            0 -> x = value
            1 -> y = value
            else -> throw IndexOutOfBoundsException("Invalid coordinate $index")
        }
    }
    override fun compareTo(other: Point): Int {
        return compareValuesBy(this, other, Point::x, Point::y)
    }
    operator fun contains(other: Point): Boolean {
        return x == other.x && y == other.y
    }
}

fun main() {
    var p1 = Point(30, 40)
    val p2 = Point(30, 40)
    println(p1 + p2)
    println(p1 - p2)
    println(p1 * p2)
    println(p1 / p2)
    println(p1 % p2)
    p1 = p1 + p2
    println(p1)
    println(-p1)
    println(p1++)
    println(p1 == p2)
    println(p1 > p2)
    println(p1 < p2)
    println(p1[0])
    println(p1[1])
    p1[0] = 100
    println(p1[0])
    println(Point(100, 80) in p1)

    val now = LocalDate.now()
    val vacation = now..now.plusDays(10)
    println(now.plusWeeks(1) in vacation)
    (0..10).forEach { print(it) }
    println()
    for (c in "abc") {
        println(c)
    }
}
