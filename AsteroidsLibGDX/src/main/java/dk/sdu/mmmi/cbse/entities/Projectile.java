package dk.sdu.mmmi.cbse.entities;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;

public class Projectile extends SpaceObject {
    private float lifeTime;
    private float age;
    private boolean clear;

    public Projectile(float x, float y, float radians) {
        this.x = x;
        this.y = y;
        this.radians = radians;

        float speed = 350;
        dx = MathUtils.cos(radians) * speed;
        dy = MathUtils.sin(radians) * speed;

        width = height = 2;

        age = 0;
        lifeTime = 1;
    }

    public boolean shouldClear() {
        return clear;
    }

    public void update(float dt) {
        x += dx * dt;
        y += dy * dt;

        wrap();

        age += dt;
        if (age > lifeTime) {
            clear = true;
        }

    }

    public void draw(ShapeRenderer sr) {
        sr.setColor(1, 1, 1, 1);

        sr.begin(ShapeType.Filled);

        sr.ellipse(x, y, 3, 3);

        sr.end();
    }
}