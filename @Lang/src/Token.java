enum TokenType {
    INT, DEC, BOOL, CHAR, STR, VAR, OPERATOR, WHITESPACE, SCOPE, MULTILINE_COMMENT, ASSIGN
}

public class Token {
    TokenType type;
    String value;

    public Token(TokenType type, String value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("Token[type=%s, value=%s]", type, value);
    }
}

