package dk.sdu.mmmi.cbse.collisioncontrollersystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;
import dk.sdu.mmmi.cbse.projectilesystem.Projectile;

public class CollisionController implements IPostEntityProcessingService {

    @Override
    public void process(GameData gameData, World world) {
        for (Entity projectile : world.getEntities(Projectile.class)) {
            PositionPart projectilePositionPart = projectile.getPart(PositionPart.class);
            if(projectilePositionPart.getY()> gameData.getDisplayHeight() - 10
                    || projectilePositionPart.getX() > gameData.getDisplayWidth() -10){
                world.removeEntity(projectile);
            }
        }
    }
}