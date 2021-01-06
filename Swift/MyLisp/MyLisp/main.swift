//
//  main.swift
//  MyLisp
//
//  Created by 赵雅琦 on 2020/3/12.
//  Copyright © 2020 z. All rights reserved.
//

import Foundation
import SwiftyJSON


//let jsonData = TestAst.ast1.data(using: .utf8)
//let jsonData = TestExp.ast3.data(using: .utf8)


func evaluate(exp:String) {
    let jsonData = exp.data(using: .utf8)
    if (jsonData != nil) {
        let ast = JSON(jsonData!)
        print(ast)
        print(type(of: ast))
        
        
        print(ast[0])
        print(ast[0][0][0][0])
        print(type(of: ast[0].string))
        print(type(of: ast[0].array))
//        print(type(of: ast[0]))
//        let result = caculate(ast: ast, env: Env())
//        print(result)

    }
}

func evaluate(ast:[Any]) throws {
    print(ast)
//    print(type(of: ast))
    let result = try caculate(ast: ast, env: Env())
    print("evaluate result:", result)
}


let dict:[Any] = [ "+", 1, 2, 1]
//print(dict)
//print(dict.count)
//print(type(of: dict[0]))
//print(type(of: dict[1]))

print(type(of: []))
//print(type(of: [1,2]) == [Int].Type)

func testType(o:Any)  {
    print(o)
}


testType(o: [1,2])
testType(o: [1,"a"])
testType(o: TestAst.ast3)

func testEnv() throws{
    let env1 = Env()
    //let env2 = env1.copy()
    let env2 = Env(env: env1)
    try env2.extend(key: "a", value: 1)
    try env2.extend(key: "b", value: 2)
    try env2.extend(key: "c", value: 3)
    try env2.extend(key: "d", value: 4)

    print(env1.env)
    print(env2.env)
    let v = try env2.lookup(key: "c")
    print(v ?? "")
}

//let a:Any = [1, 2]
var a:Any = [1, 2]
//let a:Any = [1, [1, 2]]
print(type(of: a))
//print(type(of: a) == [Int].Type)
print(a is Array<Any>)
print(a is Array<Int>)

let add = {(x:Int, y:Int) -> Int in
    a = [3, 4]
    return x + y
}
print(add)
print(add(2, 4))

func test(i:Int) -> Int {
    return i
}

var tt = test
print(tt(55))

//env1.tt2()

//let op = [
//    "+": {(x:Int, y:Int) -> Int in
//       return x + y
//    },
//]

//print(type(of: dict[1]) == )

//length(dict)

//for v in dict {
//    print(v)
//}

//for (key, value) in dict {
//   print("字典 key \(key) -  字典 value \(value)")
    
//    print(type(of: value))
//}

//print(type(of: "str"))
//print(type(of: [1,2]))
//print(type(of: dict))
//print(type(of: ["a":1,"b":2]))
//
//print(type(of: ["a":1,2:"b"]))

func testEvaluate() -> Void {
    do {
        //try evaluate(ast: TestAst.ast3)

        //try evaluate(ast: TestAst.ast3)
        //try evaluate(ast: TestAst.ast4)     //x
        //try evaluate(ast: TestAst.ast5)
        //try evaluate(ast: TestAst.ast6)
        //try evaluate(ast: TestAst.ast7)
        //try evaluate(ast: TestAst.ast8)
        //try evaluate(ast: TestAst.ast9)
        //try evaluate(ast: TestAst.ast10)
        //try evaluate(ast: TestAst.ast11)
        //try evaluate(ast: TestAst.ast12)


        //try evaluate(ast: TestAst.astl11)
        //try evaluate(ast: TestAst.astl12)
        //try evaluate(ast: TestAst.astl2)
        //try evaluate(ast: TestAst.astl3)
        //try evaluate(ast: TestAst.astl4)
        //try evaluate(ast: TestAst.astl5)
//        try evaluate(ast: TestAst.astl7)
//        try evaluate(ast: TestAst.astl9)

//        let parser = Parser(TestAst.ast3)
//        let parser = Parser(TestAst.ast4)
//        let parser = Parser(TestAst.ast5)
//        let parser = Parser(TestAst.ast6)
//        let parser = Parser(TestAst.ast7)
//        let parser = Parser(TestAst.ast8)
//        let parser = Parser(TestAst.ast9)
//        let parser = Parser(TestAst.ast10)
//        let parser = Parser(TestAst.ast11)
//        let parser = Parser(TestAst.ast12)
        
//        let parser = Parser(TestAst.astl11)
//        let parser = Parser(TestAst.astl12)
//        let parser = Parser(TestAst.astl2)
//        let parser = Parser(TestAst.astl3)
//        let parser = Parser(TestAst.astl4)
//        let parser = Parser(TestAst.astl5)
//        let parser = Parser(TestAst.astl7)
        let parser = Parser(TestAst.astl9)
        
        let expr:Expr = try parser.parse()
        print(expr)
        let num:Number = try expr.eval(env: Env()) as! Number
        print(num.value)
    }
    catch {
    //    print("error:" + error)
        print(error)
    }

}

testEvaluate()
