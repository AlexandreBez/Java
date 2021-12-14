package javafxadvanced.advanced.main.config;

import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafxadvanced.advanced.main.controller.BaseController;
import javafxadvanced.advanced.main.controller.LoginController;
import javafxadvanced.advanced.main.controller.MainWindowController;
import javafxadvanced.advanced.main.controller.OptionsController;
import javafxadvanced.advanced.main.email.EmailManager;

public class ViewManager {
    
    private ArrayList<Stage> activeStages;
    private EmailManager emailManager;
    private boolean mainViewInitialized = false;
    
    private String version = "1.0.0";
    private String javaVersion = System.getProperty("java.version");
    private ColorTheme colorTheme = ColorTheme.DARK;
    private FontSize fontSize = FontSize.MEDIUM;

    public ViewManager(EmailManager emailManager) { 
        this.emailManager = emailManager; 
        activeStages = new ArrayList<Stage>();
    }

    public boolean isMainViewInitialized(){
        return mainViewInitialized;
    }

    public void showLoginWindow(){
        BaseController controller = new LoginController(emailManager, this, "login.fxml");
        initializeStage(controller);
    }

    public void showMainHub(){
        System.out.println("Actual Screen: Main Hub");
    
        BaseController controller = new MainWindowController(emailManager, this, "mainHub.fxml");
        initializeStage(controller);
        mainViewInitialized = true;
    }

    private void initializeStage(BaseController baseController){

        System.out.println("App version: " + version
                        +"\nJava Version:" + javaVersion
        );
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(baseController.getFxmlName()));
        fxmlLoader.setController(baseController);
        Parent parent;

        try {
            parent = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }        

        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

        activeStages.add(stage);
    }

    public void closeStage(Stage stageToClose){
        stageToClose.close();

        activeStages.remove(stageToClose);
    }

    public void showOptions(){
        BaseController controller = new OptionsController(emailManager, this, "options.fxml");
        initializeStage(controller);
    }

    /**
     * @return EmailManager return the emailManager
     */
    public EmailManager getEmailManager() {
        return emailManager;
    }

    /**
     * @param emailManager the emailManager to set
     */
    public void setEmailManager(EmailManager emailManager) {
        this.emailManager = emailManager;
    }

    /**
     * @return String return the version
     */
    public String getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * @return String return the javaVersion
     */
    public String getJavaVersion() {
        return javaVersion;
    }

    /**
     * @param javaVersion the javaVersion to set
     */
    public void setJavaVersion(String javaVersion) {
        this.javaVersion = javaVersion;
    }

    /**
     * @return ColorTheme return the colorTheme
     */
    public ColorTheme getColorTheme() {
        return colorTheme;
    }

    /**
     * @param colorTheme the colorTheme to set
     */
    public void setColorTheme(ColorTheme colorTheme) {
        this.colorTheme = colorTheme;
    }

    /**
     * @return FontSize return the fontSize
     */
    public FontSize getFontSize() {
        return fontSize;
    }

    /**
     * @param fontSize the fontSize to set
     */
    public void setFontSize(FontSize fontSize) {
        this.fontSize = fontSize;
    }

    public void updateStyes(){
        for (Stage stage: activeStages){
            Scene scene = stage.getScene();
            scene.getStylesheets().clear();
            scene.getStylesheets().add(getClass().getResource(ColorTheme.getClassPath(colorTheme)).toExternalForm());
            scene.getStylesheets().add(getClass().getResource(FontSize.getClassPath(fontSize)).toExternalForm());
        }
    }

}