package dk.sdu.mmmi.cbse.gamestates;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import dk.sdu.mmmi.cbse.entities.Enemy;
import dk.sdu.mmmi.cbse.entities.Player;
import dk.sdu.mmmi.cbse.managers.GameKeys;
import dk.sdu.mmmi.cbse.managers.GameStateManager;
import dk.sdu.mmmi.cbse.entities.Projectile;

public class PlayState extends GameState {

	private ShapeRenderer sr;

	private Player player;
	private Enemy enemy;

	private ArrayList<Projectile> projectiles;

	public PlayState(GameStateManager gsm) {
		super(gsm);
	}

	public void init() {

		sr = new ShapeRenderer();

		projectiles = new ArrayList<>();

		player = new Player();
		enemy = new Enemy(projectiles);

	}

	public void update(float dt) {

		handleInput();

		player.update(dt);
		enemy.update(dt);

		// Update projectiles
		for (int i = 0; i < projectiles.size(); i++) {
			Projectile proj = projectiles.get(i);
			proj.update(dt);
			if (proj.shouldClear()) {
				projectiles.remove(i);
			}
		}

	}

	public void draw() {
		player.draw(sr);
		enemy.draw(sr);
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).draw(sr);
		}
	}

	public void handleInput() {
		player.setLeft(GameKeys.isDown(GameKeys.LEFT));
		player.setRight(GameKeys.isDown(GameKeys.RIGHT));
		player.setUp(GameKeys.isDown(GameKeys.UP));
	}

	public void dispose() {
	}

}