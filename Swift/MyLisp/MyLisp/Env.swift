//
//  Env.swift
//  MyLisp
//
//  Created by 赵雅琦 on 2020/3/12.
//  Copyright © 2020 z. All rights reserved.
//

import Foundation

class Env{
//    var env =  [String: Expr]()
    var env =  [String: Any]()
    var topEnv:Env?
    
    init(env:Env? = nil) {
        topEnv = env
    }
    
//    func extend(key:String, value:Expr) {
    func extend(key:String, value:Any) throws {
        print("extend key and value:", "k", "v")
        if (env[key] == nil) {
            env.updateValue(value, forKey: key)
        }
        else {
            throw EvaluationError.AlreadyDefined
        }
    }
    
    func lookup(key:String) throws -> Any? {
        guard let value = env[key] else {
            guard let value = try topEnv?.lookup(key: key) else {
                throw EvaluationError.NotDefined
            }
            return value
        }
        return value
    }
}

