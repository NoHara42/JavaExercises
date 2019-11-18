/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

import java.io.IOException;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.scene.image.WritableImage;
import java.awt.image.RenderedImage;
import javax.imageio.ImageIO;
import javafx.embed.swing.SwingFXUtils;

/**
 * FXML Controller class
 *
 * @author zeckzer
 */
public class TreesFrameController
    implements Initializable {

    SplitPane rootPane;

    @FXML
    private TextField coordAx;
    @FXML
    private TextField coordBx;
    @FXML
    private TextField coordCx;
    @FXML
    private TextField coordDx;

    @FXML
    private TextField coordAy;
    @FXML
    private TextField coordBy;
    @FXML
    private TextField coordCy;
    @FXML
    private TextField coordDy;

    @FXML
    private Button saveButton;
    @FXML
    private Button quitButton;

    TreesPaneController treesPaneController;

    /**
     *
     * @param rootPane the parent element
     */
    public void setPane(SplitPane rootPane) {
        this.rootPane = rootPane;
    }

    /**
     *
     * @return parent element
     */
    public Parent getRoot() {
        return rootPane;
    }

    /**
     * @return the object loaded
     */
    public static TreesFrameController getInstance() {
        FXMLLoader loader = new FXMLLoader();
        try {
            // Load root layout from fxml file.
            loader.setLocation(TreesFrameController.class.getResource(
                "TreesFrame.fxml"));
            SplitPane rootPane = (SplitPane) loader.load();
            TreesFrameController treesFrameController = loader.<TreesFrameController>getController();
            treesFrameController.setPane(rootPane);
            return treesFrameController;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void init() {
        // Erzeuge controller für rechte Pane
        treesPaneController = TreesPaneController.getInstance();

        // // Setze rechte Pane der SplitPane
        rootPane.getItems().set(1, treesPaneController.getRoot());

        // // Initialisiere GUI Elemente der linken Seite
        coordAx.setText(Double.toString(treesPaneController.getAx()));
        coordAy.setText(Double.toString(treesPaneController.getAy()));
        coordBx.setText(Double.toString(treesPaneController.getBx()));
        coordBy.setText(Double.toString(treesPaneController.getBy()));
        coordCx.setText(Double.toString(treesPaneController.getCx()));
        coordCy.setText(Double.toString(treesPaneController.getCy()));
        coordDx.setText(Double.toString(treesPaneController.getDx()));
        coordDy.setText(Double.toString(treesPaneController.getDy()));

        // Zeichne rechte Seite
        // treesPaneController.draw();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void pointAxChanged(ActionEvent event) {
        double aX = Double.parseDouble(coordAx.getText());
        treesPaneController.setAx(aX);
    }

    @FXML
    private void pointBxChanged(ActionEvent event) {
        double bX = Double.parseDouble(coordBx.getText());
        treesPaneController.setBx(bX);
    }

    @FXML
    private void pointCxChanged(ActionEvent event) {
        double cX = Double.parseDouble(coordCx.getText());
        treesPaneController.setCx(cX);
    }

    @FXML
    private void pointDxChanged(ActionEvent event) {
        double dX = Double.parseDouble(coordDx.getText());
        treesPaneController.setDx(dX);
    }


    @FXML
    private void pointAyChanged(ActionEvent event) {
        double aY = Double.parseDouble(coordAy.getText());
        treesPaneController.setAy(aY);
    }

    @FXML
    private void pointByChanged(ActionEvent event) {
        double bY = Double.parseDouble(coordBy.getText());
        treesPaneController.setBy(bY);
    }

    @FXML
    private void pointCyChanged(ActionEvent event) {
        double cY = Double.parseDouble(coordCy.getText());
        treesPaneController.setCy(cY);
    }

    @FXML
    private void pointDyChanged(ActionEvent event) {
        double dY = Double.parseDouble(coordDy.getText());
        treesPaneController.setDy(dY);
    }

    @FXML
    private void quit(ActionEvent event) {
        System.exit(0);
    }
    @FXML
    private void saveImage(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("png files (*.png)", "*.png"));

        //Prompt user to select a file
        File file = fileChooser.showSaveDialog(null);

        if (file != null){
            try {
                // Pads the capture area
                WritableImage writableImage = new WritableImage(((int)((AnchorPane)treesPaneController.getRoot()).getWidth() + 20),
                        ((int)((AnchorPane)treesPaneController.getRoot()).getHeight() + 20));
                treesPaneController.getRoot().snapshot(null, writableImage);
                RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);
                // Writes the snapshot to the chosen file
                ImageIO.write(renderedImage, "png", file);
            } catch (IOException ex) { ex.printStackTrace(); }
        }
    }

}
