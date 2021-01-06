class TestDatas {
    companion object {
        //        final var ast1 = "ast1"
        final var ast1 = listOf("+", 1, 2, 1)

        // final var ast = listOf(1, 2, "+", 1, 2, 1))
         final var ast2 = listOf( "+", 1, 2, 1)
        // final var ast3 = listOf("*", 4, 5))

        final var ast3 = listOf("*", 4, 5)
        final var ast4 = listOf("*", listOf("+", 1, 2), listOf("-", 3, 2))        // 3

        // "not", "support",
        final var ast5 = listOf("*", listOf("+", 1, 2, 2), listOf("-", 3, 2))

        final var ast6 = listOf("*", listOf("+", 1, listOf("+", 2, 2)), listOf("-", 3, 2))
        final var ast7 = listOf("*", listOf("+", 3, 2), listOf("-", 4, 7))
        final var ast8 = listOf("*", 52, 27)
        final var ast9 = listOf("*", listOf("+", 3, 2), listOf("-", 4, 7))
        final var ast10 = listOf("/", 2, 2, 2, 2, 2, 2, 2)
        final var ast11 = listOf("-", 2, 2, 2, 2, 2, 2, 2)
        final var ast12 = listOf("*", 5254, 27)


        final var astl11 = listOf(listOf("lambda", listOf("x"), "x"), 10)
        final var astl12 = listOf(listOf("λ", listOf("x"), "x"), 10)
        final var astl2 = listOf(listOf("lambda", listOf("x"), listOf("*", "x", "x")), 10)
        final var astl3 = listOf(listOf("lambda", listOf("x"), listOf("*", "x", listOf("*", "x", "x"))), 10)


        final var astl4 = listOf("let", listOf(listOf("x", 10)), listOf("+", "x", listOf("*", "x", "x")))                       // 110
        final var astl5 = listOf("let", listOf(listOf("x", 4)), listOf("let", listOf(listOf("y", 5)), listOf("+", "y", listOf("*", "x", "x"))))   // 21

        final var astl7 = listOf("let", listOf(listOf("x", 2)),
            listOf("let", listOf(listOf("f", listOf("lambda", listOf("y"), listOf("*", "x", "y")))),
                listOf("f", 3)))

        // 12
        final var astl9 = listOf("let", listOf(listOf("x", 2)),
            listOf("let", listOf(listOf("f", listOf("lambda", listOf("y"), listOf("*", "x", "y")))),
                listOf("let", listOf(listOf("x", 4)),
                    listOf("f", 3))))


    }

}