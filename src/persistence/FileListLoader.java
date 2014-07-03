package imageViewer.persistence;

import model.ProxyImage;
import imageViewer.model.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileListLoader implements  ListLoader {
    private String path;

    public FileListLoader(String path) {
        this.path = path;
    }

    @Override
    public List<Image> load() {
        return linkImages(loadImages());
    }

    private List<Image> loadImages() {
        List<Image> images = new ArrayList<>();
        for (String file : new File(path).list()) {
            images.add(new ProxyImage(new FileImageLoader(path + "/" + file)));
        }
        return images;
    }

    private List<Image> linkImages(List<Image> images) {
        for (int i = 0; i < images.size(); i++) {
            Image image = images.get(i);
            image.setNext(images.get((i + 1) % images.size()));
            image.setPrev(images.get((i + images.size() - 1) % images.size()));
        }
        return images;
    }

}
