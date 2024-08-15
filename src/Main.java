import processing.core.PApplet;
import processing.core.PImage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Main extends PApplet {

    private List<PImage> meteorImages;
    private List<Meteor> meteors;
    private SpaceShip spaceShip;

    public static void main(String[] args) {
        PApplet.main(new String[]{"Main"});
    }
    @Override
    public void settings() {
        size(800, 600);
    }

    @Override
    public void setup() {
        setupMeteors();
        setupSpaceShip();
    }

    private void setupSpaceShip() {
        spaceShip = new KeyControlledShip(this);
    }

    private void setupMeteors() {
        this.meteorImages = Utils.loadAllMeteorImages(this);
        meteors = new ArrayList<>();
        for (int index = 0; index < 10; index++) {
            Meteor newMeteor = new RandomWalkerMeteor(this, randomMeteorImage());
            meteors.add(newMeteor);
        }
    }

    private PImage randomMeteorImage() {
        Random random = new Random();
        int randomIndex = random.nextInt(meteorImages.size());
        return meteorImages.get(randomIndex);
    }


    @Override
    public void draw() {
    background(100);
        spaceShip.display();
        for (Meteor m : meteors){
            m.display();
        }

        for (Meteor m : meteors){
            m.update();
        }
    }
}