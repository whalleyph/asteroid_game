import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import processing.core.PApplet;
import processing.core.PImage;

public class Utils {
    public static String chooseRandomMeteor() {
        String rootDir = System.getProperty("user.dir");
        String meteorImageDir = rootDir + "/images/Meteors";

        File meteorImageFolder = new File(meteorImageDir);
        File[] meteorImages = meteorImageFolder.listFiles();

        if (meteorImages != null && meteorImages.length > 0) {
            Random random = new Random();
            int randomIndex = random.nextInt(meteorImages.length);
            File randomMeteorImage = meteorImages[randomIndex];
            return randomMeteorImage.getAbsolutePath();
        }
        return "No meteor images found in the specified directory.";
    }
    public static List<PImage> loadAllMeteorImages(PApplet p5) {
        List<PImage> meteorImages = new ArrayList<PImage>();
        String rootDir = System.getProperty("user.dir");
        String meteorImageDir = rootDir + "/images/Meteors";
        File meteorImageFolder = new File(meteorImageDir);
        File[] meteorImageFiles = meteorImageFolder.listFiles();
        assert meteorImageFiles != null;
        for (File meteorImage : meteorImageFiles) {
            meteorImages.add(p5.loadImage(meteorImage.getAbsolutePath()));
        }
        return meteorImages;
    }
}
