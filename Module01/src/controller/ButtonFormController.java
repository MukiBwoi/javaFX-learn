package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class ButtonFormController {
    public void clickMeOnAction(ActionEvent actionEvent) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Do you want to open Form", ButtonType.YES,ButtonType.NO);
        Optional<ButtonType> buttonType = alert.showAndWait();

        if (buttonType.get().equals(ButtonType.YES)){
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("../view/NextForm.fxml")));
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        }else{
            System.out.println("NO");
        }

    }
}
