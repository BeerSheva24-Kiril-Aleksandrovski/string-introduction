package telran.strings;

import static org.junit.jupiter.api.Assertions.*;
import static telran.strings.Strings.*;

import org.junit.jupiter.api.Test;

public class RegularExpressionsTest {
    @Test
    void javaVariableTest() {
        assertTrue("variableName".matches(javaVariable()));
        assertTrue("variable_Name1".matches(javaVariable()));
        assertTrue("VariableName".matches(javaVariable()));
        assertTrue("NUM_GEARS".matches(javaVariable()));
        assertTrue("variable$Name_1234".matches(javaVariable()));
        assertFalse("variable Name".matches(javaVariable()));
        assertFalse("1variableName".matches(javaVariable()));
        assertFalse("_VarName".matches(javaVariable()));
        assertFalse("$_varName".matches(javaVariable()));


    }
}
