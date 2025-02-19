// Compiler Construction Assignment #1
// 22i-???? Husain Ali Zaidi
// 22i-1239 Tauha Imran
class Transition {
    char symbol;
    state nextState;

    public Transition(char symbol, state nextState) {
        this.symbol = symbol;
        this.nextState = nextState;
    }
}
