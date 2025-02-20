import java.util.*;

public class DFAState {
    Set<state> nfaStates; // Set of NFA states this DFA state represents
    Map<Character, DFAState> transitions; // DFA transition table
    int id; // Unique ID for this DFA state

    public DFAState(Set<state> nfaStates, int id) {
        this.nfaStates = nfaStates;
        this.transitions = new HashMap<>();
        this.id = id;
    }

    // Add a transition to another DFA state
    public void addTransition(char symbol, DFAState nextState) {
        transitions.put(symbol, nextState);
    }

    // Check if this DFA state is final (if any of its NFA states are final)
    public boolean isFinal() {
        for (state s : nfaStates) {
            if (s.isFinal) {
                return true;
            }
        }
        return false;
    }

    // Get a readable representation of this DFA state
    @Override
    public String toString() {
        return "S" + id;
    }

    // Equals method to compare DFA states based on their NFA states
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        DFAState dfaState = (DFAState) obj;
        return nfaStates.equals(dfaState.nfaStates);
    }

    // HashCode method for hashing DFA states
    @Override
    public int hashCode() {
        return nfaStates.hashCode();
    }
}
