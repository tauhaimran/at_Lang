// Compiler Construction Assignment #1
// 22i-???? Husain Ali Zaidi
// 22i-1239 Tauha Imran
public class Transition {
    char symbol;
    State nextState;

    public Transition(char symbol, State nextState) {
        this.symbol = symbol;
        this.nextState = nextState;
    }

    @Override
    public String toString() {
        return "Transition[symbol=" + symbol + ", nextState=" + nextState.id + "]";
    }
}