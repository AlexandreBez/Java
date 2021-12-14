package javafxadvanced.advanced.main.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafxadvanced.advanced.main.config.ColorTheme;
import javafxadvanced.advanced.main.config.FontSize;
import javafxadvanced.advanced.main.config.ViewManager;
import javafxadvanced.advanced.main.email.EmailManager;

public class OptionsController extends BaseController implements Initializable{

    public OptionsController(EmailManager emailManager, ViewManager viewManager, String fxmlName) {
        super(emailManager, viewManager, fxmlName);
    }

    @FXML
    private Button applyButtonAction;


    @FXML
    private Slider fontSize;

    @FXML
    private ChoiceBox<ColorTheme> themePicker;

    @FXML
    void applyButtonAction() {
        viewManager.setColorTheme(themePicker.getValue());
        viewManager.setFontSize(FontSize.values()[(int) fontSize.getValue()]);
        viewManager.updateStyes();
    }

    @FXML
    void cancelButtonAction() {
        Stage stage = (Stage) fontSize.getScene().getWindow();
        viewManager.closeStage(stage);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setUpThemePicker();
        setUpSizePicker();
    }

    private void setUpThemePicker(){
        themePicker.setItems(FXCollections.observableArrayList(ColorTheme.values()));
        themePicker.setValue(viewManager.getColorTheme());
    }

    private void setUpSizePicker(){
        fontSize.setMin(0);
        fontSize.setMax(FontSize.values().length - 1);
        fontSize.setValue(viewManager.getFontSize().ordinal());
        fontSize.setMajorTickUnit(1);
        fontSize.setMinorTickCount(0);
        fontSize.setBlockIncrement(1);
        fontSize.setSnapToTicks(true);
        fontSize.setShowTickMarks(true);
        fontSize.setShowTickLabels(true);
        fontSize.setLabelFormatter(new StringConverter<Double>() {

            @Override
            public String toString(Double object) {
                int i = object.intValue();
                return FontSize.values()[i].toString();
            }

            @Override
            public Double fromString(String string) {
                // TODO Auto-generated method stub
                return null;
            }
            
        });

        fontSize.valueProperty().addListener((obs, oldVal, newVal) -> {
            fontSize.setValue(newVal.intValue());
        });
    }

}