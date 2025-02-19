import java.util.HashSet;
import java.util.Set;

public class state {
    int id;
    boolean isFinal;
    Set<transition> transitions;

    public state(int id, boolean isFinal) {
        this.id = id;
        this.isFinal = isFinal;
        this.transitions = new HashSet<>();
    }

    public void addTransition(char symbol, state nextstate) {
        transitions.add(new transition(symbol, nextstate));
    }

    public Set<state> getNextStates(char symbol) {
        Set<state> nextstates = new HashSet<>();
        for (transition transition : transitions) {
            if (transition.symbol == symbol || transition.symbol == 'ε') {
                nextstates.add(transition.nextState);
            }
        }
        return nextstates;
    }
}

