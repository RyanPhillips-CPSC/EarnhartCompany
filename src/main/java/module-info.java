module com.example.demo1 {
    //requires javafx.base;
    //requires javafx.graphics;
    //requires org.kordamp.ikonli.core;
    //requires org.kordamp.ikonli.javafx;
    // add icon pack modules
    //requires org.kordamp.ikonli.fontawesome;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.demo1 to javafx.fxml;
    exports com.example.demo1;
}