import java.util.*;

public class State {
    int id;
    boolean isFinal;
    Map<Character, Set<State>> transitions;

    public State(int id, boolean isFinal) {
        this.id = id;
        this.isFinal = isFinal;
        this.transitions = new HashMap<>();
    }

    public void addTransition(char symbol, State nextState) {
        transitions.computeIfAbsent(symbol, k -> new HashSet<>()).add(nextState);
    }

    public Set<State> getNextStates(char symbol) {
        return transitions.getOrDefault(symbol, new HashSet<>());
    }

    @Override
    public String toString() {
        return "State[id=" + id + ", isFinal=" + isFinal + "]";
    }
}