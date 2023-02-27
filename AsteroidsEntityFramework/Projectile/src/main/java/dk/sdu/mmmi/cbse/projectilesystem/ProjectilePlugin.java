package dk.sdu.mmmi.cbse.projectilesystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

public class ProjectilePlugin implements IGamePluginService {

    private Entity projectile;

    public ProjectilePlugin() {
    }

    @Override
    public void start(GameData gameData, World world) {
        // Add entities to the world
    }



    @Override
    public void stop(GameData gameData, World world) {
        // Remove entities
        world.removeEntity(projectile);
    }
}
