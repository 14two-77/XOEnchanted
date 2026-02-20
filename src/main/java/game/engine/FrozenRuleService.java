package game.engine;

import game.model.GameState;

public class FrozenRuleService {
    public void updateAtEndOfTurn(GameState state) {
        // TODO: track owner-turn inactivity counters for each piece.
        // TODO: apply one-owner-turn frozen window when inactivity reaches threshold.
        throw new UnsupportedOperationException("TODO: implement FrozenRuleService.updateAtEndOfTurn");
    }

    public boolean isFrozenAt(GameState state, int row, int col) {
        // TODO: return frozen status from piece metadata.
        throw new UnsupportedOperationException("TODO: implement FrozenRuleService.isFrozenAt");
    }
}
