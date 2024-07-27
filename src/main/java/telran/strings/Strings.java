package telran.strings;

public class Strings {
    public static String firstName () {
        //regex for strings starting with capital letter and rest as lower case
        //minimal length is 5 
        return "[A-Z][a-z]{4,}";
    }
    public static String javaVariable () {
        //regular expression for testing syntax of Java variable names
        return "[A-Za-z][0-9A-Za-z_$]*$";
    }
}
