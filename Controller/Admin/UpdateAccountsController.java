/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Admin;

import Model.Accounts;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author MSI GF
 */
public class UpdateAccountsController implements Initializable {
    private Accounts oldAccounts;

    @FXML
    private Button updateAccountsBtn;
    @FXML
    private Button cancelBtn;
    @FXML
    private TextField AccountsNumTF;
    @FXML
    private TextField UserNameTF;
    @FXML
    private TextField BalanceTF;
    
    @FXML
    private TextField CurrnecyTF;
    @FXML
    private TextField CreationDateTF1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.oldAccounts = Controller.Admin.AccountsManagmentController.selectedAccountsToUpdate;
    } 

    @FXML
    private void updateAccounts(ActionEvent event) throws SQLException, ClassNotFoundException {
       String AccountsNum = AccountsNumTF.getText();
     String UserName = UserNameTF.getText();
     
     String Currency = CurrnecyTF.getText();
      String Balance = BalanceTF.getText();     
      String CreationDate = CreationDateTF1.getText();

//        // make an user object having this data       
  Accounts newaccounts = new Accounts(AccountsNum,UserName,Currency,Balance,CreationDate);
  
  newaccounts.setId(oldAccounts.getId());
  newaccounts.update();
    }

    @FXML
    private void cancelCreation(ActionEvent event) {
    }
    
}
