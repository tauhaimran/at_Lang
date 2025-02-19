import java.util.List;

public class LexicalAnalyzerTest {
    public static void main(String[] args) {
        LexicalAnalyzer analyzer = new LexicalAnalyzer();

        // Sample source code for testing
        String sourceCode = 
                            "x@INT @ 123;\n";

        // Analyze the source code
        List<Token> tokens = analyzer.analyze(sourceCode);
        // Print the tokens
        for (Token token : tokens) {
            System.out.println(token);
        }
    
         // Print the symbol table
         SymbolTable symbolTable = analyzer.getSymbolTable();
         System.out.println("Symbol Table:");
         System.out.println(symbolTable);
    
}
}