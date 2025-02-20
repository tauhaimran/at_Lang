public class App {
    public static void main(String[] args) {
        NFA_builder builder = new NFA_builder();
        String inputText = "x@INT @ 5;\n{\n y@DEC @ 3.14;\n}";
        builder.buildCombinedNFA(inputText);

        // Display the combined NFA
        builder.displayCombinedNFA();

        // Convert the NFA to a DFA
        DFA dfa = builder.convertToDFA();

        // Display the DFA
        dfa.displayTransitionTable();

        // Create the Lexer
        Lexer lexer = new Lexer(dfa, inputText);
        lexer.tokenize();

        // Display the tokens
        lexer.displayTokens();

        // Display the number of tokens
        System.out.println("Number of tokens: " + lexer.getNumberOfTokens());

        // Display the symbol table
        lexer.symbolTable.displaySymbolTable();
    }
}
