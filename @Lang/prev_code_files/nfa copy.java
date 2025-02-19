
import java.util.HashSet;
import java.util.Set;

class Transition {
    char symbol;
    State nextState;

    public Transition(char symbol, State nextState) {
        this.symbol = symbol;
        this.nextState = nextState;
    }
}

class State {
    int id;
    boolean isFinal;
    Set<Transition> transitions;

    public State(int id, boolean isFinal) {
        this.id = id;
        this.isFinal = isFinal;
        this.transitions = new HashSet<>();
    }

    public void addTransition(char symbol, State nextState) {
        transitions.add(new Transition(symbol, nextState));
    }

    public Set<State> getNextStates(char symbol) {
        Set<State> nextStates = new HashSet<>();
        for (Transition transition : transitions) {
            if (transition.symbol == symbol || transition.symbol == 'ε') {
                nextStates.add(transition.nextState);
            }
        }
        return nextStates;
    }
}

public class nfa {
    Set<State> states;
    State startState;

    public nfa() {
        this.states = new HashSet<>();
    }

    public void addState(State state) {
        states.add(state);
        if (startState == null) {
            startState = state;
        }
    }

    public boolean accept(String input) {
        Set<State> currentStates = new HashSet<>();
        currentStates.add(startState);
        for (char symbol : input.toCharArray()) {
            Set<State> nextStates = new HashSet<>();
            for (State state : currentStates) {
                nextStates.addAll(state.getNextStates(symbol));
            }
            currentStates = nextStates;
        }
        for (State state : currentStates) {
            if (state.isFinal) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        nfa mynfa = new nfa();

        // Define states
        State s0 = new State(0, false);
        State s1 = new State(1, false);
        State s2 = new State(2, true); // Final state

        // Add transitions
        s0.addTransition('a', s1);
        s1.addTransition('b', s2);

        // Add states to NFA
        mynfa.addState(s0);
        mynfa.addState(s1);
        mynfa.addState(s2);

        // Test input strings
        System.out.println(mynfa.accept("ab")); // Should return true
        System.out.println(mynfa.accept("a"));  // Should return false
    }
}


//public class nfa {
//    // Your NFA class implementation here
//    // You can use regex patterns and methods from regex.java
//
//    public static void main(String[] args) {
//        String testString = "a@INT @ 123;";
//        
//       if (regex.validate(testString, regex.ASSIGN)) {
//           System.out.println("\n\nThe string matches the assignment pattern.");
//       } else {
//           System.out.println("\n\nThe string does not match the assignment pattern.");
//       }
//    }
//}
