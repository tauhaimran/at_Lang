public class Token {
    String lexeme;
    String type;
    int lineNumber;

    public Token(String lexeme, String type, int lineNumber) {
        this.lexeme = lexeme;
        this.type = type;
        this.lineNumber = lineNumber;
    }

    @Override
    public String toString() {
        return "Token [lexeme=" + lexeme + ", type=" + type + ", line=" + lineNumber + "]";
    }
}
