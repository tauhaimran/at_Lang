class transition {
    char symbol;
    state nextState;

    public transition(char symbol, state nextState) {
        this.symbol = symbol;
        this.nextState = nextState;
    }
}
