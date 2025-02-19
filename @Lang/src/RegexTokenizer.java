import java.util.ArrayList;
import java.util.List;

public class RegexTokenizer {
    public static List<Token> tokenize(String regex) {
        List<Token> tokens = new ArrayList<>();
        for (char c : regex.toCharArray()) {
            switch (c) {
                case '*':
                    tokens.add(new Token(TokenType.KLEENE_STAR, String.valueOf(c)));
                    break;
                case '|':
                    tokens.add(new Token(TokenType.UNION, String.valueOf(c)));
                    break;
                case '(':
                    tokens.add(new Token(TokenType.OPEN_PAREN, String.valueOf(c)));
                    break;
                case ')':
                    tokens.add(new Token(TokenType.CLOSE_PAREN, String.valueOf(c)));
                    break;
                default:
                    tokens.add(new Token(TokenType.CHARACTER, String.valueOf(c)));
                    break;
            }
        }
        return tokens;
    }
}
