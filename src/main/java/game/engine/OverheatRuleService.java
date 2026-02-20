package game.engine;

import game.model.GameState;
import game.model.PlayerId;

public class OverheatRuleService {
    public void applyPreGainAdjustment(GameState state, PlayerId actor) {
        // TODO: if actor ended with 5 energy for two own turns, set actor energy to 3 before gain.
        throw new UnsupportedOperationException("TODO: implement OverheatRuleService.applyPreGainAdjustment");
    }

    public void updateTrackerAtEndOfTurn(GameState state, PlayerId actor) {
        // TODO: update consecutive-end-at-5 tracker and reset behavior.
        throw new UnsupportedOperationException("TODO: implement OverheatRuleService.updateTrackerAtEndOfTurn");
    }
}
