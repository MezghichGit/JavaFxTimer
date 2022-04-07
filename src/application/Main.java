package application;
	
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;


public class Main extends Application {
	public static Label lbl;
	@Override
	public void start(Stage primaryStage) {
		try {
			
			lbl = new Label("JavaFX");
	        lbl.setFont(Font.font(48));
	       
	        
	        
			StackPane root = new StackPane();
			root.getChildren().add(lbl);
			
			
			Scene scene = new Scene(root,400,400);
			
			
	        
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			// début Timer
			AnimationTimer timer = new MyTimer();
	        timer.start();
	        // Fin Timer

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

 class MyTimer extends AnimationTimer {
	 private double opacity = 1;

    @Override
    public void handle(long now) {

        doHandle();
    }

    private void doHandle() {

        opacity -= 0.01;
        Main.lbl.opacityProperty().set(opacity);

        if (opacity <= 0) {

            stop();
            System.out.println("Animation stopped");
        }
    }
}
