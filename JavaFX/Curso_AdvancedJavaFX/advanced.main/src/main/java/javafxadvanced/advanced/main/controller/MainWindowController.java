package javafxadvanced.advanced.main.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeView;
import javafxadvanced.advanced.main.config.ViewManager;
import javafxadvanced.advanced.main.email.EmailManager;

public class MainWindowController extends BaseController implements Initializable{

    @FXML
    private TreeView<?> emailsTreeView;

    @FXML
    private TableView<?> emailstable;

    @FXML
    void OptionsAction() {
        viewManager.showOptions();
    }

    public MainWindowController(EmailManager emailManager, ViewManager viewManager, String fxmlName) {
        super(emailManager, viewManager, fxmlName);
    }

    @FXML
    void AddAccountAction() {
        viewManager.showLoginWindow();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setUpEmailsTreeView();
    }

    private void setUpEmailsTreeView(){
        emailsTreeView.setRoot(emailManager.getFoldersRoot());
        emailsTreeView.setShowRoot(false);
    }

}