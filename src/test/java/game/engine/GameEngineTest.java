package game.engine;

import game.model.CellType;
import game.model.GameState;
import game.model.PlayerId;
import game.model.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameEngineTest {

    @Test
    void placementTurnGainsEnergyAndSwitchesPlayer() {
        GameEngine engine = new GameEngine();

        engine.playPlacementTurn(new Position(0, 0));

        GameState state = engine.getGameState();
        assertEquals(CellType.X, state.getCell(new Position(0, 0)));
        assertEquals(1, state.getPlayerState(PlayerId.X).getEnergy());
        assertEquals(PlayerId.O, state.getCurrentPlayer());
        assertEquals(1, state.getTotalTurnCount());
    }

    @Test
    void scoringAwardsOnePointClearsSelectedLineAndGivesPriority() {
        GameEngine engine = new GameEngine();

        engine.playPlacementTurn(new Position(0, 0));
        engine.playPlacementTurn(new Position(3, 3));
        engine.playPlacementTurn(new Position(0, 1));
        engine.playPlacementTurn(new Position(3, 2));
        engine.playPlacementTurn(new Position(0, 2));

        GameState state = engine.getGameState();
        assertEquals(1, state.getPlayerState(PlayerId.X).getScore());
        assertEquals(CellType.EMPTY, state.getCell(new Position(0, 0)));
        assertEquals(CellType.EMPTY, state.getCell(new Position(0, 1)));
        assertEquals(CellType.EMPTY, state.getCell(new Position(0, 2)));
        assertTrue(state.getPlayerState(PlayerId.O).isPriorityTurn());
    }

    @Test
    void precomputedLineCountIsTwentyFour() {
        assertEquals(24, LineDetector.allLines().size());
    }

    @Test
    void noWinnerAfterSingleScoringTurn() {
        GameEngine engine = new GameEngine();

        engine.playPlacementTurn(new Position(0, 0));
        engine.playPlacementTurn(new Position(3, 3));
        engine.playPlacementTurn(new Position(0, 1));
        engine.playPlacementTurn(new Position(3, 2));
        engine.playPlacementTurn(new Position(0, 2));

        GameState state = engine.getGameState();
        assertFalse(state.isGameOver());
    }
}
