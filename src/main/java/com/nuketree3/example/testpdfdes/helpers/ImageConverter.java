package com.nuketree3.example.testpdfdes.helpers;

import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ImageConverter {

    public static Image bufferedImageToFxImage(BufferedImage bufferedImage) {
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "png", os);
            ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());
            return new Image(is);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

