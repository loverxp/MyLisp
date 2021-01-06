//
//  interpreter.swift
//  MyLisp
//
//  Created by 赵雅琦 on 2020/4/8.
//  Copyright © 2020 z. All rights reserved.
//

import Foundation

//func caculate(ast:Array<Any>, env:Env) -> Any {
fileprivate func isNumber(_ ast: Any) -> Bool {
    return ast is Int || ast is Float
}

fileprivate func isSymbol(_ ast: Any) -> Bool {
    return ast is String
}

fileprivate func isArray(_ ast: Any) -> Bool {
    return ast is Array<Any>
}

//func caculate(ast:Any, env:Env) throws -> Any {
//func caculate(ast:Any, env:Env) throws -> Any {
func caculate(ast:Any, env:Env) throws -> Any {
    print(ast)
    let env = Env(env: env)
    if isNumber(ast) {
        return ast
    }
    else if isSymbol(ast) {
        return try env.lookup(key: ast as! String)
    }
    else if isArray(ast) {
//        let astArray = ast as! Array<Any>
        let ast = ast as! Array<Any>
        if ast.count == 2 {
            let ast1 = ast[0]
            let ast2 = ast[1]
//            let (ast1, ast2) = ast;
            if ast1 is String {             // call, (exp1 exp)
                let exp = try env.lookup(key: ast1 as! String)
                return try caculate(ast: [exp ?? nil, ast2], env: env)
            }
            else if ast1 is Array<Any> && (ast1 as! Array<Any>).count >= 3 {
                let key = (ast1 as! Array<Any>)[0] as? String
                if key == "lambda" || key == "λ" {
                    let ast = ast1 as! Array<Any>
                    let params = ast[1] as! Array<Any>
                    let param1 = params[0]
//                    env.extend(key: param1 as! String, value: ast2)
                    let expr = try caculate(ast: ast2, env: env)
                    try env.extend(key: param1 as! String, value: expr)
//                    return try caculate(ast: (ast2 as! Array<Any>)[2], env: env)
                    return try caculate(ast: ast[2], env: env)
                }
                else {
                    throw EvaluationError.Three
                }
            }
            else {
                throw EvaluationError.Two
            }
        }
        else if ast.count == 3 {
            let exp1 = ast[0] as! String
            let exp2 = ast[1]
            let exp3 = ast[2]
//                        let [exp1,exp2,exp3] = ast
//            let op = exp1 as! String
            if exp1 == "let" {
                let bindings = exp2 as! Array<Any>
                if bindings.count > 0 {
                    for binding in bindings {
                        let binding = binding as! Array<Any>
                        if binding.count == 2 {
                            try env.extend(key: binding[0] as! String, value: binding[1])
                        }
                        else {
                            throw EvaluationError.BindingError2
                        }
                        return try caculate(ast: exp3, env: env)
                    }
                }
                else {
                    throw EvaluationError.BindingError1
                }
            }
            else {
                let x = try caculate(ast: exp2, env: env) as! Int
                let y = try caculate(ast: exp3, env: env) as! Int
                var result = 0
                switch exp1 {
                case "+": result = x + y
                case "-": result = x - y
                case "*": result = x * y
                case "/": result = x / y
                default: throw EvaluationError.OpNotSupported
                }
                return result
            }
        }
        else {
            throw EvaluationError.One
        }
    }
    else {
        throw EvaluationError.Zero
    }
     
    return ""
}
