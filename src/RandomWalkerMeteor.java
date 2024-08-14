import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class RandomWalkerMeteor implements Meteor {
    private PApplet p5;
    private PVector position;
    private PVector velocity;
    private PImage image;

    RandomWalkerMeteor(PApplet p5, PImage image) {
        this.p5 = p5;
        this.position = new PVector(p5.random(0, p5.width), p5.random(0, p5.height));
        this.velocity = new PVector(0, 1);
        this.image = image;
    }

    @Override
    public void collisionWithOtherMeteors() {

    }

    @Override
    public void display() {
        p5.image(image, position.x, position.y);
    }

    @Override
    public void update() {

    }
}
