
fun calc(ast: Any, env: Env): Double {
//    var env = env.copy()
    var env = Env(env)

    smartPrint("ast: $ast")
    if (ast == null) {
        throw Exception("Error: ast is null!")
    } else {
        when {
//            ast is Number -> {
            ast is kotlin.Number -> {
                smartPrint("ast:$ast is a Number")
                return ast.toDouble()
            }
            ast is String -> {
//                return env.lookup(ast) as Double
                return (env.lookup(ast) as Integer).toDouble()
            }
            (ast is List<*>).not() -> {
                smartPrint("ast:$ast is not an Array")
                error("Error: not a expression!")
            }
            else -> {
                smartPrint("ast:$ast is an Array")
                var op = (ast as List<Any>)[0]

                smartPrint("op is $op")
//                var v1 = calc(ast[1], env)
//                var ast0 = ast[0]
                var ast1 = ast[1]
//                var ast2: Any? = null
                var ast2: Any = 0
//                    calc(ast[2], env)
                //                    v2 = calc(ast[2] as List<*>, env)
                //                    v2 = ast[2]?.let { calc(it, env) }
                if (ast.count() > 2) ast2 = ast[2]

//                var fun1 = { calc(ast1, env)}
//                var fun2 = {
//                    if (ast2 != null) {
//                        calc(ast2, env)
//                    }
//                    else {
//                        0
//                    }
//                }

                smartPrint("numbers is $ast1 and $ast2")

                when (op) {
                    is List<*> -> {         //((lambda (x) exp) exp)
//                        var keyword = (ast1 as List<*>)[0]
                        var keyword = (op as List<*>)[0]
                        if (op.count() >= 3 && (keyword == "lambda" || keyword == "λ")) {
//                            var params = ast1[1] as List<*>
                            var params = op[1] as List<*>
                            var param1 = params[0] as String
                            env.extend(param1, ast1)
//                            return ast1[2]?.let { calc(it, env) }!!
                            return calc(op[2]!!, env)
                        } else {
                            error("error: Unsupported operation!")
                        }
                    }
                    "let" -> {
                        var bindings = ast1 as List<*>
                        if (bindings == null || bindings.count() == 0) {
                            error("let clause error: bindings error 1!")
                        } else {
                            var binding = bindings[0] as List<*>
//                            binding[1]?.let { env.extend(binding[0] as String, it) }!!
//                            binding[1]?.let { env.extend(binding[0] as String, it) }!!
                            env.extend(binding[0] as String, binding[1]!!)
                            return calc(ast2, env)
                        }
                    }
                    "+" -> {
//                        return ast1 + ast2
//                        return fun1() + fun2()
                        return calc(ast1, env) + calc(ast2, env)
                    }
                    "-" -> {
//                        return ast1 - ast2
                        return calc(ast1, env) - calc(ast2, env)
                    }
                    "*" -> {
//                        return ast1 * ast2
                        return calc(ast1, env) * calc(ast2, env)
                    }
                    "/" -> {
//                        return ast1 / ast2
                        return calc(ast1, env) / calc(ast2, env)
                    }
                    else -> {   // call, (exp1 exp)
//                        var expAst = env.lookup(ast1 as String)
                        var expAst = env.lookup(op as String)
                        smartPrint(expAst)
//                        return calc(listOf(expAst, ast2), env)
                        return calc(listOf(expAst, ast1), env)
                    }
                }
            }
        }
    }
}

fun calc(ast: Any): Double {
    return calc(ast, Env())
}