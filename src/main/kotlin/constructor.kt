class UserConstructor constructor(val nickname: String, val isSubscribed: Boolean = true) {
}

fun main() {
    val kuckjwi = UserConstructor("kuckjwi")
    println(kuckjwi.isSubscribed)
    val gye = UserConstructor("ęłě", false)
    val hey = UserConstructor("íě", isSubscribed = false)
    println(gye.isSubscribed)
    println(hey.isSubscribed)
}
