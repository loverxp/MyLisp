import java.lang.Exception

interface Expr {
    fun eval(env: Env): Expr
}

class Symbol(var symbol: String) : Expr {

    override fun eval(env: Env): Expr {
        val expr = env.lookup(symbol)
        return expr as Expr
    }
}

class Number(val value: Double) : Expr {

    override fun eval(env: Env): Expr {
        return this
    }
}

class LambdaExpr(var symbol: String, var expr: Expr) : Expr {

    override fun eval(env: Env): Expr {
        return this
    }
}


class LetExpr(
    private var binding: Pair<String, Expr>,//    private var binding: (String, Expr)
    private var expr: Expr
) : Expr {

    override fun eval(env: Env): Expr {
        val (symbol, expr) = this.binding
        val newEnv = Env(topEnv = env)
        newEnv.extend(key = symbol, value = expr.eval(env = env))
        return this.expr.eval(env = newEnv)
    }
}

class CallExpr(private var expr1: Expr, private var expr2: Expr) : Expr {

    override fun eval(env: Env): Expr {
        val lambdaExpr: LambdaExpr = this.expr1.eval(env = env) as LambdaExpr
        val newEnv = Env(topEnv = env)
        newEnv.extend(key = lambdaExpr.symbol, value = expr2.eval(env = env))

        return lambdaExpr.expr.eval(env = newEnv)
    }
}

class CalcExpr(private var op: String, private var expr1: Expr, private var expr2: Expr) : Expr {

    override fun eval(env: Env): Expr {
        val v1 = this.calcExpr(expr = this.expr1, env = env)
        val v2 = this.calcExpr(expr = this.expr2, env = env)
        val num = when (this.op) {
            "+" -> v1 + v2
            "-" -> v1 - v2
            "*" -> v1 * v2
            "/" -> v1 / v2
            else -> throw Exception("unsupported op: ${this.op}!")
        }
        return Number(value = num)
    }

    private fun calcExpr(expr: Expr, env: Env): Double {
        return if (expr is Number) {
            expr.value
        } else {
            calcExpr(expr = expr.eval(env = env), env = env)
        }
    }
}



