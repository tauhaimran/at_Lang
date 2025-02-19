enum TokenType {
    INT, DEC, BOOL, CHAR, STR, VAR, OPERATOR, WHITESPACE, SCOPE, MULTILINE_COMMENT, ASSIGN
}

//enum TokenType {
//    NUMBER, IDENTIFIER, OPERATOR, WHITESPACE, CHARACTER, CONCAT, UNION, KLEENE_STAR, OPEN_PAREN, CLOSE_PAREN
//}
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

