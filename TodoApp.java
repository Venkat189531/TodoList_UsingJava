import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class TodoApp extends Application {

    private ObservableList<String> tasks;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("To-Do List App");

        // Initialize task list
        tasks = FXCollections.observableArrayList();

        // ListView to display tasks
        ListView<String> taskListView = new ListView<>(tasks);

        // TextField to enter new tasks
        TextField taskInput = new TextField();
        taskInput.setPromptText("Enter new task");

        // Add button
        Button addButton = new Button("Add");
        addButton.setOnAction(e -> {
            String task = taskInput.getText().trim();
            if (!task.isEmpty()) {
                tasks.add(task);
                taskInput.clear();
            }
        });

        // Remove button
        Button removeButton = new Button("Remove Selected");
        removeButton.setOnAction(e -> {
            String selected = taskListView.getSelectionModel().getSelectedItem();
            if (selected != null) {
                tasks.remove(selected);
            }
        });

        // Layouts
        HBox inputLayout = new HBox(10, taskInput, addButton, removeButton);
        inputLayout.setPadding(new Insets(10));

        VBox mainLayout = new VBox(10, taskListView, inputLayout);
        mainLayout.setPadding(new Insets(10));

        // Scene
        Scene scene = new Scene(mainLayout, 400, 300);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
