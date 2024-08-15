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
//        fullScreen();
        size(1200, 900);
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
        for (int index = 0; index < 15; index++) {
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

        spaceShip.update();
        for (Meteor m : meteors){
            m.update();
        }
    }

    @Override
    public void keyPressed(){
        if (key == ' '){
            spaceShip.turnLeft();
        }

        if (key == CODED) {
            if (keyCode == UP) {
                spaceShip.thrust();
            }
        }
    }
}