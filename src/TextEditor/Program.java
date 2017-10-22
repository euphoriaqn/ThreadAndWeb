package TextEditor;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Created by user22 on 17.10.2017.
 */
public class Program extends Application{
    private final int WINDOW_WIDTH = 700;
    private final int WINDOW_HEIGHT = 500;

    private String nameOfProgram = "TextEditor2017";

    public static StackPane mainPane;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle(nameOfProgram);
        primaryStage.setResizable(false);
        primaryStage.setWidth(WINDOW_WIDTH);
        primaryStage.setHeight(WINDOW_HEIGHT);

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("fxml/startPageFXML.fxml"));
        mainPane = loader.load();
        mainPane.setAlignment(Pos.CENTER);

        Scene scene = new Scene(mainPane);
        scene.getStylesheets().add("TextEditor/css/TextRedactorCss.css");

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        System.exit(0);
    }
}
