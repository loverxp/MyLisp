//
//  Expr.swift
//  MyLisp
//
//  Created by 赵雅琦 on 2020/4/13.
//  Copyright © 2020 z. All rights reserved.
//

import Foundation

protocol Expr {
    func eval(env: Env) throws -> Expr
}

class Symbol: Expr {
    var symbol: String
    
    init(symbol:String) {
        self.symbol = symbol
    }

    func eval(env: Env) throws -> Expr{
        let expr = try env.lookup(key: symbol);
        return expr as! Expr
    }
}

class Number: Expr {
    let value: Double

    init(value:Double) {
        self.value = value
    }
    
    func eval(env: Env) -> Expr{
        return self
    }
}

class LambdaExpr: Expr {
    var symbol: String
    var expr: Expr
    
    init(symbol:String,expr:Expr) {
       self.symbol = symbol
       self.expr = expr
    }
    
    func eval(env: Env) -> Expr{
        return self
    }
}


class LetExpr: Expr {
    var binding: (String, Expr)
    var expr: Expr

    init(binding:(String, Expr), expr:Expr) {
        self.binding = binding
        self.expr = expr
    }

    func eval(env: Env) throws -> Expr{
        let (symbol, expr) = self.binding
        let newEnv = Env(env: env)
        try newEnv.extend(key: symbol, value: expr.eval(env: env))
        return try self.expr.eval(env: newEnv);
    }
}


class CallExpr: Expr {
    var expr1: Expr
    var expr2: Expr
    
    init(expr1:Expr, expr2:Expr) {
        self.expr1 = expr1
        self.expr2 = expr2
    }
    
    func eval(env: Env) throws -> Expr{
        let lambdaExpr: LambdaExpr = try self.expr1.eval(env: env) as! LambdaExpr;
        let param: String = lambdaExpr.symbol;
        let expr: Expr = lambdaExpr.expr;

        let newEnv = Env(env: env);
        try newEnv.extend(key: param, value: expr2.eval(env: env))
        
        return try expr.eval(env: newEnv)
    }
}


class CalcExpr: Expr {
    var op: String
    var expr1: Expr
    var expr2: Expr
    
    init(op: String, expr1:Expr, expr2:Expr) {
        self.op = op
        self.expr1 = expr1
        self.expr2 = expr2
    }
    
    func eval(env: Env) throws -> Expr{
        var num = 0.0
        let v1 = try self.calcExpr(expr: self.expr1, env: env)
        let v2 = try self.calcExpr(expr: self.expr2, env: env)
        switch op {
        case "+":
            num = v1 + v2
        case "-":
            num = v1 - v2
        case "*":
            num = v1 * v2
        case "/":
            num = v1 / v2
        default: break
//            throw ""
        }
        return Number(value: num)
    }
    
    func calcExpr(expr: Expr, env: Env) throws -> Double {
        if (expr is Number){
            return (expr as! Number).value
        }
        else{
            return try calcExpr(expr: expr.eval(env: env), env: env)
        }

    }
}



