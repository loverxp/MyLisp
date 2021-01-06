//
//  TestData.swift
//  MyLisp
//
//  Created by 赵雅琦 on 2020/3/12.
//  Copyright © 2020 z. All rights reserved.
//

import Foundation

class TestAst{
    // static let ast1:[Any] = [ "+", 1, 2, 1]
    // static let ast1:[Any] = [ "+", 1, 2, 1]
    // static let ast:[Any] = [1, 2, "+", 1, 2, 1]]
    // static let ast2:[Any] = [ "+", 1, 2, 1]
    // static let ast3:[Any] = ["*", 4, 5]]
    static let ast3:[Any] = ["*", 4, 5]
    static let ast4:[Any] = ["*", ["+", 1, 2], ["-", 3, 2], ]
    // "not", "support",
    static let ast5:[Any] = ["*", ["+", 1, 2, 2], ["-", 3, 2]]
    static let ast6:[Any] = ["*", ["+", 1, ["+", 2, 2]], ["-", 3, 2]]
    static let ast7:[Any] = ["*", ["+", 3, 2], ["-", 4, 7]]
    static let ast8:[Any] = ["*", 52, 27]
    static let ast9:[Any] = ["*", ["+", 3, 2], ["-", 4, 7]]
    static let ast10:[Any] = ["/", 2, 2, 2, 2, 2, 2, 2]
    static let ast11:[Any] = ["-", 2, 2, 2, 2, 2, 2, 2]
    static let ast12:[Any] = ["*", 5254, 27]

    static let astl11:[Any] = [["lambda", ["x"], "x"], 10]
    static let astl12:[Any] = [["λ", ["x"], "x"], 10]
    static let astl2:[Any] = [["lambda", ["x"], ["*", "x", "x"]], 10]
    static let astl3:[Any] = [["lambda", ["x"], ["*", "x", ["*", "x", "x"]]], 10]

    static let astl4:[Any] = ["let", [["x", 10]], ["+", "x", ["*", "x", "x"]]]                       // 110
    static let astl5:[Any] = ["let", [["x", 4]], ["let", [["y", 5]], ["+", "y", ["*", "x", "x"]]]]   // 21
    // static let ast6:[Any] = [["define", "add", ["+", 10, 10]], "add"]],

    // 6
    static let astl7:[Any] =
        ["let", [["x", 2]],
           ["let", [["f", ["lambda", ["y"], ["*", "x", "y"]]]],
               ["f", 3]]]
       
    // 12
    static let astl9:[Any] =
        ["let", [["x", 2]],
           ["let", [["f", ["lambda", ["y"], ["*", "x", "y"]]]],
               ["let", [["x", 4]],
                   ["f", 3]]]]

}

class TestExp{
//    static let ast1 = [ "+", 1, 2, 1]
//    static let ast1 = "[ \"+\", 1, 2, 1]"
    // static let ast = "[1, 2, \"+\", 1, 2, 1]]"
    // static let ast2 = "[ \"+\", 1, 2, 1]"
    // static let ast3 = "[\"*\", 4, 5]]"
    static let ast3 = "[\"*\", 4, 5]"
    static let ast4 = "[\"*\", [\"+\", 1, 2], [\"-\", 3, 2], ]"
    // \"not\", \"support\",
    static let ast5 = "[\"*\", [\"+\", 1, 2, 2], [\"-\", 3, 2]]"
    static let ast6 = "[\"*\", [\"+\", 1, [\"+\", 2, 2]], [\"-\", 3, 2]]"
    static let ast7 = "[\"*\", [\"+\", 3, 2], [\"-\", 4, 7]]"
    static let ast8 = "[\"*\", 52, 27]"
    static let ast9 = "[\"*\", [\"+\", 3, 2], [\"-\", 4, 7]]"
    static let ast10 = "[\"/\", 2, 2, 2, 2, 2, 2, 2]"
    static let ast11 = "[\"-\", 2, 2, 2, 2, 2, 2, 2]"
    static let ast12 = "[\"*\", 5254, 27]"

    static let astl11 = "[[\"lambda\", [\"x\"], \"x\"], 10]"
    static let astl12 = "[[\"λ\", [\"x\"], \"x\"], 10]"
    static let astl2 = "[[\"lambda\", [\"x\"], [\"*\", \"x\", \"x\"]], 10]"
    static let astl3 = "[[\"lambda\", [\"x\"], [\"*\", \"x\", [\"*\", \"x\", \"x\"]]], 10]"


    static let astl4 = "[\"let\", [[\"x\", 10]], [\"+\", \"x\", [\"*\", \"x\", \"x\"]]]"                       // 110
    static let astl5 = "[\"let\", [[\"x\", 4]], [\"let\", [[\"y\", 5]], [\"+\", \"y\", [\"*\", \"x\", \"x\"]]]]"   // 21
    // static let ast6 = "[[\"define\", \"add\", [\"+\", 10, 10]], \"add\"]]",


    // 6
    static let astl7 = """
    ["static let", [["x", 2]],
        ["static let", [["f", ["lambda", ["y"], ["*", "x", "y"]]]],
            ["f", 3]]]
    """

    // 12
    static let astl9 = """
    ["static let", [["x", 2]],
        ["static let", [["f", ["lambda", ["y"], ["*", "x", "y"]]]],
            ["static let", [["x", 4]],
                ["f", 3]]]]
    """

}
