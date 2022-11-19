package com.nursezim.todolist;

import com.nursezim.todolist.datamodel.TodoData;
import com.nursezim.todolist.datamodel.TodoItem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class HelloController {

    private List<TodoItem> todoItems;

    @FXML
    private ListView todoListView;

    @FXML
    private TextArea itemDetailsTextArea;

    @FXML
    private Label deadlineLabel;
    public void initialize() {
//      TodoItem item1 = new TodoItem("Blal", "LAla", LocalDate.of(2016, Month.APRIL, 25));
//        TodoItem item2 = new TodoItem("School", "Study", LocalDate.of(2016, Month.MARCH, 25));
//
//        TodoItem item3 = new TodoItem("Work", "Work", LocalDate.of(2016, Month.AUGUST, 25));
//
//        TodoItem item4 = new TodoItem("M", "Call", LocalDate.of(2016, Month.DECEMBER, 25));
//
//        TodoItem item5 = new TodoItem("Sport", "Do", LocalDate.of(2016, Month.APRIL, 25));
//        todoItems = new ArrayList<TodoItem>();
//        todoItems.add(item1);
//        todoItems.add(item2);
//        todoItems.add(item3);
//        todoItems.add(item4);
//        todoItems.add(item5);
//
//        TodoData.getInstance().setTodoItems(todoItems);
        todoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TodoItem>(){

            @Override
            public void changed(ObservableValue<? extends TodoItem> observable, TodoItem oldValue, TodoItem newValue) {
               if(newValue != null){
                   TodoItem item = (TodoItem) todoListView.getSelectionModel().getSelectedItem();
                   itemDetailsTextArea.setText(item.getDetails());
                   DateTimeFormatter df = DateTimeFormatter.ofPattern("MMMM d, yyyy");
                   deadlineLabel.setText(df.format(item.getDeadline()));
               }
            }
        });

        todoListView.getItems().setAll(TodoData.getInstance().getTodoItems());
        //todoListView.getItems().setAll(todoItems);
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    public void handleClickListView(){
        TodoItem item = (TodoItem) todoListView.getSelectionModel().getSelectedItem();
       // itemDetailsTextArea.setText(item.getDetails());
       // System.out.println("Lol" + item);
//        StringBuilder sb = new StringBuilder(item.getDetails());
//        sb.append("\n\n\n");
//        sb.append("Due: ");
//        sb.append(item.getDeadline().toString());
        itemDetailsTextArea.setText(item.getDetails());
        deadlineLabel.setText(item.getDeadline().toString());

    }
}