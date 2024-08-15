import processing.core.PApplet;
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
        p5.image(image, position.x, position.y);
    }

    @Override
    public void update() {
        position.add(velocity);
    }

    public void turnLeft(){
        velocity.rotate(-PApplet.PI / 4);
    }

}
