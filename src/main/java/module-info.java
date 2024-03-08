module com.example.pixelpaintprogram {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.pixelpaintprogram to javafx.fxml;
    exports com.example.pixelpaintprogram;
    exports com.example.pixelpaintprogram.Tools;
    opens com.example.pixelpaintprogram.Tools to javafx.fxml;
}