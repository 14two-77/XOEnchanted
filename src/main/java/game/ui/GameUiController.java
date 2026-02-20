package game.ui;

import game.engine.GameEngine;
import game.model.GameState;
import game.model.Position;

import java.util.Objects;

public class GameUiController {
    private final GameEngine engine;
    private SkillMode mode;

    public GameUiController() {
        this.engine = new GameEngine();
        this.mode = SkillMode.PLACE;
    }

    public GameState state() {
        return engine.getGameState();
    }

    public SkillMode mode() {
        return mode;
    }

    public void setMode(SkillMode mode) {
        this.mode = Objects.requireNonNull(mode, "mode cannot be null");
    }

    public void resetGame() {
        // TODO: keep selected mode while resetting if preferred by UX.
        throw new UnsupportedOperationException("TODO: implement GameUiController.resetGame");
    }

    public void onCellClicked(int row, int col) {
        if (mode == SkillMode.PLACE) {
            engine.playPlacementTurn(new Position(row, col));
            return;
        }

        // TODO: implement selection flow for each skill mode.
        throw new UnsupportedOperationException("TODO: implement skill mode click flow");
    }
}
