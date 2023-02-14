package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

public interface IGamePluginService {
    /**
     * starts the game
     * @param gameData contains data about events and the game window
     * @param world contains data about the entities in the game
     */
    void start(GameData gameData, World world);

    /**
     * stops the game
     * @param gameData contains data about events and the game window
     * @param world contains data about the entities in the game
     */
    void stop(GameData gameData, World world);
}
