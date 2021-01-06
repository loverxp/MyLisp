package intepreter;

import forJava.Env;
import lab.TestDatas;

import java.util.Arrays;
import java.util.List;


public class Main {

    private static class IntepreterException extends Exception {

        public IntepreterException(String s) {
            super(s);
        }
    }

    public static void main(String[] args) {
//        testArray();
//        testKotlin();
//        testNumber();
        try {
            evaluate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void smartPrint(Object obj) {
        System.out.println(obj.toString());
//        Integer x = 5,y = 10;

    }

    private static Double calc(Object ast, Env topEnv) throws IntepreterException {
        Env env = topEnv.copy();
        smartPrint(ast.toString());

        if (ast == null) {
            throw new IntepreterException("1");
        } else {
            if (ast instanceof Number) {
                return ((Number) ast).doubleValue();
            } else if (ast instanceof String) {
                Number value = (Number) env.lookup(ast.toString());
                return value.doubleValue();
            } else if (!(ast instanceof List)) {
                throw new IntepreterException("1");
            } else {
                List list = (List) ast;

                if (list.size() == 3) {
                    String op = (String) list.get(0);
                    if (op == "let") {
                        List bindings = (List) list.get(1);
                        Object exp = list.get(2);
                        List binding = (List) bindings.get(0);
                        env.extend((String) binding.get(0), binding.get(1));
                        return calc(exp, env);
                    } else {
                        Double v1 = calc(list.get(1), env);
                        Double v2 = calc(list.get(2), env);
                        switch (op) {
                            case "+":
                                return (v1 + v2);
                            case "-":
                                return (v1 - v2);
                            case "*":
                                return (v1 * v2);
                            case "/":
                                return (v1 / v2);
                            default:
                                throw new IntepreterException("5");
                        }
                    }
                } else if (list.size() == 2) {
                    Object exp1 = list.get(0);
                    Object exp2 = list.get(1);
                    if (exp1 instanceof String) {                                       // call, (exp1 exp)
                        Object expAst = env.lookup((String) exp1);
                        smartPrint(expAst);
                        List newExp = Arrays.asList(new Object[]{expAst, exp2});
                        return calc(newExp, env);
                    } else if ((exp1 instanceof List) && ((List) exp1).size() >= 3) {     // ((lambda (x) exp) exp)
                        List lambda = (List) exp1;
                        String keyword = (String) lambda.get(0);
                        if (keyword == "lambda" || keyword == "λ") {
                            List params = (List) lambda.get(1);
                            String param1 = (String) params.get(0);
                            env.extend(param1, exp2);
                            return calc(lambda.get(2), env);
                        } else {
                            throw new IntepreterException("lambda");
                        }
                    } else {
                        throw new IntepreterException("4");
                    }
                } else {
                    throw new IntepreterException("3");
                }
            }
        }
//        return 0.0;
    }

    private static void evaluate() throws IntepreterException {
//        Double result = calc(TestDatas.Companion.getAst1(), new Env());
//        Double result = calc(TestDatas.Companion.getAst1(), new Env());
//        Double result = calc(TestDatas.Companion.getAst2(), new Env());
//        Double result = calc(TestDatas.Companion.getAst3(), new Env());
//        Double result = calc(TestDatas.Companion.getAst4(), new Env());
//        Double result = calc(TestDatas.Companion.getAst5(), new Env());
//        Double result = calc(TestDatas.Companion.getAst6(), new Env());
//        Double result = calc(TestDatas.Companion.getAst7(), new Env());
//        Double result = calc(TestDatas.Companion.getAst8(), new Env());
//        Double result = calc(TestDatas.Companion.getAst9(), new Env());
//        Double result = calc(TestDatas.Companion.getAst10(), new Env());
//        Double result = calc(TestDatas.Companion.getAst11(), new Env());
//        Double result = calc(TestDatas.Companion.getAst12(), new Env());

//        Double result = calc(TestDatas.Companion.getAstl11(), new Env());
//        Double result = calc(TestDatas.Companion.getAstl12(), new Env());
//        Double result = calc(TestDatas.Companion.getAstl2(), new Env());
//        Double result = calc(TestDatas.Companion.getAstl3(), new Env());
//        Double result = calc(TestDatas.Companion.getAstl4(), new Env());
//        Double result = calc(TestDatas.Companion.getAstl5(), new Env());
//        Double result = calc(TestDatas.Companion.getAstl7(), new Env());
        Double result = calc(TestDatas.Companion.getAstl9(), new Env());

        smartPrint(result);
    }

    private static void testKotlin() {
//        smartPrint(TestDatas.Companion.getAst1());
//        smartPrint(TestDatas.Companion.getAst2());
//        smartPrint(TestDatas.Companion.getAstl11());
        Object ast = TestDatas.Companion.getAstl11();
//        smartPrint(ast);
//        smartPrint(ast.toString());
    }

    private static void testArray() {
        //	    Object[] array = {1,2,3};
        Object[] array = {1, 2, 3, "fa"};
//        Object array = {1,2,3,"fa"};
        Object obj = array;
        Object num = 10;
        smartPrint(array);
        smartPrint("main");
        smartPrint(num);

//        TestDatas.TestDatas.ast1
//        main.Test

        TestDatas.Companion.getAst1();
//        TestDa

        Object[] array2 = {array, array, 1, "str"};
//        Object[] array2 = {new Object[]{1,2,3,"fa"},array,1,"str"};
//        Object[] array2 = { {1,2,3,"fa"},array,1,"str"};

//        Object array2 = {array,array,1,"str"};
//        Object array2 = {array,array,1,"str"};
        Object arr2 = array2;

        smartPrint(array2);

        int[][] arr = {{1, 2, 3}, {4, 6}, {6}};
        smartPrint(arr);

//        JSONArray
//        JsonArray
    }

    //    static void smartPrint(String str) {

    private static void testNumber() {
//        Number x = 5,y = 10;
//        Byte x = 5,y = 10;
//        smartPrint(x + y);
    }
}
