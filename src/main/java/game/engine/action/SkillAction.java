package game.engine.action;

import game.model.GameState;

public interface SkillAction {
    boolean validate(GameState state);

    void apply(GameState state);
}
