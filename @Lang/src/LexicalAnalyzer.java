import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexicalAnalyzer {

    // Method to read the .atlang file and return its content as a String
    private String readFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                content.append(scanner.nextLine()).append("\n");
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filePath);
            e.printStackTrace();
        }
        return content.toString();
    }

    // Method to tokenize the input string
    /*private List<Token> tokenize(String input) {
        List<Token> tokens = new ArrayList<>();
        StringBuilder currentToken = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            // Logic to identify tokens goes here
            // Example: Check for whitespace, operators, numbers, etc.
            // For now, we'll just split by whitespace (you'll replace this with your logic)
            if (Character.isWhitespace(currentChar)) {
                if (currentToken.length() > 0) {
                    tokens.add(new Token(TokenType.UNKNOWN, currentToken.toString())); // Replace UNKNOWN with your logic
                    currentToken.setLength(0); // Reset the current token
                }
            } else {
                currentToken.append(currentChar);
            }
        }

        // Add the last token if it exists
        if (currentToken.length() > 0) {
            tokens.add(new Token(TokenType.UNKNOWN, currentToken.toString())); // Replace UNKNOWN with your logic
        }

        return tokens;
    }*/

    public static List<String> tokenize(String input) {
        List<String> tokens = new ArrayList<>();
        
        // Define regex patterns for major symbols
        String pattern = "[a-zA-Z_][a-zA-Z0-9_]*|@|\\+|\\-|\\*|\\/|\\^|%|=|;|\\{|\\}|\\(|\\)|'[^']*'|\"[^\"]*\"|\\d+(\\.\\d+)?|true|false";

        // Create the pattern and matcher
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(input);
        
        // Find all matches
        while (m.find()) {
            tokens.add(m.group());
        }

        return tokens;
    }

    // Main method to run the lexer
    public static void main(String[] args) {
        LexicalAnalyzer lexer = new LexicalAnalyzer();
        //String filePath = "input.txt"; // Path to your .atlang file

        // Step 1: Read the file
       // String input = lexer.readFile(filePath);
        //System.out.println("Input:\n" + input);

        // Step 2: Tokenize the input
        //List<Token> tokens = lexer.tokenize(testInput.lexer_test_input);
        List<String> tokens = lexer.tokenize(testInput.lexer_test_input);

        // Step 3: Print the tokens
        /*System.out.println("\nTokens:");
        for (Token token : tokens) {
            System.out.println(token);
        }*/
        System.out.println("\nTokens:");
        for (String token : tokens) {
            System.out.println(token);
        }
    }
}