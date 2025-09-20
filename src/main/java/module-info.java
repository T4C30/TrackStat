module com.t4c30.juegostracker {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.core;
    requires java.net.http;

    opens com.t4c30.TrackStat to javafx.fxml;
    exports com.t4c30.TrackStat;
    exports com.t4c30.TrackStat.Goldberg to com.fasterxml.jackson.databind;
}
