module ch.makery.address {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.prefs;
    requires java.xml.bind;
    requires com.sun.xml.bind;

    opens ch.makery.address to javafx.fxml;
    opens ch.makery.address.view to javafx.fxml;
    opens ch.makery.address.model to java.xml.bind;
    exports ch.makery.address;
    exports ch.makery.address.model;
    exports ch.makery.address.util;
}
