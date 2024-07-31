package telran.strings;

import static org.junit.jupiter.api.Assertions.*;
import static telran.strings.Strings.*;

import org.junit.jupiter.api.Test;

public class RegularExpressionsTest {
    @Test
    void javaVariableTrueTest() {
        assertTrue("variableName".matches(javaVariable()));
        assertTrue("variable_Name1".matches(javaVariable()));
        assertTrue("VariableName".matches(javaVariable()));
        assertTrue("NUM_GEARS".matches(javaVariable()));
        assertTrue("variable$Name_1234".matches(javaVariable()));
        assertTrue("_VarName".matches(javaVariable()));
        assertTrue("$_varName".matches(javaVariable()));
    }
    @Test
    void javaVariableFalseTest () {
        assertFalse("variable Name".matches(javaVariable()));
        assertFalse("1variableName".matches(javaVariable()));
        assertFalse("1".matches(javaVariable()));
        assertFalse("1name".matches(javaVariable()));
        assertFalse("1_a".matches(javaVariable()));
        assertFalse("_".matches(javaVariable()));
        assertFalse("#1".matches(javaVariable()));
        assertFalse("_*".matches(javaVariable())); 
        assertFalse("ab_cd_$12?".matches(javaVariable()));
        assertFalse("ab_cd_$12 ".matches(javaVariable()));
    }
    @Test
    void isArithmeticExpressionTrueTest() {
        assertTrue(isArithmeticExpression("10 - $var15"));
        assertTrue(isArithmeticExpression("-8 / -2.5 + 4"));
        assertTrue(isArithmeticExpression("(abs / 2) + (4)"));
        assertTrue(isArithmeticExpression("((3 + (4.9 - (-2 * -var))))"));
    }
    @Test
    void isArithmeticExpressionFalseTest() {
        assertFalse(isArithmeticExpression("(3( + )5"));
        assertFalse(isArithmeticExpression("(3 +/ 5)"));
        assertFalse(isArithmeticExpression("(  ) - 2 * 3"));
        assertFalse(isArithmeticExpression("(10 - 2 * 3var)"));
        assertFalse(isArithmeticExpression("((10 - _$) * 3.923))"));
        assertFalse(isArithmeticExpression("(10 - gtr) * )3("));
    }
    @Test
    void bracketsCheckerTrueTest () {
        assertTrue(bracketsChecker("(10 - 5)"));
        assertTrue(bracketsChecker("((10) - (5))"));
        assertTrue(bracketsChecker("((((10)) - ((5))))"));
    }
    @Test
    void bracketsCheckerFalseTest () {
        assertFalse(bracketsChecker("((10 - 5)"));
        assertFalse(bracketsChecker("((10) - (5)))"));
        assertFalse(bracketsChecker("((((10)))) - )5))))"));
        assertFalse(bracketsChecker(")10)) - ((5))))"));
        assertFalse(bracketsChecker("((((10)) - ((5"));

    }
}
