module com.javacourse.courseprojectfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires mysql.connector.j;
    requires java.sql;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires java.naming;

    requires org.kordamp.bootstrapfx.core;

    opens com.videogameshop to javafx.fxml;
    exports com.videogameshop;

    opens com.videogameshop.fxControllers to javafx.fxml, org.hibernate.orm.core, jakarta.persistence;
    exports com.videogameshop.fxControllers to javafx.fxml, org.hibernate.orm.core, jakarta.persistence;

    // Ouvrir le package com.videogameshop.model pour Hibernate
    opens com.videogameshop.model to org.hibernate.orm.core;
    exports com.videogameshop.model to org.hibernate.orm.core;

    // Exporter le package com.videogameshop à javafx.graphics
}