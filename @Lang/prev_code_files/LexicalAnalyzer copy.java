import java.util.*;
import java.util.regex.*;

class LexicalAnalyzer {
    private static final String INT = "[+-]?[0-9]+";
    private static final String DEC = "[+-]?[0-9]+\\.[0-9]+";
    private static final String BOOL = "(true|false|1|0)";
    private static final String CHAR = "'.'";
    private static final String STR = "\"([^\"\\\\]|\\\\.)*\"";
    private static final String VAR = "[a-z]+";
    private static final String OPERATOR = "[+\\-*/%=]";
    private static final String WHITESPACE = "\\s+";
    private static final String MULTILINE_COMMENT = "/\\*[\\s\\S]*?\\*/";
    private static final String SCOPE = "\\{[^}]*\\}";
    private static final String ASSIGN = VAR + "@(INT|DEC|BOOL|CHAR|STR)\\s*@\\s*" + "(?:" + INT + "|" + DEC + "|" + BOOL + "|" + CHAR + "|" + STR + "|" + "\\(|\\)|" + OPERATOR + "|" + WHITESPACE + ")+" + ";";

    private static final Pattern TOKEN_PATTERN = Pattern.compile(
        "(" + INT + ")|" +
        "(" + DEC + ")|" +
        "(" + BOOL + ")|" +
        "(" + CHAR + ")|" +
        "(" + STR + ")|" +
        "(" + VAR + ")|" +
        "(" + OPERATOR + ")|" +
        "(" + WHITESPACE + ")|" +
        "(" + MULTILINE_COMMENT + ")|" +
        "(" + SCOPE + ")|" +
        "(" + ASSIGN + ")"
    );

    private final SymbolTable symbolTable = new SymbolTable();

    public List<Token> analyze(String sourceCode) {
        List<Token> tokens = new ArrayList<>();
        Matcher matcher = TOKEN_PATTERN.matcher(sourceCode);

        while (matcher.find()) {
            if (matcher.group(1) != null) {
                tokens.add(new Token(TokenType.INT, matcher.group(1)));
            } else if (matcher.group(2) != null) {
                tokens.add(new Token(TokenType.DEC, matcher.group(2)));
            } else if (matcher.group(3) != null) {
                tokens.add(new Token(TokenType.BOOL, matcher.group(3)));
            } else if (matcher.group(4) != null) {
                tokens.add(new Token(TokenType.CHAR, matcher.group(4)));
            } else if (matcher.group(5) != null) {
                tokens.add(new Token(TokenType.STR, matcher.group(5)));
            } else if (matcher.group(6) != null) {
                tokens.add(new Token(TokenType.VAR, matcher.group(6)));
                symbolTable.add(matcher.group(6), "VAR");
            } else if (matcher.group(7) != null) {
                tokens.add(new Token(TokenType.OPERATOR, matcher.group(7)));
            } else if (matcher.group(8) != null) {
                tokens.add(new Token(TokenType.WHITESPACE, matcher.group(8)));
            } else if (matcher.group(9) != null) {
                tokens.add(new Token(TokenType.MULTILINE_COMMENT, matcher.group(9)));
            } else if (matcher.group(10) != null) {
                tokens.add(new Token(TokenType.SCOPE, matcher.group(10)));
            } else if (matcher.group(11) != null) {
                tokens.add(new Token(TokenType.ASSIGN, matcher.group(11)));
            }
        }

        return tokens;
    }


    public SymbolTable getSymbolTable() {
        return symbolTable;
    }
}
