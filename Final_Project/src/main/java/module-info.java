module com.example.final_project {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;
    requires javafx.swing;
    requires ports.javaxt;
    requires jdk.jfr;

    opens com.example.final_project to javafx.fxml;
    exports com.example.final_project;
}