module com.mazmorras {
    requires javafx.controls;
    requires javafx.fxml;
    
    opens com.mazmorras to javafx.fxml;
    opens com.mazmorras.models to javafx.base; // ¡Esta línea es crucial!
    
    exports com.mazmorras;
}
