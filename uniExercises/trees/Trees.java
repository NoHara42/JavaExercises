/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author zeckzer
 */
public class Trees
    extends Application {

    @Override
    public void start(Stage stage) {
        TreesFrameController treesFrameController = TreesFrameController.getInstance();

        Parent root = treesFrameController.getRoot();

        Scene scene = new Scene(root);

        stage.setTitle("Trees");
        stage.setScene(scene);
        stage.show();

        treesFrameController.init();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
        // Application.launch(MyApplication.class, args);
    }

}
