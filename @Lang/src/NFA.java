// Compiler Construction Assignment #1
// 22i-???? Husain Ali Zaidi
// 22i-1239 Tauha Imran

import java.util.*;
import java.util.Map.Entry;

public class NFA {
    Set<state> states;
    state startstate;
    int stateCounter;

    public NFA() {
        this.states = new HashSet<>();
        this.stateCounter = 0;
    }
    

    public state createstate(boolean isFinal, String type) {
        state state = new state(this.stateCounter++, isFinal, type);
        states.add(state);
        return state;
    }
    public void reassignStateIDs() {
        // Step 1: Create a new ID mapping for all states
        Map<Integer, state> oldToNewStates = new HashMap<>();
        List<state> newStates = new ArrayList<>();
        int newID = 0;
    
        for (state s : this.states) {
            state newState = new state(newID, s.isFinal, s.regexType);
            oldToNewStates.put(s.id, newState);
            newStates.add(newState);
            newID++;
        }
    
        // Step 2: Update transitions to reference the new states
        for (state oldState : this.states) {
            state newState = oldToNewStates.get(oldState.id);
            for (Map.Entry<Character, Set<state>> entry : oldState.transitions.entrySet()) {
                Set<state> newTransitionSet = new HashSet<>();
                for (state targetState : entry.getValue()) {
                    if (!oldToNewStates.containsKey(targetState.id)) {
                        System.err.println("⚠️ Missing mapping for state: " + targetState.id);
                        continue;
                    }
                    newTransitionSet.add(oldToNewStates.get(targetState.id));
                }
                newState.transitions.put(entry.getKey(), newTransitionSet);
            }
        }
    
        // Step 3: Replace old states with new states
        this.states.clear();
        this.states.addAll(newStates);
    
        // Step 4: Update start state reference
        if (this.startstate != null && oldToNewStates.containsKey(this.startstate.id)) {
            this.startstate = oldToNewStates.get(this.startstate.id);
        } /*else {
            System.err.println("⚠️ Start state mapping missing!");
        }*/
    }
    
    

    public void addTransition(state from, char symbol, state to) {
        from.addTransition(symbol, to);
    }

    public boolean accept(String input) {
        Set<state> currentstates = new HashSet<>();
        currentstates.add(startstate);

        for (char symbol : input.toCharArray()) {
            Set<state> nextstates = new HashSet<>();
            for (state state : currentstates) {
                nextstates.addAll(state.getNextstates(symbol));
            }
            currentstates = nextstates;
        }

        for (state state : currentstates) {
            if (state.isFinal) {
                return true;
            }
        }
        return false;
    }

    public void displaystateInfo() {
        System.out.println("NFA State Information:");
        for (state s : states) {
            System.out.println("State ID: " + s.id + 
                            " | Final: " + s.isFinal + 
                            " | Regex Type: " + (s.regexType != null ? s.regexType : "UNKNOWN"));
        }
        System.out.println();
    }

    public void displayTransitionTable() {
        System.out.println("NFA Transition Table:");
        for (state s : states) {
            for (Entry<Character, Set<state>> entry : s.transitions.entrySet()) {
                char symbol = entry.getKey();
                String symbolStr = (symbol == '\0') ? "ε" : Character.toString(symbol);  // Display ε for epsilon
                for (state nextState : entry.getValue()) {
                    System.out.println("State " + s.id + " --[" + symbolStr + "]--> State " + nextState.id);
                }
            }
        }
    }

}