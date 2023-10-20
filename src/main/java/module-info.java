module YukMakan {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens YukMakan to javafx.fxml;
    exports YukMakan;
}
