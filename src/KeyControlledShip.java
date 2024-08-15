import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PVector;

public class KeyControlledShip implements SpaceShip{
    private PApplet p5;
    private PVector position;
    private PVector velocity;
    private PImage image;

    public KeyControlledShip(PApplet p5){
        this.p5 = p5;
        this.position = new PVector(p5.width/2, p5.height/2);
        this.velocity = new PVector(0, 1);
        this.image = p5.loadImage("images/playerShip1_blue.png");
    }

    @Override
    public void collisionWithMeteor() {

    }

    @Override
    public void fireLaser() {

    }

    @Override
    public void display() {
        p5.push();
        p5.imageMode(PConstants.CENTER);
        p5.translate(position.x, position.y);
        p5.rotate(velocity.heading());
        p5.rotate(PConstants.PI /2);
        p5.scale(0.3f);
        p5.image(image, 0, 0);
        p5.pop();
    }

    @Override
    public void update() {
        position.add(velocity);
        velocity.mult(0.99f);
        manageWallCollision();
    }

    private void manageWallCollision() {
        if (position.x > p5.width) {
            position.x = 0;
        }
        if (position.x < 0) {
            position.x = p5.width;
        }
        if (position.y > p5.height) {
            position.y = 0;
        }
        if (position.y < 0) {
            position.y = p5.height;
        }
    }

    public void turnLeft(){
        velocity.rotate(-PConstants.PI / 45);
    }

    public void turnRight(){
        velocity.rotate(PConstants.PI / 45);
    }

    @Override
    public void thrust() {
        velocity.setMag(velocity.mag() + 0.1f);
    }


}
