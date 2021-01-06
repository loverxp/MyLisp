package test

//import calcV1
import calc
import lab.TestDatas
import org.junit.Assert.*

class InterpreterKtTest {

    @org.junit.Test
    fun calcV1() {
        assertEquals(calc(TestDatas.ast1),  3.0,       0.0);
        assertEquals(calc(TestDatas.ast2),  3.0,       0.0);
        assertEquals(calc(TestDatas.ast3),  20.0,      0.0);
        assertEquals(calc(TestDatas.ast4),  3.0,       0.0);
        assertEquals(calc(TestDatas.ast5),  3.0,       0.0);
        assertEquals(calc(TestDatas.ast6),  5.0,       0.0);
        assertEquals(calc(TestDatas.ast7),  -15.0,     0.0);
        assertEquals(calc(TestDatas.ast8),  1404.0,    0.0);
        assertEquals(calc(TestDatas.ast9),  -15.0,     0.0);
        assertEquals(calc(TestDatas.ast10), 1.0,       0.0);
        assertEquals(calc(TestDatas.ast11), 0.0,       0.0);
        assertEquals(calc(TestDatas.ast12), 141858.0,  0.0);
        assertEquals(calc(TestDatas.astl11),10.0,      0.0);
        assertEquals(calc(TestDatas.astl12),10.0,      0.0);
        assertEquals(calc(TestDatas.astl2), 100.0,     0.0);
        assertEquals(calc(TestDatas.astl3), 1000.0,    0.0);
        assertEquals(calc(TestDatas.astl4), 110.0,     0.0);
        assertEquals(calc(TestDatas.astl5), 21.0,      0.0);
        assertEquals(calc(TestDatas.astl7), 6.0,       0.0);
        assertEquals(calc(TestDatas.astl9), 12.0,      0.0);
    }

    @org.junit.Test
    fun testCalcV1() {
    }
}