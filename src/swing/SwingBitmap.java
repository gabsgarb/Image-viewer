package imageViewer.swing;
import imageViewer.model.Bitmap;
import java.awt.image.BufferedImage;
public class SwingBitmap implements Bitmap {
    
    private final BufferedImage bufferedImage;
    
    public SwingBitmap(BufferedImage buf) {
        this.bufferedImage = buf;
    }
    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }
    @Override
    public int getWidth() {
        return bufferedImage.getWidth();
    }
    @Override
    public int getHeight() {
        return bufferedImage.getHeight();
    }
}