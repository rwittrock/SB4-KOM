package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

public interface IEntityProcessingService {

    /**
     *Processes gameData and world.
     * @param gameData contains data the game window and deltaTime
     * @param world contains data about the entities in the game
     */
    void process(GameData gameData, World world);


}
