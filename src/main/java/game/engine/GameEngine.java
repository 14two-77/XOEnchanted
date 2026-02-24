package game.engine;

import game.model.GameResult;
import game.model.GameState;

import java.util.List;
import java.util.Optional;

/**
 * Core interface for the game engine that manages game state and rules.
 * Provides methods for starting games, executing actions, and checking game status.
 */
public interface GameEngine {

    /**
     * Start a new game and return the initial game state.
     *
     * @return the initial GameState
     */
    GameState startGame();

    /**
     * Execute an action and return the new game state.
     *
     * @param currentState the current game state
     * @param action the action to execute
     * @return the new game state after executing the action
     * @throws IllegalActionException if the action is invalid
     */
    GameState executeAction(GameState currentState, Action action) throws IllegalActionException;

    /**
     * Get all valid actions for the current state.
     *
     * @param state the current game state
     * @return list of all valid actions
     */
    List<Action> getValidActions(GameState state);

    /**
     * Check if the game is over and return the result if so.
     *
     * @param state the current game state
     * @return Optional containing GameResult if game is over, empty otherwise
     */
    Optional<GameResult> checkGameOver(GameState state);
}
