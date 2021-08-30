import java.lang.IllegalArgumentException

// no sealed
interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun eval(e: Expr): Int =
    when (e) {
        is Num -> e.value
        is Sum -> eval(e.left) + eval(e.right)
        else -> throw IllegalArgumentException("Unknown expression")
    }

// sealed
sealed class SealedExpr {
    class SealedNum(val value: Int) : SealedExpr()
    class SealedFloat(val value: Float) : SealedExpr()
}


fun sealedEval(e: SealedExpr) =
    when (e) {
        is SealedExpr.SealedNum -> e.value
        is SealedExpr.SealedFloat -> e.value
    }

fun main() {
    val n1 = Num(1)
    val n2 = Num(2)
    val sum = Sum(n1, n2)
    println(eval(sum))

    val n3 = SealedExpr.SealedNum(1)
    val f1 = SealedExpr.SealedFloat(1.0f)

    println(sealedEval(n3))
    println(sealedEval(f1))
}