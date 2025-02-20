import java.util.*;

public class state {
    int id;
    boolean isFinal;
    String regexType;
    Map<Character, Set<state>> transitions;

    public state(int id, boolean isFinal, String type) {
        this.id = id;
        this.isFinal = isFinal;
        this.transitions = new HashMap<>();
        this.regexType = type; // Default
    }
    public Set<Character> getTransitionSymbolsFromState() {
        Set<Character> symbols = new HashSet<>();
        for (Map.Entry<Character, Set<state>> entry : transitions.entrySet()) {
            if (entry.getKey() != '\0') { // Ignore epsilon transitions
                symbols.add(entry.getKey());
            }
        }
        return symbols;
    }
    

    public void addTransition(char symbol, state nextstate) {
        transitions.computeIfAbsent(symbol, k -> new HashSet<>()).add(nextstate);
    }

    public Set<state> getNextstates(char symbol) {
        return transitions.getOrDefault(symbol, new HashSet<>());
    }

    @Override
    public String toString() {
        return "state[id=" + id + ", isFinal=" + isFinal + "]";
    }
}