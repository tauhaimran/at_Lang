public class testInput {
    public static String lexer_test_input = 
            "// This is a single-line comment\n" +
            "\n" +
            "/* \n" +
            "   This is a multi-line comment\n" +
            "   It spans multiple lines\n" +
            "*/\n" +
            "\n" +
            "// Variable declarations and assignments\n" +
            "x@INT @ 42;\n" +
            "y@DEC @ 3.14159;\n" +
            "z@BOOL @ true;\n" +
            "myChar@CHAR @ 'A';\n" +
            "myStr@STR @ \"Hello\";\n" +
            "myVar@VAR @ myvar;\n" +
            "\n" +
            "// Arithmetic operations\n" +
            "a@INT @ 5 + 3;\n" +
            "b@DEC @ 4.5 * 2;\n" +
            "c@DEC @ 2 ^ 3 + 4;\n" +
            "d@INT @ 10 % 3 + 1;\n" +
            "e@DEC @ 5.2 / 2;\n" +
            "\n" +
            "// Complex expressions with parentheses\n" +
            "f@INT @ (5 + 3) * 2;\n" +
            "g@DEC @ ((2.0 + (4.5 * 3.2)) - (1.5 / 2);\n" +
            "h@DEC @ (2.5 ^ 3.0) + 4.2;\n" +
            "i@DEC @ ((5.5 / 2) ^ 3) + 1;\n" +
            "\n" +
            "// Invalid assignments (should throw errors or fail validation)\n" +
            "// x@INT @ 5.5 + 3; // Invalid: INT cannot hold a decimal\n" +
            "// z@BOOL @ 1 + 0;  // Invalid: BOOL cannot hold arithmetic operations\n" +
            "\n" +
            "// Scopes\n" +
            "{\n" +
            "    x@INT @ 5;\n" +
            "    y@DEC @ 3.14;\n" +
            "    z@BOOL @ false;\n" +
            "}\n" +
            "\n" +
            "// Nested scopes\n" +
            "{\n" +
            "    x@INT @ (3 + 2);\n" +
            "    {\n" +
            "        y@DEC @ 4.2 * 3.1;\n" +
            "        z@INT @ ((2 + 3) * (4 - 1));\n" +
            "    }\n" +
            "}";


}
