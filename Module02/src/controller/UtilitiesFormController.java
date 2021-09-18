package controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class UtilitiesFormController {
    public TextField txtUserName;
    public PasswordField pwdUser;
    public Label lblUser;
    public CheckBox cbxJava;
    public CheckBox cbxR;
    public CheckBox cbxFlutter;
    public CheckBox cbxJavascript;
    public TextArea selectedLanguages;
    public RadioButton rbtnMale;
    public TextField selectedGender;
    public ComboBox cmbCities;
    public ListView<String> listRegions;
    public Label lblSelectedRegion;

    public void initialize(){
       /* ObservableList<String> obList = FXCollections.observableArrayList();
        obList.add("Colombo");
        obList.add("Galle");
        obList.add("Mathara");
        obList.add("Panadura");
        cmbCities.setItems(obList);*/
        /*cmbCities.getItems().add("Colombo");
        cmbCities.getItems().add("Galle");
        cmbCities.getItems().add("Mathara");
        cmbCities.getItems().add("Panadura");*/
        cmbCities.getItems().addAll("Colombo","Galle","Matara","Panadura");

        //-----------------------listRegion---------------------
ArrayList<String> regionArrayList = new ArrayList<>();
        regionArrayList.add("Colombo");
        regionArrayList.add("Jaffna");
        regionArrayList.add("Galle");
        regionArrayList.add("Matara");
        regionArrayList.add("MtLavinia");
        regionArrayList.add("Gampaha");
        ObservableList obList = FXCollections.observableArrayList(regionArrayList);
       /* obList.add("Colombo");
        obList.add("Jaffna");
        obList.add("Galle");
        obList.add("Matara");
        obList.add("MtLavinia");
        obList.add("Gampaha");*/
        listRegions.setItems(obList);

        //----------------------Listner------------------------
        listRegions.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            /*System.out.println(oldValue);
            System.out.println(newValue);*/

            lblSelectedRegion.setText(newValue);
        });

    }

    //button Functions
    public void loginOnAction(ActionEvent actionEvent){
    if(txtUserName.getText().equals("nimal") && pwdUser.getText().equals("1234")){
            lblUser.setText("Nimal");
        }else{
            new Alert(Alert.AlertType.ERROR,"Wrong Credentials...").show();
        }
    }

    public void btnSubmitOnAction(ActionEvent actionEvent) {
        ArrayList<String> list  = new ArrayList<>();
        if(cbxJava.isSelected()){list.add("Java");}
        if(cbxR.isSelected()){list.add("R");}
        if(cbxFlutter.isSelected()){list.add("Flutter");}
        if(cbxJavascript.isSelected()){list.add("JavaScript");}

        selectedLanguages.setText("");
        for (String temp:list){
            selectedLanguages.appendText(temp+", ");
        }
        System.out.println("\b");

    }

    public void choose(ActionEvent actionEvent) {
        String gender = "Male";
        if (!rbtnMale.isSelected()){
            gender="Female";
        }
        selectedGender.setText(gender);
    }

    public void selectOnAction(ActionEvent actionEvent) {
        new Alert(Alert.AlertType.CONFIRMATION,"Selected City Name is : "+ cmbCities.getValue()).show();
    }

   public void selectRegionOnAction(MouseEvent mouseEvent) {
       // lblSelectedRegion.setText(listRegions.getSelectionModel().getSelectedItem());
    }
}
