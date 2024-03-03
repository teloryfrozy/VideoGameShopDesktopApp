module com.javacourse.courseprojectfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires mysql.connector.j;
    requires java.sql;

    requires org.kordamp.bootstrapfx.core;

    opens com.videogameshop to javafx.fxml;
    exports com.videogameshop;
    opens com.videogameshop.fxControllers to javafx.fxml;
    exports com.videogameshop.fxControllers to javafx.fxml;
    opens com.videogameshop.model to javafx.fxml;
    exports com.videogameshop.model to javafx.fxml;
}