package test

import lab.Parser
import lab.TestDatas
import org.junit.Test

import org.junit.Assert.*

class ParserTest2 {

    @Test
    fun parse() {
        assertEquals(Parser(TestDatas.ast1).parse(), 3.0,       0.0);
//        assertEquals(Parser(TestDatas.ast2)  .parse(), 3.0,       0.0);
        assertEquals(Parser(TestDatas.ast3).parse(), 20.0,      0.0);
        assertEquals(Parser(TestDatas.ast4).parse(), 3.0,       0.0);
//        assertEquals(Parser(TestDatas.ast5)  .parse(), 3.0,       0.0);
        assertEquals(Parser(TestDatas.ast6).parse(), 5.0,       0.0);
        assertEquals(Parser(TestDatas.ast7).parse(), -15.0,     0.0);
        assertEquals(Parser(TestDatas.ast8).parse(), 1404.0,    0.0);
        assertEquals(Parser(TestDatas.ast9).parse(), -15.0,     0.0);
//        assertEquals(Parser(TestDatas.ast10) .parse(), 1.0,       0.0);
//        assertEquals(Parser(TestDatas.ast11) .parse(), 0.0,       0.0);
        assertEquals(Parser(TestDatas.ast12).parse(), 141858.0,  0.0);
        assertEquals(Parser(TestDatas.astl11).parse(), 10.0,      0.0);
        assertEquals(Parser(TestDatas.astl12).parse(), 10.0,      0.0);
        assertEquals(Parser(TestDatas.astl2).parse(), 100.0,     0.0);
        assertEquals(Parser(TestDatas.astl3).parse(), 1000.0,    0.0);
        assertEquals(Parser(TestDatas.astl4).parse(), 110.0,     0.0);
        assertEquals(Parser(TestDatas.astl5).parse(), 21.0,      0.0);
        assertEquals(Parser(TestDatas.astl7).parse(), 6.0,       0.0);
        assertEquals(Parser(TestDatas.astl9).parse(), 12.0,      0.0);
    }
}