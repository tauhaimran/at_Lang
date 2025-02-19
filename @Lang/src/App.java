public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

           // Create an NFA for the regex "[a-z]+"
           nfa nfa = new nfa();
           State start = nfa.createState(false);
           State end = nfa.createState(true);
           nfa.startState = start;
   
           for (char c = 'a'; c <= 'z'; c++) {
               nfa.addTransition(start, c, end);
               nfa.addTransition(end, c, end);
           }
   
        nfa.displayStateInfo();
           nfa.displayTransitionTable();
   
           // Test the NFA
           System.out.println("NFA accepts 'abc': " + nfa.accept("abc")); // Should return true
           System.out.println("NFA accepts '123': " + nfa.accept("123")); // Should return false
   
       // Convert NFA to DFA (simplified)
       dfa dfa = new dfa(nfa);

       // Test the DFA
       System.out.println("DFA accepts 'abc': " + dfa.accept("abc")); // Should return true
       System.out.println("DFA accepts '123': " + dfa.accept("123")); // Should return false
        }
}
