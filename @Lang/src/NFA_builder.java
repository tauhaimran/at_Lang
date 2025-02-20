import java.util.*;
import java.util.regex.*;

public class NFA_builder {
    private NFA combinedNFA;

    public NFA_builder() {
        this.combinedNFA = new NFA();
    }

    // Thompson's construction for basic Regex components
    private NFA buildBasicNFA(char symbol, String regexType) {
        NFA basicNFA = new NFA();
        state start = basicNFA.createstate(false, regexType);
        state end = basicNFA.createstate(true, regexType);
        basicNFA.addTransition(start, symbol, end);
        basicNFA.startstate = start;
        return basicNFA;
    }

    private NFA buildConcatenation(NFA NFA1, NFA NFA2, String regexType) {
        NFA concatenatedNFA = new NFA();
        concatenatedNFA.states.addAll(NFA1.states);
        concatenatedNFA.states.addAll(NFA2.states);

        // Reassign state IDs starting from 0
        concatenatedNFA.reassignStateIDs();

        // Connect the final states of NFA1 to the start state of NFA2
        for (state state : NFA1.states) {
            if (state.isFinal) {
                state.isFinal = false;
                concatenatedNFA.addTransition(state, '\0', NFA2.startstate);
            }
        }

        concatenatedNFA.startstate = NFA1.startstate;
        return concatenatedNFA;
    }

    private NFA buildUnion(NFA NFA1, NFA NFA2, String regexType) {
        NFA unionNFA = new NFA();
        unionNFA.states.addAll(NFA1.states);
        unionNFA.states.addAll(NFA2.states);

        // Reassign state IDs starting from 0
        unionNFA.reassignStateIDs();

        state start = unionNFA.createstate(false, regexType);
        state end = unionNFA.createstate(true, regexType);

        unionNFA.addTransition(start, '\0', NFA1.startstate);
        unionNFA.addTransition(start, '\0', NFA2.startstate);

        for (state state : NFA1.states) {
            if (state.isFinal) {
                state.isFinal = false;
                unionNFA.addTransition(state, '\0', end);
            }
        }

        for (state state : NFA2.states) {
            if (state.isFinal) {
                state.isFinal = false;
                unionNFA.addTransition(state, '\0', end);
            }
        }

        unionNFA.startstate = start;
        return unionNFA;
    }

    private NFA buildKleeneStar(NFA NFA, String regexType) {
        NFA kleeneNFA = new NFA();
        kleeneNFA.states.addAll(NFA.states);

        // Reassign state IDs starting from 0
        kleeneNFA.reassignStateIDs();

        state start = kleeneNFA.createstate(false, regexType);
        state end = kleeneNFA.createstate(true, regexType);

        kleeneNFA.addTransition(start, '\0', NFA.startstate);
        kleeneNFA.addTransition(start, '\0', end);

        for (state state : NFA.states) {
            if (state.isFinal) {
                state.isFinal = false;
                kleeneNFA.addTransition(state, '\0', NFA.startstate);
                kleeneNFA.addTransition(state, '\0', end);
            }
        }

        kleeneNFA.startstate = start;
        return kleeneNFA;
    }

    // Build NFA for a given Regex pattern
    private NFA buildNFAForPattern(String pattern, String regexType) {
        NFA resultNFA = null;
        for (char c : pattern.toCharArray()) {
            NFA basicNFA = buildBasicNFA(c, regexType);
            if (resultNFA == null) {
                resultNFA = basicNFA;
            } else {
                resultNFA = buildConcatenation(resultNFA, basicNFA, regexType);
            }
        }
        return resultNFA;
    }

    // Method to extract regex patterns from the text
    public static List<String> extractRegexPatterns(String text) {
        List<String> patterns = new ArrayList<>();

        // Extract INT patterns
        Matcher intMatcher = Pattern.compile(Regex.INT).matcher(text);
        while (intMatcher.find()) {
            patterns.add("INT: " + intMatcher.group());
        }

        // Extract DEC patterns
        Matcher decMatcher = Pattern.compile(Regex.DEC).matcher(text);
        while (decMatcher.find()) {
            patterns.add("DEC: " + decMatcher.group());
        }

        // Extract BOOL patterns
        Matcher boolMatcher = Pattern.compile(Regex.BOOL).matcher(text);
        while (boolMatcher.find()) {
            patterns.add("BOOL: " + boolMatcher.group());
        }

        // Extract CHAR patterns
        Matcher charMatcher = Pattern.compile(Regex.CHAR).matcher(text);
        while (charMatcher.find()) {
            patterns.add("CHAR: " + charMatcher.group());
        }

        // Extract STR patterns
        Matcher strMatcher = Pattern.compile(Regex.STR).matcher(text);
        while (strMatcher.find()) {
            patterns.add("STR: " + strMatcher.group());
        }

        // Extract VAR patterns
        Matcher varMatcher = Pattern.compile(Regex.VAR).matcher(text);
        while (varMatcher.find()) {
            patterns.add("VAR: " + varMatcher.group());
        }

        // Extract Atomic Expressions (including parentheses)
        Matcher atomicExprMatcher = Pattern.compile(Regex.ATOMIC_EXPR).matcher(text);
        while (atomicExprMatcher.find()) {
            patterns.add("ATOMIC_EXPR: " + atomicExprMatcher.group());
        }

        // Extract Exponentiation Expressions (^)
        Matcher expMatcher = Pattern.compile(Regex.EXP).matcher(text);
        while (expMatcher.find()) {
            patterns.add("EXP: " + expMatcher.group());
        }

        // Extract Multiplication, Division, and Modulus Expressions
        Matcher mulDivModMatcher = Pattern.compile(Regex.MUL_DIV_MOD).matcher(text);
        while (mulDivModMatcher.find()) {
            patterns.add("MUL_DIV_MOD: " + mulDivModMatcher.group());
        }

        // Extract Addition and Subtraction Expressions
        Matcher addSubMatcher = Pattern.compile(Regex.ADD_SUB).matcher(text);
        while (addSubMatcher.find()) {
            patterns.add("ADD_SUB: " + addSubMatcher.group());
        }

        // Extract ASSIGN patterns
        Matcher assignMatcher = Regex.ASSIGN.matcher(text);
        while (assignMatcher.find()) {
            patterns.add("ASSIGN: " + assignMatcher.group());
        }

        // Extract SCOPE patterns
        Matcher scopeMatcher = Regex.SCOPE.matcher(text);
        while (scopeMatcher.find()) {
            patterns.add("SCOPE: " + scopeMatcher.group());
        }

        // Extract MULTILINE_COMMENT patterns
        Matcher commentMatcher = Regex.MULTILINE_COMMENT.matcher(text);
        while (commentMatcher.find()) {
            patterns.add("MULTILINE_COMMENT: " + commentMatcher.group());
        }

        return patterns;
    }

    // Recognize valid Regex patterns and build combined NFA
    public void buildCombinedNFA(String text) {
        List<String> patterns = extractRegexPatterns(text);

        for (String pattern : patterns) {
            String[] parts = pattern.split(": ", 2);
            String regexType = parts[0];
            String patternText = parts[1];
            NFA patternNFA = buildNFAForPattern(patternText, regexType);
            if (combinedNFA.startstate == null) {
                combinedNFA = patternNFA;
            } else {
                combinedNFA = buildUnion(combinedNFA, patternNFA, regexType);
            }
        }
    }

    // Display the combined NFA
    public void displayCombinedNFA() {
        if (combinedNFA.startstate == null) {
            System.out.println("No valid Regex patterns found.");
            return;
        }
        combinedNFA.displaystateInfo();
        combinedNFA.displayTransitionTable();
    }

    public DFA convertToDFA() {
        return DFA.convertNFAtoDFA(combinedNFA);
    }
}