import java.util.HashSet;
import java.util.Set;
// Compiler Construction Assignment #1
// 22i-???? Husain Ali Zaidi
// 22i-1239 Tauha Imran
public class nfa {
    Set<state> states;
    state startState;
    public int totalStates = 0;

    public nfa() {
        this.states = new HashSet<>();
    }

    public void addState(state state) {
        states.add(state);
        if (startState == null) {
            startState = state;
        }
    }

    public boolean accept(String input) {
        Set<state> currentStates = new HashSet<>();
        currentStates.add(startState);
        for (char symbol : input.toCharArray()) {
            Set<state> nextStates = new HashSet<>();
            for (state state : currentStates) {
                nextStates.addAll(state.getNextStates(symbol));
            }
            currentStates = nextStates;
        }
        for (state state : currentStates) {
            if (state.isFinal) {
                return true;
            }
        }
        return false;
    }

    public static nfa createNFAFromRegex(String regex) {
        state startState = new state(0, false);
        state finalState = new state(1, true);
        startState.addTransition('a', finalState); // This is just an example transition

        nfa nfa = new nfa();
        nfa.addState(startState);
        nfa.addState(finalState);

        // Implement the construction of the nfa based on the regex pattern
        // This part can be expanded to handle different regex patterns

        return nfa;
    }

    public static void main(String[] args) {
        // Create NFAs for each regex pattern from regex.java
        nfa intNFA = nfa.createNFAFromRegex(regex.INT);
        nfa decNFA = nfa.createNFAFromRegex(regex.DEC);
        nfa boolNFA = nfa.createNFAFromRegex(regex.BOOL);
        nfa charNFA = nfa.createNFAFromRegex(regex.CHAR);
        nfa strNFA = nfa.createNFAFromRegex(regex.STR);
        nfa varNFA = nfa.createNFAFromRegex(regex.VAR);

        // Test the NFAs with sample inputs
        System.out.println("INT nfa: " + intNFA.accept("123"));   // Should return true
        System.out.println("DEC nfa: " + decNFA.accept("12.34")); // Should return true
        System.out.println("BOOL nfa: " + boolNFA.accept("true")); // Should return true
        System.out.println("CHAR nfa: " + charNFA.accept("'a'"));  // Should return true
        System.out.println("STR nfa: " + strNFA.accept("\"hello\"")); // Should return true
        System.out.println("VAR nfa: " + varNFA.accept("abc"));    // Should return true
    }
}
