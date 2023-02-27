package dk.sdu.mmmi.cbse.projectilesystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

public class ProjectileControlSystem implements IEntityProcessingService {
    @Override
    public void process(GameData gameData, World world) {
        for(Entity entity : world.getEntities()){
            if(entity.getbShoot() && entity.getPart(PositionPart.class)!=null){
                PositionPart positionPart = entity.getPart(PositionPart.class);
                Projectile projectile = new Projectile();
                PositionPart projectilePositionPart = new PositionPart(positionPart.getX(), positionPart.getY(), positionPart.getRadians());

                projectile.add(projectilePositionPart);
                projectile.add(new MovingPart(0,100000,300,0));

                world.addEntity(projectile);
                entity.setbShoot(false);
            }
        }

        for (Entity projectile : world.getEntities(Projectile.class)) {
            PositionPart positionPart = projectile.getPart(PositionPart.class);
            MovingPart movingPart = projectile.getPart(MovingPart.class);
            //bullets are given high acceleration but set max speed, so they instantly
            //have high speed. setUp just makes it move
            movingPart.setUp(true);


            movingPart.process(gameData, projectile);
            positionPart.process(gameData, projectile);

            updateShape(projectile);
        }
    }

    private void updateShape(Entity entity) {
        float[] shapex = entity.getShapeX();
        float[] shapey = entity.getShapeY();
        PositionPart positionPart = entity.getPart(PositionPart.class);
        float x = positionPart.getX();
        float y = positionPart.getY();
        float radians = positionPart.getRadians();

        shapex[0] = (float) (x + Math.cos(radians) * 5);
        shapey[0] = (float) (y + Math.sin(radians) * 5);

        shapex[1] = (float) (x + Math.cos(radians - 4 * 3.1415f / 5) * 5);
        shapey[1] = (float) (y + Math.sin(radians - 4 * 3.1145f / 5) * 5);

        shapex[2] = (float) (x + Math.cos(radians + 3.1415f) * 5);
        shapey[2] = (float) (y + Math.sin(radians + 3.1415f) * 5);

        shapex[3] = (float) (x + Math.cos(radians + 4 * 3.1415f / 5) * 5);
        shapey[3] = (float) (y + Math.sin(radians + 4 * 3.1415f / 5) * 5);

        entity.setShapeX(shapex);
        entity.setShapeY(shapey);
    }

}
