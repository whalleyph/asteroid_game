import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class KeyControlledShip implements SpaceShip{
    private PApplet p5;
    private PVector position;
    private PVector velocity;
    private PImage image;

    public KeyControlledShip(PApplet p5, PVector position, PVector velocity, PImage image){
        this.p5 = p5;
        this.position = position;
        this.velocity = velocity;
        this.image = image;
    }

    @Override
    public void collisionWithMeteor() {

    }

    @Override
    public void fireLaser() {

    }

    @Override
    public void display() {

    }

    @Override
    public void update() {

    }
}
