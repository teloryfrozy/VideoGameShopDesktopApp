module com.javacourse.courseprojectfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.javacourse.courseprojectfx to javafx.fxml;
    exports com.javacourse.courseprojectfx;
    opens com.javacourse.courseprojectfx.fxControllers to javafx.fxml;
    exports com.javacourse.courseprojectfx.fxControllers to javafx.fxml;
}