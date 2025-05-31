package com.nuketree3.example.testpdfdes.fileworkers;

import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.IOException;
import java.util.List;

public interface FileReadable {
    List<String> getFileList();
    PDDocument getFile(String filename) throws IOException;
}
