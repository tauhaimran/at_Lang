import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
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

    public void displayStateInfo() {
        System.out.println("Total number of states: " + states.size());
        System.out.println("Unique states:");
        for (state state : states) {
            System.out.println("State ID: " + state.id + ", Is Final: " + state.isFinal);
        }
    }

    public void displayTransitionTable() {
        System.out.println("Transition State Table:");
        for (state state : states) {
            for (Transition transition : state.transitions) {
                System.out.println("State " + state.id + " --" + transition.symbol + "--> State " + transition.nextState.id);
            }
        }
    }

    public static nfa createNFAFromRegex(String regex) {
        List<Token> tokens = RegexTokenizer.tokenize(regex);
        Stack<nfa> nfaStack = new Stack<>();

        for (Token token : tokens) {
            switch (token.type) {
                case CHARACTER:
                    nfaStack.push(createNFAForCharacter(token.value));
                    break;
                case CONCAT:
                    nfa nfa2 = nfaStack.pop();
                    nfa nfa1 = nfaStack.pop();
                    nfaStack.push(concat(nfa1, nfa2));
                    break;
                case UNION:
                    nfa nfaB = nfaStack.pop();
                    nfa nfaA = nfaStack.pop();
                    nfaStack.push(union(nfaA, nfaB));
                    break;
                case KLEENE_STAR:
                    nfa nfa = nfaStack.pop();
                    nfaStack.push(kleeneStar(nfa));
                    break;
                // Handle other cases as needed
            }
        }

        return nfaStack.pop();
    }

    private static nfa createNFAForCharacter(char c) {
        state startState = new state(0, false);
        state finalState = new state(1, true);
        startState.addTransition(c, finalState);

        nfa nfa = new nfa();
        nfa.addState(startState);
        nfa.addState(finalState);

        return nfa;
    }

    private static nfa concat(nfa nfa1, nfa nfa2) {
        // Concatenate nfa1 and nfa2
        for (state finalState : nfa1.states) {
            if (finalState.isFinal) {
                finalState.isFinal = false;
                for (state startState : nfa2.states) {
                    nfa1.states.add(startState);
                }
            }
        }
        return nfa1;
    }

    private static nfa union(nfa nfaA, nfa nfaB) {
        // Union of nfaA and nfaB
        nfa newNFA = new nfa();
        state newStartState = new state(0, false);
        newStartState.addTransition('ε', nfaA.startState);
        newStartState.addTransition('ε', nfaB.startState);

        newNFA.addState(newStartState);
        newNFA.states.addAll(nfaA.states);
        newNFA.states.addAll(nfaB.states);

        return newNFA;
    }

    private static nfa kleeneStar(nfa nfa) {
        // Kleene star of nfa
        nfa newNFA = new nfa();
        state newStartState = new state(0, false);
        state newFinalState = new state(nfa.states.size() + 1, true);

        newStartState.addTransition('ε', nfa.startState);
        newStartState.addTransition('ε', newFinalState);

        for (state finalState : nfa.states) {
            if (finalState.isFinal) {
                finalState.addTransition('ε', nfa.startState);
                finalState.addTransition('ε', newFinalState);
                finalState.isFinal = false;
            }
        }

        newNFA.addState(newStartState);
        newNFA.states.addAll(nfa.states);
        newNFA.addState(newFinalState);

        return newNFA;
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

        intNFA.displayStateInfo();
        intNFA.displayTransitionTable();
    }
}
