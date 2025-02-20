import java.util.*;


public class Lexer {
    private DFA dfa;
    private String input;
    private int currentPosition;
    private int lineNumber;
    private List<Token> tokens;
    public SymbolTable symbolTable;
    private ErrorHandler errorHandler;

    public Lexer(DFA dfa, String input) {
        this.dfa = dfa;
        this.input = input;
        this.currentPosition = 0;
        this.lineNumber = 1;
        this.tokens = new ArrayList<>();
        this.symbolTable = new SymbolTable();
        this.errorHandler = new ErrorHandler();
    }

    // Tokenize the input source code
    public void tokenize() {
        while (currentPosition < input.length()) {
            char currentChar = input.charAt(currentPosition);

            // Skip whitespace and newlines
            if (Character.isWhitespace(currentChar)) {
                if (currentChar == '\n') {
                    lineNumber++;
                }
                currentPosition++;
                continue;
            }

            // Find the longest matching token
            Token token = getNextToken();
            if (token != null) {
                tokens.add(token);
                symbolTable.addToken(token); // Add token to the symbol table
            } else {
                errorHandler.reportError("Invalid token at line " + lineNumber);
                currentPosition++;
            }
        }
    }

    // Get the next token from the input
    private Token getNextToken() {
        int startPosition = currentPosition;
        DFAState currentState = dfa.startState;

        while (currentPosition < input.length()) {
            char currentChar = input.charAt(currentPosition);
            DFAState nextState = currentState.transitions.get(currentChar);

            if (nextState == null) {
                break; // No transition for the current character
            }

            currentState = nextState;
            currentPosition++;
        }

        if (currentState.isFinal()) {
            String lexeme = input.substring(startPosition, currentPosition);
            return new Token(lexeme, currentState.toString(), lineNumber);
        }

        return null; // No valid token found
    }

    // Get the list of tokens
    public List<Token> getTokens() {
        return tokens;
    }

    // Get the number of tokens
    public int getNumberOfTokens() {
        return tokens.size();
    }

    // Display the tokens
    public void displayTokens() {
        System.out.println("Tokens:");
        for (Token token : tokens) {
            System.out.println(token);
        }
    }
}