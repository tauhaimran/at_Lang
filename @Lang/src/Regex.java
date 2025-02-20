import java.util.regex.*;
// Compiler Construction Assignment #1
// 22i-???? Husain Ali Zaidi
// 22i-1239 Tauha Imran

public class Regex { //regular expression class
    // Data Types
    public static final String INT = "[+-]?[0-9]+";  
    public static final String DEC = "[+-]?[0-9]+\\.[0-9]+";  
    public static final String BOOL = "(true|false|1|0)";
    public static final String CHAR = "'.'";
    public static final String STR = "\"([^\"\\\\]|\\\\.)*\"";  
    public static final String VAR = "[a-z]+";  
    //public static final String DTYPE = "(INT|DEC|BOOL|CHAR|STR)";  

    // Atomic Expressions (Includes Parentheses)
    public static final String ATOMIC_EXPR = "\\(*(" + INT + "|" + DEC + "|" + VAR + ")\\)*";  

    // Operators with Precedence
    public static final String EXP = ATOMIC_EXPR + "(\\s*\\^\\s*" + ATOMIC_EXPR + ")*";
    public static final String MUL_DIV_MOD = EXP + "(\\s*[*/%]\\s*" + EXP + ")*";
    public static final String ADD_SUB = MUL_DIV_MOD + "(\\s*[+-]\\s*" + MUL_DIV_MOD + ")*";

    // Assignment with Type Constraints
    public static final String ASSIGN_REGEX =
        "^(" + VAR + "@INT\\s*@\\s*" + INT + "|" +
              VAR + "@DEC\\s*@\\s*" + DEC + "|" +
              VAR + "@BOOL\\s*@\\s*" + BOOL + "|" +
              VAR + "@CHAR\\s*@\\s*" + CHAR + "|" +
              VAR + "@STR\\s*@\\s*" + STR + "|" +
              VAR + "@INT\\s*@\\s*" + ADD_SUB + "|" +
              VAR + "@DEC\\s*@\\s*" + ADD_SUB + ")" +
        "(,\\s*" + VAR + "@(INT|DEC)\\s*@\\s*" + ADD_SUB + ")*\\s*;$";

    // Patterns
    public static final Pattern ASSIGN = Pattern.compile(ASSIGN_REGEX);
    public static final Pattern SCOPE = Pattern.compile("^\\{\\s*(" + ASSIGN_REGEX + "|.*\\n?)*\\s*}$", Pattern.MULTILINE);
    public static final Pattern MULTILINE_COMMENT = Pattern.compile("/\\*[\\s\\S]*?\\*/");

    // Validation method
    public static boolean validate(String input, Pattern pattern) {
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    
//   public static void main(String[] args) {
//             // Integer test
//             System.out.println("INT Validation (42): " + validate("42", Pattern.compile(INT)));
//   }
 //   public static void main(String[] args) {
 //       // Integer test
 //       System.out.println("INT Validation (42): " + validate("42", Pattern.compile(INT)));
//
 //       // Decimal test
 //       System.out.println("DEC Validation (3.14159): " + validate("3.14159", Pattern.compile(DEC)));
//
 //       // Boolean test
 //       System.out.println("BOOL Validation (true): " + validate("true", Pattern.compile(BOOL)));
//
 //       // Character test
 //       System.out.println("CHAR Validation ('A'): " + validate("'A'", Pattern.compile(CHAR)));
//
 //       // String test
 //       System.out.println("STR Validation (\"Hello\"): " + validate("\"Hello\"", Pattern.compile(STR)));
//
 //       // Variable test
 //       System.out.println("VAR Validation (myvar): " + validate("myvar", Pattern.compile(VAR)));
//
 //       // Assignment test cases
 //       System.out.println("ASSIGN Validation (x@INT @ 5 + 3;): " + validate("x@INT @ 5 + 3;", ASSIGN));
 //       System.out.println("ASSIGN Validation (y@DEC @ 4.5 * 2;): " + validate("y@DEC @ 4.5 * 2;", ASSIGN));
 //       System.out.println("ASSIGN Validation (z@DEC @ 2 ^ 3 + 4;): " + validate("z@DEC @ 2 ^ 3 + 4;", ASSIGN));
 //       System.out.println("ASSIGN Validation (a@INT @ 10 % 3 + 1, b@DEC @ 5.2 / 2;): " + validate("a@INT @ 10 % 3 + 1, b@DEC @ 5.2 / 2;", ASSIGN));
 //       System.out.println("ASSIGN Validation (x@INT @ (5 + 3) * 2;): " + validate("x@INT @ (5 + 3) * 2;", ASSIGN));
//
 //       // Additional test cases
 //       System.out.println("ASSIGN Validation (x@INT @ (((1 + 2) * 3) / 2);): " + validate("x@INT @ (((1 + 2) * 3) / 2);", ASSIGN));
 //       System.out.println("ASSIGN Validation (y@DEC @ ((2.0 + (4.5 * 3.2)) - (1.5 / 2));): " + validate("y@DEC @ ((2.0 + (4.5 * 3.2)) - (1.5 / 2));", ASSIGN));
 //       System.out.println("ASSIGN Validation (x@DEC @ (2.5 ^ 3.0) + 4.2;): " + validate("x@DEC @ (2.5 ^ 3.0) + 4.2;", ASSIGN));
 //       System.out.println("ASSIGN Validation (y@DEC @ ((5.5 / 2) ^ 3) + 1;): " + validate("y@DEC @ ((5.5 / 2) ^ 3) + 1;", ASSIGN));
//
 //       // Invalid cases
 //       System.out.println("ASSIGN Validation (invalid, should be false: x@INT @ 5.3;): " + validate("x@INT @ 5.5 + 3;", ASSIGN));
 //       System.out.println("ASSIGN Validation (invalid, should be false: z@BOOL @ 1 + 0;): " + validate("z@BOOL @ 1 + 0;", ASSIGN));
//
 //       // Scope validation
 //       System.out.println("SCOPE Validation (Valid scope): " + validate("{ x@INT @ 5; y@DEC @ 3.14; z@BOOL @ false; }", SCOPE));
 //       System.out.println("SCOPE Validation (Nested scope): " + validate("{ x@INT @ (3 + 2); { y@DEC @ 4.2 * 3.1; z@INT @ ((2 + 3) * (4 - 1)); } }", SCOPE));
//
 //       // Multi-line comment validation
 //       System.out.println("MULTILINE_COMMENT Validation (Single line): " + validate("/* This is a test comment */", MULTILINE_COMMENT));
 //       System.out.println("MULTILINE_COMMENT Validation (Multi-line): " + validate("/* multi-line\ncomment */", MULTILINE_COMMENT));
 //       System.out.println("MULTILINE_COMMENT Validation (Empty comment): " + validate("/**/", MULTILINE_COMMENT));
 //       System.out.println("MULTILINE_COMMENT Validation (Nested asterisks): " + validate("/* *** Nested *** */", MULTILINE_COMMENT));
 //       System.out.println("MULTILINE_COMMENT Validation (Special characters inside): " + validate("/* Comment with symbols !@#$%^&*() */", MULTILINE_COMMENT));
  //  }
}
