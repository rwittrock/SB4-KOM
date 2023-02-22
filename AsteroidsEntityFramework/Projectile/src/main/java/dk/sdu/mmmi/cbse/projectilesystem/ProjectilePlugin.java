package dk.sdu.mmmi.cbse.projectilesystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

public class ProjectilePlugin implements IGamePluginService {

    private Entity projectile;

    private String sourceID;

    public ProjectilePlugin(String sourceID) {
        this.sourceID = sourceID;
    }

    @Override
    public void start(GameData gameData, World world) {
        // Add entities to the world
        projectile = createProjectile(gameData, world);
        world.addEntity(projectile);
    }

    private Entity createProjectile(GameData gameData, World world) {

        float deacceleration = 10;
        float acceleration = 200;
        float maxSpeed = 300;
        float rotationSpeed = 5;
        float x = world.getEntity(sourceID).getPositionPart().getX();
        float y = world.getEntity(sourceID).getPositionPart().getY();
        float radians = world.getEntity(sourceID).getPositionPart().getRadians();

        Entity projectile = new Projectile();
        projectile.add(new MovingPart(deacceleration, acceleration, maxSpeed, rotationSpeed));
        projectile.add(new PositionPart(x, y, radians));

        return projectile;
    }

    @Override
    public void stop(GameData gameData, World world) {
        // Remove entities
        world.removeEntity(projectile);
    }
}
