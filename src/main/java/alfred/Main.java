package alfred;

import java.io.IOException;

import alfred.components.MainWindow;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * A GUI for Duke using FXML.
 */
public class Main extends Application {

    private Alfred alfred = new Alfred();

    /**
     * Starts the GUI of the program.
     * @param stage the primary stage for this application, onto which the application scene can be set.
     *     Applications may create other stages, if needed, but they will not be primary stages.
     */
    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setTitle("Alfred");
            stage.setResizable(false);
            stage.setScene(scene);
            fxmlLoader.<MainWindow>getController().setAlfred(alfred);
            fxmlLoader.<MainWindow>getController().showIntroduction(alfred.runIntro());
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
