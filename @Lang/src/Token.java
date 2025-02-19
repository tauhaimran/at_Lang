enum TokenType {
    CHARACTER, CONCAT, UNION, KLEENE_STAR, OPEN_PAREN, CLOSE_PAREN
}

public class Token {
    TokenType type;
    char value;

    public Token(TokenType type, char value) {
        this.type = type;
        this.value = value;
    }
}
