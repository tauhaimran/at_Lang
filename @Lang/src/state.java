import java.util.HashSet;
import java.util.Set;
// Compiler Construction Assignment #1
// 22i-???? Husain Ali Zaidi
// 22i-1239 Tauha Imran
public class state {
    int id;
    boolean isFinal;
    Set<Transition> transitions;

    public state(int id, boolean isFinal) {
        this.id = id;
        this.isFinal = isFinal;
        this.transitions = new HashSet<>();
    }

    public void addTransition(char symbol, state nextstate) {
        transitions.add(new Transition(symbol, nextstate));
    }

    public Set<state> getNextStates(char symbol) {
        Set<state> nextstates = new HashSet<>();
        for (Transition transition : transitions) {
            if (transition.symbol == symbol || transition.symbol == 'ε') {
                nextstates.add(transition.nextState);
            }
        }
        return nextstates;
    }
}

