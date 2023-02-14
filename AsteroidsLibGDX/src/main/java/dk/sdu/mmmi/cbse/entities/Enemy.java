package dk.sdu.mmmi.cbse.entities;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;

public class Enemy extends SpaceObject {

    private float maxSpeed;
    private float acceleration;
    private float deceleration;
    private Random random = new Random();
    private ArrayList<Projectile> projectiles;

    public Enemy(ArrayList<Projectile> projectiles) {
        this.projectiles = projectiles;
        x = 20;
        y = 20;

        maxSpeed = 300;
        acceleration = 200;

        deceleration = 10;
        shapex = new float[4];
        shapey = new float[4];

        radians = 3.1415f / 2;
        rotationSpeed = 6;

    }

    private void setShape() {
        shapex[0] = x + MathUtils.cos(radians) * 8;
        shapey[0] = y + MathUtils.sin(radians) * 8;

        shapex[1] = x + MathUtils.cos(radians - 4 * 3.1415f / 5) * 8;
        shapey[1] = y + MathUtils.sin(radians - 4 * 3.1145f / 5) * 8;

        shapex[2] = x + MathUtils.cos(radians + 3.1415f) * 5;
        shapey[2] = y + MathUtils.sin(radians + 3.1415f) * 5;

        shapex[3] = x + MathUtils.cos(radians + 4 * 3.1415f / 5) * 8;
        shapey[3] = y + MathUtils.sin(radians + 4 * 3.1415f / 5) * 8;
    }

    public void update(float dt) {

        double randomRotation = (random.nextDouble()-1)*2;

        radians += rotationSpeed * randomRotation * dt;

        boolean shouldAccelerate = (Math.random() * (10)) > 8;

        // accelerating
        if (shouldAccelerate) {
            dx += MathUtils.cos(radians) * acceleration * dt;
            dy += MathUtils.sin(radians) * acceleration * dt;
        }

        boolean shouldFire = (Math.random() * (100)) >= 95;

        if (shouldFire) {
            projectiles.add(new Projectile(x, y, radians));
        }

        // // deceleration
        float vec = (float) Math.sqrt(dx * dx + dy * dy);
        if (vec > 0) {
            dx -= (dx / vec) * deceleration * dt;
            dy -= (dy / vec) * deceleration * dt;
        }
        if (vec > maxSpeed) {
            dx = (dx / vec) * maxSpeed;
            dy = (dy / vec) * maxSpeed;
        }

        // // set position
        x += dx * dt;
        y += dy * dt;

        // set shape
        setShape();

        // screen wrap
        wrap();

    }

    public void draw(ShapeRenderer sr) {

        sr.setColor(255, 99, 71, 1);

        sr.begin(ShapeType.Line);

        for (int i = 0, j = shapex.length - 1; i < shapex.length; j = i++) {

            sr.line(shapex[i], shapey[i], shapex[j], shapey[j]);

        }

        sr.end();

    }

}