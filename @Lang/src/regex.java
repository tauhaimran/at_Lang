import java.util.regex.*;

public class regex {
    // Regular Expressions for Data Types
    private static final String INT = "[+-]?[0-9]+";
    private static final String DEC = "[+-]?[0-9]+\\.[0-9]{1,5}";
    private static final String BOOL = "(true|false|1|0)";
    private static final String CHAR = ".";
    private static final String STR = "\"([^\"\\\\]|\\\\.)*\"";  
    private static final String VAR = "[a-z]+";
    private static final String DTYPE = "(INT|DEC|BOOL|CHAR|STR)";

    // Operator Precedence
    private static final String EXP = "(" + INT + "|" + DEC + ")\\s*\\^\\s*(" + INT + "|" + DEC + ")";
    private static final String MUL = "(" + EXP + "|" + INT + "|" + DEC + ")\\s*\\*\\s*(" + EXP + "|" + INT + "|" + DEC + ")";
    private static final String DIV = "(" + EXP + "|" + INT + "|" + DEC + ")\\s*/\\s*(" + EXP + "|" + INT + "|" + DEC + ")";
    private static final String MOD = "(" + EXP + "|" + INT + "|" + DEC + ")\\s*%\\s*(" + EXP + "|" + INT + "|" + DEC + ")";
    private static final String ADD = "(" + MUL + "|" + DIV + "|" + MOD + "|" + EXP + "|" + INT + "|" + DEC + ")\\s*\\+\\s*(" + MUL + "|" + DIV + "|" + MOD + "|" + EXP + "|" + INT + "|" + DEC + ")";
    private static final String SUB = "(" + MUL + "|" + DIV + "|" + MOD + "|" + EXP + "|" + INT + "|" + DEC + ")\\s*-\\s*(" + MUL + "|" + DIV + "|" + MOD + "|" + EXP + "|" + INT + "|" + DEC + ")";

    // Updated Assignment with Correct Precedence
    private static final String ASSIGN_REGEX = "^(" + VAR + "@" + DTYPE + "\\s*@\\s*(" + EXP + "|" + MUL + "|" + DIV + "|" + MOD + "|" + ADD + "|" + SUB + "))" +
            "(,\\s*" + VAR + "@" + DTYPE + "\\s*@\\s*(" + EXP + "|" + MUL + "|" + DIV + "|" + MOD + "|" + ADD + "|" + SUB + "))*\\s*;$";

    private static final Pattern ASSIGN = Pattern.compile(ASSIGN_REGEX);

    // Placeholder for scope (defined later)
    private static Pattern SCOPE;

    // Multi-line comment pattern
    private static final Pattern MULTILINE_COMMENT = Pattern.compile("^\\/\\*([\\s\\S]*?)\\*\\/$");

    static {
        SCOPE = Pattern.compile("^\\{\\s*(" + ASSIGN_REGEX + "|" + ".*" + ")*\\s*}$");
    }

    // Validation method
    private static boolean validate(String input, Pattern pattern) {
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
    // Example validations
    public static void main(String[] args) {
        // Integer test
        System.out.println("INT Validation (42): " + validate("42", Pattern.compile(INT)));

        // Decimal test
        System.out.println("DEC Validation (3.14159): " + validate("3.14159", Pattern.compile(DEC)));

        // Boolean test
        System.out.println("BOOL Validation (true): " + validate("true", Pattern.compile(BOOL)));

        // Character test
        System.out.println("CHAR Validation (A): " + validate("A", Pattern.compile(CHAR)));

        // String test
        System.out.println("STR Validation (\"Hello\"): " + validate("\"Hello\"", Pattern.compile(STR)));

        // Variable test
        System.out.println("VAR Validation (myvar): " + validate("myvar", Pattern.compile(VAR)));

        // Assignment test cases
        System.out.println("ASSIGN Validation (x@INT @ 5 + 3;): " + validate("x@INT @ 5 + 3;", ASSIGN));
        System.out.println("ASSIGN Validation (y@DEC @ 4.5 * 2;): " + validate("y@DEC @ 4.5 * 2;", ASSIGN));
        System.out.println("ASSIGN Validation (z@DEC @ 2 ^ 3 + 4;): " + validate("z@DEC @ 2 ^ 3 + 4;", ASSIGN));
        System.out.println("ASSIGN Validation (a@INT @ 10 % 3 + 1, b@DEC @ 5.2 / 2;): " + validate("a@INT @ 10 % 3 + 1, b@DEC @ 5.2 / 2;", ASSIGN));

        // Scope test cases
        System.out.println("SCOPE Validation ({ x@INT @ 5; y@DEC @ 3.14; }): " + validate("{ x@INT @ 5; y@DEC @ 3.14; }", SCOPE));

        // Multi-line comment test
        System.out.println("MULTILINE_COMMENT Validation (/* comment */): " + validate("/* This is a test comment */", MULTILINE_COMMENT));
    }
}
