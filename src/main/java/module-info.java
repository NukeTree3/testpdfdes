module com.nuketree3.example.testpdfdes {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.pdfbox;
    requires static lombok;
    requires java.desktop;


    opens com.nuketree3.example.testpdfdes to javafx.fxml;
    exports com.nuketree3.example.testpdfdes.fileworkers;
    opens com.nuketree3.example.testpdfdes.fileworkers to javafx.fxml;
    exports com.nuketree3.example.testpdfdes.GUI;
    opens com.nuketree3.example.testpdfdes.GUI to javafx.fxml;
}