package imageViewer.persistence;
import imageViewer.model.Image;
import imageViewer.model.RealImage;
import java.io.File;
import java.io.IOException;
import imageViewer.swing.SwingBitmap;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class FileImageLoader implements ImageLoader {
    private final String path;

    public FileImageLoader(String path) {
        this.path = path;
    }

    @Override
    public Image load() {
        return new RealImage(new SwingBitmap(loadImage()));
    }

    private BufferedImage loadImage() {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}