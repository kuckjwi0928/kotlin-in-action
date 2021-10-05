enum class Delivery { STANDARD, EXPEDITED }

class Order(val itemCount: Int)

fun getShippingCostCalculator(delivery: Delivery): (Order) -> Double {
    if (delivery == Delivery.EXPEDITED) {
        return { order -> 6 + 2.1 * order.itemCount }
    }
    return { order -> 1.2 * order.itemCount }
}

enum class OS { WINDOWS, LINUX, MAC, IOS, ANDROID }

data class SiteVisit(
    val path: String,
    val duration: Double,
    val os: OS
)

fun List<SiteVisit>.averageDurationFor(predicate: (SiteVisit) -> Boolean) = filter(predicate).map(SiteVisit::duration).average()
fun main() {
    val calc = getShippingCostCalculator(Delivery.EXPEDITED)
    println(calc(Order(3)))


    val log = listOf(
        SiteVisit("/", 34.0, OS.WINDOWS),
        SiteVisit("/", 22.0, OS.MAC),
        SiteVisit("/login", 12.0, OS.LINUX),
        SiteVisit("/singup", 8.0, OS.IOS),
        SiteVisit("/", 16.3, OS.ANDROID)
    )

    println(log.averageDurationFor{ it.os in setOf(OS.ANDROID, OS.IOS) })
}
