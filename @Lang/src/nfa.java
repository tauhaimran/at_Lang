import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

// Compiler Construction Assignment #1
// 22i-???? Husain Ali Zaidi
// 22i-1239 Tauha Imran

import java.util.*;

public class nfa {
    Set<State> states;
    State startState;
    int stateCounter;

    public nfa() {
        this.states = new HashSet<>();
        this.stateCounter = 0;
    }

    public State createState(boolean isFinal) {
        State state = new State(stateCounter++, isFinal);
        states.add(state);
        return state;
    }

    public void addTransition(State from, char symbol, State to) {
        from.addTransition(symbol, to);
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

    public void displayStateInfo() {
        System.out.println("Total number of states: " + states.size());
        System.out.println("Unique states:");
        for (State state : states) {
            System.out.println(state);
        }
    }

    public void displayTransitionTable() {
        System.out.println("Transition State Table:");
        for (State state : states) {
            for (Map.Entry<Character, Set<State>> entry : state.transitions.entrySet()) {
                char symbol = entry.getKey();
                for (State nextState : entry.getValue()) {
                    System.out.println("State " + state.id + " --" + symbol + "--> State " + nextState.id);
                }
            }
        }
    }
}