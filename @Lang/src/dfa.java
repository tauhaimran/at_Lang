import java.util.*;

public class dfa {
    Set<State> states;
    State startState;

    public dfa(nfa nfa) {
        this.states = new HashSet<>();
        this.startState = nfa.startState;
        // Conversion from NFA to DFA is not implemented here for simplicity
    }

    public boolean accept(String input) {
        State currentState = startState;
        for (char symbol : input.toCharArray()) {
            Set<State> nextStates = currentState.getNextStates(symbol);
            if (nextStates.isEmpty()) {
                return false;
            }
            currentState = nextStates.iterator().next(); // Simplified for DFA
        }
        return currentState.isFinal;
    }
}