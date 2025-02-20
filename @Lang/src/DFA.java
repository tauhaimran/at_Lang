import java.util.*;

public class DFA {
    Set<DFAState> states;
    DFAState startState;
    Map<DFAState, Map<Character, DFAState>> transitions;

    public DFA() {
        this.states = new HashSet<>();
        this.transitions = new HashMap<>();
    }

    public static DFA convertNFAtoDFA(NFA nfa) {
        DFA dfa = new DFA();

        // Compute the epsilon closure of the NFA's start state
        Set<state> startEpsilonClosure = epsilonClosure(nfa, Collections.singleton(nfa.startstate));
        DFAState startDFAState = new DFAState(startEpsilonClosure, 0);

        dfa.states.add(startDFAState);
        dfa.startState = startDFAState;
        dfa.transitions.put(startDFAState, new HashMap<>());

        Queue<DFAState> queue = new LinkedList<>();
        queue.add(startDFAState);

        Map<Set<state>, DFAState> stateMapping = new HashMap<>();
        stateMapping.put(startEpsilonClosure, startDFAState);

        while (!queue.isEmpty()) {
            DFAState currentDFAState = queue.poll();

            // Collect all transition symbols from the current NFA states
            Set<Character> symbols = new HashSet<>();
            for (state nfaState : currentDFAState.nfaStates) {
                symbols.addAll(nfaState.getTransitionSymbolsFromState());
            }

            for (char symbol : symbols) {
                if (symbol == '\0') continue; // Skip epsilon transitions

                Set<state> nextNFAStates = new HashSet<>();
                for (state nfaState : currentDFAState.nfaStates) {
                    nextNFAStates.addAll(nfaState.getNextstates(symbol));
                }

                Set<state> nextEpsilonClosure = epsilonClosure(nfa, nextNFAStates);
                if (nextEpsilonClosure.isEmpty()) continue;

                DFAState nextDFAState = stateMapping.get(nextEpsilonClosure);
                if (nextDFAState == null) {
                    nextDFAState = new DFAState(nextEpsilonClosure, dfa.states.size());
                    dfa.states.add(nextDFAState);
                    queue.add(nextDFAState);
                    stateMapping.put(nextEpsilonClosure, nextDFAState);
                    dfa.transitions.put(nextDFAState, new HashMap<>());
                }

                dfa.transitions.get(currentDFAState).put(symbol, nextDFAState);
            }
        }
        return dfa;
    }

    private static Set<state> epsilonClosure(NFA nfa, Set<state> states) {
        Set<state> closure = new HashSet<>(states);
        Stack<state> stack = new Stack<>();
        stack.addAll(states);

        while (!stack.isEmpty()) {
            state currentState = stack.pop();
            Set<state> epsilonTransitions = currentState.getNextstates('\0');
            for (state nextState : epsilonTransitions) {
                if (!closure.contains(nextState)) {
                    closure.add(nextState);
                    stack.push(nextState);
                }
            }
        }

        return closure;
    }

    public void displayTransitionTable() {
        System.out.println("\nDFA Transition Table:");
        System.out.println("---------------------------------");
        System.out.printf("| %-10s | %-10s | %-10s |\n", "State", "Symbol", "Next State");
        System.out.println("---------------------------------");

        for (Map.Entry<DFAState, Map<Character, DFAState>> entry : transitions.entrySet()) {
            DFAState fromState = entry.getKey();
            for (Map.Entry<Character, DFAState> transition : entry.getValue().entrySet()) {
                char symbol = transition.getKey();
                DFAState toState = transition.getValue();
                System.out.printf("| %-10d | %-10s | %-10d |\n", fromState.id, symbol, toState.id);
            }
        }

        System.out.println("---------------------------------");

        System.out.println("\nDFA States:");
        for (DFAState state : states) {
            System.out.println("State ID: " + state.id + " | Final: " + state.isFinal());
        }
    }
}
