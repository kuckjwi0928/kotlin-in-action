class Outer {
    inner class Inner {
        fun getOuterReference(): Outer = this@Outer
    }

    class Inner2 {
        fun getOuterReference(): Outer = Outer()
    }
}

fun main() {
    println(Outer().Inner().getOuterReference())
    println(Outer.Inner2().getOuterReference())
}
