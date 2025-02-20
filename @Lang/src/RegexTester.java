import java.util.regex.*;

public class RegexTester {


    public static void main(String[] args) {
    
               // Integer test
               System.out.println("INT Validation (42): " + Regex.validate("42", Pattern.compile(Regex.INT)));
                       // Decimal test
               System.out.println("DEC Validation (3.14159): " + Regex.validate("3.14159", Pattern.compile(Regex.DEC)));
                       // Boolean test
               System.out.println("BOOL Validation (true): " + Regex.validate("true", Pattern.compile(Regex.BOOL)));
                       // Character test
               System.out.println("CHAR Validation ('A'): " + Regex.validate("'A'", Pattern.compile(Regex.CHAR)));
                       // String test
               System.out.println("STR Validation (\"Hello\"): " + Regex.validate("\"Hello\"", Pattern.compile(Regex.STR)));
                       // Variable test
               System.out.println("VAR Validation (myvar): " + Regex.validate("myvar", Pattern.compile(Regex.VAR)));
                       // Assignment test cases
               System.out.println("ASSIGN Validation (x@INT @ 5 + 3;): " + Regex.validate("x@INT @ 5 + 3;", Regex.ASSIGN));
               System.out.println("ASSIGN Validation (y@DEC @ 4.5 * 2;): " + Regex.validate("y@DEC @ 4.5 * 2;", Regex.ASSIGN));
               System.out.println("ASSIGN Validation (z@DEC @ 2 ^ 3 + 4;): " + Regex.validate("z@DEC @ 2 ^ 3 + 4;", Regex.ASSIGN));
               System.out.println("ASSIGN Validation (a@INT @ 10 % 3 + 1, b@DEC @ 5.2 / 2;): " + Regex.validate("a@INT @ 10 % 3 + 1, b@DEC @ 5.2 / 2;", Regex.ASSIGN));
               System.out.println("ASSIGN Validation (x@INT @ (5 + 3) * 2;): " + Regex.validate("x@INT @ (5 + 3) * 2;", Regex.ASSIGN));
                       // Additional test cases
               System.out.println("ASSIGN Validation (x@INT @ (((1 + 2) * 3) / 2);): " + Regex.validate("x@INT @ (((1 + 2) * 3) / 2);", Regex.ASSIGN));
               System.out.println("ASSIGN Validation (y@DEC @ ((2.0 + (4.5 * 3.2)) - (1.5 / 2));): " + Regex.validate("y@DEC @ ((2.0 + (4.5 * 3.2)) - (1.5 / 2));", Regex.ASSIGN));
               System.out.println("ASSIGN Validation (x@DEC @ (2.5 ^ 3.0) + 4.2;): " + Regex.validate("x@DEC @ (2.5 ^ 3.0) + 4.2;", Regex.ASSIGN));
               System.out.println("ASSIGN Validation (y@DEC @ ((5.5 / 2) ^ 3) + 1;): " + Regex.validate("y@DEC @ ((5.5 / 2) ^ 3) + 1;", Regex.ASSIGN));
                       // Invalid cases
               System.out.println("ASSIGN Validation (invalid, should be false: x@INT @ 5.3;): " + Regex.validate("x@INT @ 5.5 + 3;", Regex.ASSIGN));
               System.out.println("ASSIGN Validation (invalid, should be false: z@BOOL @ 1 + 0;): " + Regex.validate("z@BOOL @ 1 + 0;", Regex.ASSIGN));
               System.out.println("ASSIGN Validation (invalid, should be false: z@BOOL @ 1 + 0;): " + Regex.validate("z@BOOL @ 1 + 0;", Regex.ASSIGN));        
               // Scope validation
               System.out.println("SCOPE Validation (Valid scope): " + Regex.validate("{ x@INT @ 5; y@DEC @ 3.14; z@BOOL @ false; }", Regex.SCOPE));
               System.out.println("SCOPE Validation (Nested scope): " + Regex.validate("{ x@INT @ (3 + 2); { y@DEC @ 4.2 * 3.1; z@INT @ ((2 + 3) * (4 - 1)); } }", Regex.SCOPE));
                       // Multi-line comment validation
               System.out.println("MULTILINE_COMMENT Validation (Single line): " + Regex.validate("/* This is a test comment */", Regex.MULTILINE_COMMENT));
               System.out.println("MULTILINE_COMMENT Validation (Multi-line): " + Regex.validate("/* multi-line\ncomment */", Regex.MULTILINE_COMMENT));
               System.out.println("MULTILINE_COMMENT Validation (Empty comment): " + Regex.validate("/**/", Regex.MULTILINE_COMMENT));
               System.out.println("MULTILINE_COMMENT Validation (Nested asterisks): " + Regex.validate("/* *** Nested *** */", Regex.MULTILINE_COMMENT));
               System.out.println("MULTILINE_COMMENT Validation (Special characters inside): " + Regex.validate("/* Comment with symbols !@#$%^&*() */", Regex.MULTILINE_COMMENT));
          }
}