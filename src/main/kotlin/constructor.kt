class UserConstructor constructor(val nickname: String, val isSubscribed: Boolean = true) {
}

fun main() {
    val kuckjwi = UserConstructor("kuckjwi")
    println(kuckjwi.isSubscribed)
    val gye = UserConstructor("계영", false)
    val hey = UserConstructor("혜원", isSubscribed = false)
    println(gye.isSubscribed)
    println(hey.isSubscribed)
}
