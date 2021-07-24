package JavaFX.JavaFX;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
// import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.Color;
import javafx.stage.Stage;




public class MainApp extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		
		Group root = new Group();
		Scene scene = new Scene(root, Color.AQUA);
//		Image icon = new Image("icon.png");
//		
//		stage.getIcons().add(icon);
		stage.setTitle("ITech Solutions Login Area");
//		stage.setWidth(900);
//		stage.setHeight(900);
//		stage.setResizable(false);
		stage.setX(50);
		stage.setY(50);
		stage.setFullScreen(true);
		stage.setFullScreenExitHint("You can scape unless you press q");
		stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("q"));
		stage.setScene(scene);
		stage.show();
	}


}
