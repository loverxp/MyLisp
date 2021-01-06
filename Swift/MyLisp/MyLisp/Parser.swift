//
//  Parser.swift
//  MyLisp
//
//  Created by 赵雅琦 on 2020/4/13.
//  Copyright © 2020 z. All rights reserved.
//

import Foundation


enum EvaluationError: Error {
    case Zero
    case One    
    case Two
    case Three
//    case Four
    case UnsupportedLengthOfExpr
    case BindingError1
    case BindingError2
    case BindingError3
    case OpNotSupported
    case AlreadyDefined
    case NotDefined
    case TypeNotSupported
    case LambdaParamError
}

class Parser {
    var expr: Any
    init(_ expr: Any) {
        self.expr = expr
    }
    
    public func parse() throws -> Expr {
        return try parse(ast: expr)
    }
    
    func parse(ast:Any) throws -> Expr {
        print(ast)
        switch ast {
        case is Int:
            return Number(value: Double(ast as! Int))
        case is Double:
            return Number(value: ast as! Double)
        case is String:
            return Symbol(symbol: ast as! String)
        case is Array<Any>:
            return try parseArray(ast: ast as! Array<Any>)
        default:
            throw EvaluationError.TypeNotSupported
        }
    }
    
    private func parseLet(bindings: Array<Any>, expr: Any) throws -> Expr {
        if bindings.count > 0 {
            for binding in bindings {
                let binding = binding as! Array<Any>
                if binding.count == 2 {
                    let binding = (binding[0] as! String, try parse(ast: binding[1]))
                    let expr = try parse(ast: expr)
                    return LetExpr(binding: binding, expr: expr)
                }
                else {
                    throw EvaluationError.BindingError2
                }
            }
            throw EvaluationError.BindingError3     // TODO: No use
        }
        else {
            throw EvaluationError.BindingError1
        }
    }
    
    private func parseCall(ast1: Any, ast2: Any) throws -> Expr {
        let expr1 = try parse(ast: ast1)
        let expr2 = try parse(ast: ast2)
        return CallExpr(expr1: expr1, expr2: expr2)
    }
    
    private func parseLambda(expr1: Any, expr2: Any) throws -> Expr {
        guard expr1 is Array<String> else {
            throw EvaluationError.LambdaParamError
        }
        let param = (expr1 as! Array<String>)[0] as String
        let expr = try parse(ast: expr2)
        return LambdaExpr(symbol: param, expr: expr)
    }
    
    private func parseCalc(op: String, expr1: Any,  expr2: Any) throws -> Expr {
        let expr1 = try parse(ast:  expr1)
        let expr2 = try parse(ast:  expr2)
        
        switch op {
        case "+": fallthrough
        case "-": fallthrough
        case "*": fallthrough
        case "/":
            return CalcExpr(op: op, expr1:  expr1, expr2: expr2)
        default: throw EvaluationError.OpNotSupported
        }
    }
    
    private func parseArray(ast:Array<Any>) throws -> Expr {
        if ast.count == 2 {
            let ast1 = ast[0]
            let ast2 = ast[1]
            
            return try parseCall(ast1: ast1, ast2: ast2)
        }
        else if ast.count == 3 {
            let exp1 = ast[0] as! String
            let exp2 = ast[1]
            let exp3 = ast[2]
            switch exp1 {
            case "let":
                return try parseLet(bindings: exp2 as! Array<Any>, expr: exp3)
            case "λ": fallthrough
            case "lambda":
                return try parseLambda(expr1: exp2, expr2: exp3)
            default:
                return try parseCalc(op: exp1, expr1: exp2, expr2: exp3)
            }
        }
        else {
            throw EvaluationError.UnsupportedLengthOfExpr
        }
    }
    
}

