package dk.sdu.mmmi.cbse.commonAbleToShoot;


import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

public interface IAbleToShoot {
    /**
     * iterates over this interface each game-loop, if an entity should shoot, set bool
     * to true
     * @param
     */
    void shoot(GameData gameData);
}
