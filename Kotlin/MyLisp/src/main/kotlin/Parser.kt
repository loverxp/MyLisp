import kotlin.math.exp

class Parser(private var expr: Any) {

    public fun parse(): Double {
        val expr = parse(ast = expr).eval(Env())
        val result = (expr as Number).value
        println("result: $result")
        return result
//        return (expr as kotlin.Number).value
//        return parse(ast = expr)
    }

    private fun parse(ast: Any): Expr {
        println(ast)
        return when (ast) {
            is Int     -> Number(value = ast.toDouble())
            is Double  -> Number(value = ast)
            is String  -> Symbol(symbol = ast)
            is List<*> -> parseList(ast = ast as List<Any>)
            else       -> throw Exception(" TypeNotSupported")
        }
    }

    private fun parseLet(bindings: List<Any>, expr: Any): Expr {
        if (bindings.isNotEmpty()) {
            for (binding in bindings) {
                val binding = binding as List<Any>
                if (binding.size == 2) {
                    val binding = Pair(binding[0] as String, parse(ast = binding[1]))
                    val expr = parse(ast = expr)
                    return LetExpr(binding = binding, expr = expr)
                } else {
                    throw Exception(" BindingError2")
                }
            }
            throw Exception("BindingError3")    //no use
        } else {
            throw Exception("BindingError1")
        }
    }

    private fun parseCall(ast1: Any, ast2: Any): Expr {
        val expr1 = parse(ast = ast1)
        val expr2 = parse(ast = ast2)
        return CallExpr(expr1 = expr1, expr2 = expr2)
    }

    private fun parseLambda(expr1: Any, expr2: Any): Expr {
//        if (expr1 !is List <String>) {
        if (expr1 !is List<*>) {
            throw Exception(" LambdaParamError")
        }
        val param = (expr1 as List<String>)[0]
        val expr = parse(ast = expr2)
        return LambdaExpr(symbol = param, expr = expr)
    }

    private fun parseCalc(op: String, expr1: Any, expr2: Any): Expr {
        val expr1 = parse(ast = expr1)
        val expr2 = parse(ast = expr2)

        return when (op) {
            "+", "-", "*", "/" -> CalcExpr(op = op, expr1 = expr1, expr2 = expr2)
            else               -> throw Exception(" OpNotSupported")
        }
    }

    private fun parseList(ast: List<Any>): Expr {
        when (ast.size) {
            2    -> {
                val ast1 = ast[0]
                val ast2 = ast[1]
                return parseCall(ast1 = ast1, ast2 = ast2)
            }
            3    -> {
                val exp1 = ast[0] as String
                val exp2 = ast[1]
                val exp3 = ast[2]
                return when (exp1) {
                    "let"         -> parseLet(bindings = exp2 as List<Any>, expr = exp3)
                    "λ", "lambda" -> parseLambda(expr1 = exp2, expr2 = exp3)
                    else          -> parseCalc(op = exp1, expr1 = exp2, expr2 = exp3)
                }
            }
            else -> {
                throw Exception(" UnsupportedLengthOfExpr")
            }
        }
    }

}

