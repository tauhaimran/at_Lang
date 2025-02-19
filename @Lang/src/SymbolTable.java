import java.util.HashMap;
import java.util.Map;

public class SymbolTable {
    private final Map<String, String> symbols = new HashMap<>();

    void add(String lexeme, String type) {
        symbols.put(lexeme, type);
    }

    String get(String lexeme) {
        return symbols.get(lexeme);
    }

    @Override
    public String toString() {
        return symbols.toString();
    }
}

