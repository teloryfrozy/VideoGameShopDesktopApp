module com.coursework.courseprojectfxeng {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires java.sql;

    requires org.kordamp.bootstrapfx.core;

    opens com.coursework.courseprojectfxeng to javafx.fxml;
    exports com.coursework.courseprojectfxeng;
    opens com.coursework.courseprojectfxeng.fxControllers to javafx.fxml;
    exports com.coursework.courseprojectfxeng.fxControllers to javafx.fxml;
}