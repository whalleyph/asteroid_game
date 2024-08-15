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
        this.velocity = PVector.random2D().mult(p5.random(0.2f, 3));
        this.image = image;
    }

    @Override
    public void collisionWithOtherMeteors() {
    // not yet implemented
    }

    @Override
    public void display() {
        p5.image(image, position.x, position.y);
    }

    @Override
    public void update() {
        position.add(velocity);
        velocity.rotate(p5.random(-0.03f, 0.03f));
        bounce();
    }

    private void bounce() {
        if (position.x > p5.width || position.x < 0) {
            velocity.x = -velocity.x;
        }

        if (position.y > p5.height || position.y < 0) {
            velocity.y = -velocity.y;
        }
    }
}
