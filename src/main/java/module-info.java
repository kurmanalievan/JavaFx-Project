module com.example.todolist {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.nursezim.todolist to javafx.fxml;
    exports com.nursezim.todolist;
}