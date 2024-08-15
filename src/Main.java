import processing.core.PApplet;
import processing.core.PImage;

import java.util.*;


public class Main extends PApplet {

    private List<PImage> meteorImages;
    private List<Meteor> meteors;
    private SpaceShip spaceShip;
    private HashMap<Character, Boolean> gameKeyIsPressed = new HashMap<>();

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
        gameKeyIsPressed.put('w', false);
        gameKeyIsPressed.put('a', false);
        gameKeyIsPressed.put('s', false);
        gameKeyIsPressed.put('d', false);
        setupMeteors();
        setupSpaceShip();
    }

    private void setupSpaceShip() {
        spaceShip = new KeyControlledShip(this);
    }

    private void controlShip() {
        spaceShip.update();
        if (gameKeyIsPressed.get('w')) {
            spaceShip.thrust();
        }
        if (gameKeyIsPressed.get('a')) {
            spaceShip.turnLeft();
        }
        if (gameKeyIsPressed.get('d')) {
            spaceShip.turnRight();
        }
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
        background(0);
        spaceShip.display();
        for (Meteor m : meteors) {
            m.display();
        }

        for (Meteor m : meteors) {
            m.update();
        }
        controlShip();
    }

    @Override
    public void keyPressed() {
        if (gameKeyIsPressed.containsKey(key)) {
            gameKeyIsPressed.put(key, true);
        }
    }

    public void keyReleased() {
        if (gameKeyIsPressed.containsKey(key)) {
            gameKeyIsPressed.put(key, false);
        }
    }
}