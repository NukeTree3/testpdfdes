package com.nuketree3.example.testpdfdes.service;

import com.nuketree3.example.testpdfdes.fileworkers.FileRead;
import com.nuketree3.example.testpdfdes.fileworkers.FileReadable;
import com.nuketree3.example.testpdfdes.helpers.ImageConverter;
import javafx.scene.image.Image;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

public class Service {
    private final FileReadable fileRead;

    public Service() {
        fileRead = new FileRead();
    }

    public List<String> getFiles() {
        return fileRead.getFileList();
    }

    public PDDocument getPDF(String fileName) throws IOException {
        return fileRead.getFile(fileName);
    }

    public Image getImage(PDDocument document, int pageNumber) throws IOException {
        PDFRenderer pdfRenderer = new PDFRenderer(document);
        BufferedImage image = pdfRenderer.renderImage(pageNumber);
        Image fxImage = ImageConverter.bufferedImageToFxImage(image);
        return fxImage;
    }
}
