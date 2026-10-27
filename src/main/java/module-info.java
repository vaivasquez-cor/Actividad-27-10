module cl.duoc.esports {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens cl.duoc.esports to javafx.fxml;
    exports cl.duoc.esports;

    opens cl.duoc.esports.controller to javafx.fxml;
    exports cl.duoc.esports.controller;

    opens cl.duoc.esports.model to javafx.fxml;
    exports cl.duoc.esports.model;
}