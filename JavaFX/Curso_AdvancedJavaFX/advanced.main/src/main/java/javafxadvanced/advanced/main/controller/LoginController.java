package javafxadvanced.advanced.main.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafxadvanced.advanced.main.config.ViewManager;
import javafxadvanced.advanced.main.email.EmailManager;
import javafxadvanced.advanced.main.model.EmailAccount;
import javafxadvanced.advanced.main.service.LoginService;

public class LoginController extends BaseController implements Initializable{

    @FXML
    private TextField emailLabel;

    @FXML
    private Label errorLabel;

    @FXML
    private PasswordField passwordLabel;

    public LoginController(EmailManager emailManager, ViewManager viewManager, String fxmlName) {
        super(emailManager, viewManager, fxmlName);
    }

    @FXML
    void loginAction() {

        if(fieldsAreValid()) {
            EmailAccount emailAccount = new EmailAccount(emailLabel.getText(), passwordLabel.getText());
            LoginService loginService = new LoginService(emailAccount, emailManager);
            loginService.start();
            loginService.setOnSucceeded(event -> {

                EmailLoginResult emailLoginResult = loginService.getValue();

                switch (emailLoginResult) {
                    case SUCESS:
                        System.out.println("Login sucefull " + emailAccount);
                        if (!viewManager.isMainViewInitialized()) {
                            viewManager.showMainHub();   
                        }
                        Stage stage = (Stage) errorLabel.getScene().getWindow();
                        viewManager.closeStage(stage);
                        return;
                    case FAILED_BY_CREDENTIALS:
                        errorLabel.setText("Invalid credentials");
                        return;
                    case FAILED_BY_UNEXPECTED_ERROR:
                        errorLabel.setText("Unexpected error");
                        return;
                    default:
                        return;
                }
            });
        }

        // System.out.println("click");
        // viewManager.showLoginWindow();

        // Stage stage = (Stage) errorLabel.getScene().getWindow();

        // viewManager.closeStage(stage);
    }
        
    private boolean fieldsAreValid(){

        if (emailLabel.getText().isEmpty()) {
            errorLabel.setText("Please fill email");
            return false;
        }
        
        if (passwordLabel.getText().isEmpty()) {
            errorLabel.setText("Please fill password");
        }

        return true;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        emailLabel.setText("teste@teste");
        passwordLabel.setText("teste");
    }

}