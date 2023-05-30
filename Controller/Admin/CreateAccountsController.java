/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Admin;

import Model.Accounts;
import Model.User;
import View.ViewManager;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author MSI GF
 */
public class CreateAccountsController implements Initializable {

   
    @FXML
    private Button cancelBtn;
    @FXML
    private Button usersManagmentPageBtn;
    @FXML
    private Button accountsPageBtn;
    @FXML
    private Button operationsPageBtn;
    @FXML
    private TextField UserNameTF;
    @FXML
    private TextField CreationDateTF;
    @FXML
    private TextField CurrencyTF;
    @FXML
    private TextField BalanceTF;
    @FXML
    private Button SaveAccountBtn;
    @FXML
    private TextField AccountsNumTF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    

    @FXML
    private void showUsersManagmentPage(ActionEvent event) {
                ViewManager.adminPage.changeSceneToUsersManagment();

    }

    @FXML
    private void showAccountsPage(ActionEvent event) {
        ViewManager.adminPage.changeSceneToAccountsManagment();
    }

    @FXML
    private void showOperationsPage(ActionEvent event) {
    }

    
    @FXML
    private void cancelCreation(ActionEvent event) {
                ViewManager.adminPage.changeSceneToUsersManagment();

    }

    @FXML
    private void SaveAccounts(ActionEvent event) throws SQLException, ClassNotFoundException {
        String AccountsNum = AccountsNumTF.getText();
        String UserName = UserNameTF.getText();
        String Currency = CurrencyTF.getText();
        String Balance = BalanceTF.getText();
        String CreationDate = CreationDateTF.getText();

        // make an user object having this data
        
  Accounts accounts = new Accounts(AccountsNum,UserName,Currency,Balance,CreationDate);
        // save the user in database by save method
        accounts.save();
        
        //after saving should return to the back scene and show an alert
        ViewManager.adminPage.changeSceneToUsersManagment();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("User inserted");
        alert.setContentText("User inserted");
        alert.showAndWait();
    }
    
    
}
