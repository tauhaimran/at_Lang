import java.util.regex.*;
//import java.util.regex.*;

public class regexTester {


    public static void main(String[] args) {
    
               // Integer test
               /*System.out.println("INT Validation (42): " + regex.validate("42", Pattern.compile(regex.INT)));
                       // Decimal test
               System.out.println("DEC Validation (3.14159): " + regex.validate("3.14159", Pattern.compile(regex.DEC)));
                       // Boolean test
               System.out.println("BOOL Validation (true): " + regex.validate("true", Pattern.compile(regex.BOOL)));
                       // Character test
               System.out.println("CHAR Validation ('A'): " + regex.validate("'A'", Pattern.compile(regex.CHAR)));
                       // String test
               System.out.println("STR Validation (\"Hello\"): " + regex.validate("\"Hello\"", Pattern.compile(regex.STR)));
                       // Variable test
               System.out.println("VAR Validation (myvar): " + regex.validate("myvar", Pattern.compile(regex.VAR)));
                       // Assignment test cases
               System.out.println("ASSIGN Validation (x@INT @ 5 + 3;): " + regex.validate("x@INT @ 5 + 3;", regex.ASSIGN));
               System.out.println("ASSIGN Validation (y@DEC @ 4.5 * 2;): " + regex.validate("y@DEC @ 4.5 * 2;", regex.ASSIGN));
               System.out.println("ASSIGN Validation (z@DEC @ 2 ^ 3 + 4;): " + regex.validate("z@DEC @ 2 ^ 3 + 4;", regex.ASSIGN));
               System.out.println("ASSIGN Validation (a@INT @ 10 % 3 + 1, b@DEC @ 5.2 / 2;): " + regex.validate("a@INT @ 10 % 3 + 1, b@DEC @ 5.2 / 2;", regex.ASSIGN));
               System.out.println("ASSIGN Validation (x@INT @ (5 + 3) * 2;): " + regex.validate("x@INT @ (5 + 3) * 2;", regex.ASSIGN));
                       // Additional test cases
               System.out.println("ASSIGN Validation (x@INT @ (((1 + 2) * 3) / 2);): " + regex.validate("x@INT @ (((1 + 2) * 3) / 2);", regex.ASSIGN));
               System.out.println("ASSIGN Validation (y@DEC @ ((2.0 + (4.5 * 3.2)) - (1.5 / 2));): " + regex.validate("y@DEC @ ((2.0 + (4.5 * 3.2)) - (1.5 / 2));", regex.ASSIGN));
               System.out.println("ASSIGN Validation (x@DEC @ (2.5 ^ 3.0) + 4.2;): " + regex.validate("x@DEC @ (2.5 ^ 3.0) + 4.2;", regex.ASSIGN));
               System.out.println("ASSIGN Validation (y@DEC @ ((5.5 / 2) ^ 3) + 1;): " + regex.validate("y@DEC @ ((5.5 / 2) ^ 3) + 1;", regex.ASSIGN));*/
                       // Invalid cases
               //System.out.println("ASSIGN Validation (invalid, should be false: x@INT @ 5.3;): " + regex.validate("x@INT @ 5.5 + 3;", regex.ASSIGN));
               //System.out.println("ASSIGN Validation (invalid, should be false: z@BOOL @ 1 + 0;): " + regex.validate("z@BOOL @ 1 + 0;", regex.ASSIGN));
               //System.out.println("ASSIGN Validation (invalid, should be false: z@BOOL @ 1 + 0;): " + regex.validate("z@BOOL @ 1 + 0;", regex.ASSIGN));        
               // Scope validation
               //System.out.println("SCOPE Validation (Valid scope): " + regex.validate("{ x@INT @ 5; y@DEC @ 3.14; z@BOOL @ false; }", regex.SCOPE));
               //System.out.println("SCOPE Validation (Nested scope): " + regex.validate("{ x@INT @ (3 + 2); { y@DEC @ 4.2 * 3.1; z@INT @ ((2 + 3) * (4 - 1)); } }", regex.SCOPE));
                       // Multi-line comment validation
               //System.out.println("MULTILINE_COMMENT Validation (Single line): " + regex.validate("/* This is a test comment */", regex.MULTILINE_COMMENT));
               //System.out.println("MULTILINE_COMMENT Validation (Multi-line): " + regex.validate("/* multi-line\ncomment */", regex.MULTILINE_COMMENT));
               //System.out.println("MULTILINE_COMMENT Validation (Empty comment): " + regex.validate("/**/", regex.MULTILINE_COMMENT));
               //System.out.println("MULTILINE_COMMENT Validation (Nested asterisks): " + regex.validate("/* *** Nested *** */", regex.MULTILINE_COMMENT));
               //System.out.println("MULTILINE_COMMENT Validation (Special characters inside): " + regex.validate("/* Comment with symbols !@#$%^&*() */", regex.MULTILINE_COMMENT));
          }
}