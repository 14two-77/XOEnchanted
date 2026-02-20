package game.model;

public enum PlayerId {
    X,
    O;

    public PlayerId opponent() {
        return this == X ? O : X;
    }
}
