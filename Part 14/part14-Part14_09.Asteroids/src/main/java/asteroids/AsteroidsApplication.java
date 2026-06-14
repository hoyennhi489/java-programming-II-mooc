package asteroids;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AsteroidsApplication extends Application {

    public static int WIDTH = 300;
    public static int HEIGHT = 200;

    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();

        Ship ship = new Ship(WIDTH / 2, HEIGHT / 2);
        pane.getChildren().add(ship.getCharacter());

        ArrayList<Asteroid> asteroids = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            Asteroid asteroid = new Asteroid(random.nextInt(WIDTH), random.nextInt(HEIGHT));
            asteroids.add(asteroid);
            pane.getChildren().add(asteroid.getCharacter());
        }

        ArrayList<Projectile> projectiles = new ArrayList<>();

        Text pointsText = new Text(10, 20, "Points: 0");
        pane.getChildren().add(pointsText);

        HashMap<KeyCode, Boolean> pressedKeys = new HashMap<>();

        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        scene.setOnKeyPressed(event -> pressedKeys.put(event.getCode(), true));
        scene.setOnKeyReleased(event -> pressedKeys.put(event.getCode(), false));

        final int[] points = {0};

        new AnimationTimer() {
            @Override
            public void handle(long now) {

                if (pressedKeys.getOrDefault(KeyCode.LEFT, false)) {
                    ship.turnLeft();
                }

                if (pressedKeys.getOrDefault(KeyCode.RIGHT, false)) {
                    ship.turnRight();
                }

                if (pressedKeys.getOrDefault(KeyCode.UP, false)) {
                    ship.accelerate();
                }

                if (pressedKeys.getOrDefault(KeyCode.SPACE, false)) {
                    Projectile projectile = new Projectile(
                            (int) ship.getCharacter().getTranslateX(),
                            (int) ship.getCharacter().getTranslateY()
                    );

                    projectile.getCharacter().setRotate(ship.getCharacter().getRotate());
                    projectile.accelerate();
                    projectile.setMovement(projectile.getMovement().normalize().multiply(3));

                    projectiles.add(projectile);
                    pane.getChildren().add(projectile.getCharacter());

                    pressedKeys.put(KeyCode.SPACE, false);
                }

                ship.move();

                asteroids.forEach(asteroid -> asteroid.move());
                projectiles.forEach(projectile -> projectile.move());

                asteroids.forEach(asteroid -> {
                    if (ship.collide(asteroid)) {
                        stop();
                    }
                });

                ArrayList<Projectile> projectilesToRemove = new ArrayList<>();
                ArrayList<Asteroid> asteroidsToRemove = new ArrayList<>();

                for (Projectile projectile : projectiles) {
                    for (Asteroid asteroid : asteroids) {
                        if (projectile.collide(asteroid)) {
                            projectilesToRemove.add(projectile);
                            asteroidsToRemove.add(asteroid);
                            points[0]++;
                            pointsText.setText("Points: " + points[0]);
                        }
                    }
                }

                projectilesToRemove.forEach(projectile -> {
                    pane.getChildren().remove(projectile.getCharacter());
                    projectiles.remove(projectile);
                });

                asteroidsToRemove.forEach(asteroid -> {
                    pane.getChildren().remove(asteroid.getCharacter());
                    asteroids.remove(asteroid);
                });

                if (Math.random() < 0.005) {
                    Asteroid asteroid = new Asteroid(random.nextInt(WIDTH), random.nextInt(HEIGHT));
                    asteroids.add(asteroid);
                    pane.getChildren().add(asteroid.getCharacter());
                }
            }
        }.start();

        stage.setScene(scene);
        stage.show();
    }

    public static int partsCompleted() {
        return 4;
    }

    public static void main(String[] args) {
        launch(args);
    }

    public abstract class GameObject {

        private Polygon character;
        private Point2D movement;

        public GameObject(Polygon polygon, int x, int y) {
            this.character = polygon;
            this.character.setTranslateX(x);
            this.character.setTranslateY(y);
            this.movement = new Point2D(0, 0);
        }

        public Polygon getCharacter() {
            return this.character;
        }

        public Point2D getMovement() {
            return this.movement;
        }

        public void setMovement(Point2D movement) {
            this.movement = movement;
        }

        public void turnLeft() {
            this.character.setRotate(this.character.getRotate() - 5);
        }

        public void turnRight() {
            this.character.setRotate(this.character.getRotate() + 5);
        }

        public void move() {
            this.character.setTranslateX(this.character.getTranslateX() + this.movement.getX());
            this.character.setTranslateY(this.character.getTranslateY() + this.movement.getY());

            if (this.character.getTranslateX() < 0) {
                this.character.setTranslateX(WIDTH);
            }

            if (this.character.getTranslateX() > WIDTH) {
                this.character.setTranslateX(0);
            }

            if (this.character.getTranslateY() < 0) {
                this.character.setTranslateY(HEIGHT);
            }

            if (this.character.getTranslateY() > HEIGHT) {
                this.character.setTranslateY(0);
            }
        }

        public void accelerate() {
            double changeX = Math.cos(Math.toRadians(this.character.getRotate()));
            double changeY = Math.sin(Math.toRadians(this.character.getRotate()));

            changeX *= 0.05;
            changeY *= 0.05;

            this.movement = this.movement.add(changeX, changeY);
        }

        public boolean collide(GameObject other) {
            return this.character.getBoundsInParent().intersects(
                    other.getCharacter().getBoundsInParent()
            );
        }
    }

    public class Ship extends GameObject {

        public Ship(int x, int y) {
            super(new Polygon(-5, -5, 10, 0, -5, 5), x, y);
        }
    }

    public class Asteroid extends GameObject {

        public Asteroid(int x, int y) {
            super(new Polygon(-10, -10, 5, -10, 10, 0, 5, 10, -10, 10), x, y);

            Random random = new Random();

            super.getCharacter().setRotate(random.nextInt(360));
            super.setMovement(new Point2D(
                    random.nextDouble() - 0.5,
                    random.nextDouble() - 0.5
            ));
        }
    }

    public class Projectile extends GameObject {

        public Projectile(int x, int y) {
            super(new Polygon(-2, -2, 2, -2, 2, 2, -2, 2), x, y);
            super.getCharacter().setFill(Color.RED);
        }
    }
}