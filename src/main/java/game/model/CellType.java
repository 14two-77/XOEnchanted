package game.model;

public enum CellType {
    EMPTY,
    X,
    O,
    SEALED;

    public static CellType fromPlayer(PlayerId playerId) {
        return playerId == PlayerId.X ? X : O;
    }
}
