import java.util.*;

public class SymbolTable {
    private Map<String, Token> table;

    public SymbolTable() {
        this.table = new HashMap<>();
    }

    // Add a token to the symbol table
    public void addToken(Token token) {
        table.put(token.lexeme, token);
    }

    // Check if a token exists in the symbol table
    public boolean contains(String lexeme) {
        return table.containsKey(lexeme);
    }

    // Get a token from the symbol table
    public Token getToken(String lexeme) {
        return table.get(lexeme);
    }

    // Display the symbol table
    public void displaySymbolTable() {
        System.out.println("Symbol Table:");
        for (Map.Entry<String, Token> entry : table.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}