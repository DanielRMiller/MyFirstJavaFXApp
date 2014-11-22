/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * This is the main class of my Login application.
 * @author Xandron
 */
public class Login extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX Welcome");
        
        // Create a loginGrid at the center of the page with gaps of 10 and padding of 25
        GridPane loginGrid = new GridPane();
        loginGrid.setAlignment(Pos.CENTER);
        loginGrid.setHgap(10);
        loginGrid.setVgap(10);
        loginGrid.setPadding(new Insets(25, 25, 25, 25));
        
        // Put "Welcome" in "Tahoma" size 20 at the top of the loginGrid spanning 2 columns
        Text loginTitle = new Text("Welcome");
        loginTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        loginGrid.add(loginTitle, 0, 0, 2, 1);
        
        // Create a username text (Label) in the first row.
        Label userNameLabel = new Label("User Name:");
        loginGrid.add(userNameLabel, 0, 1);
        
        // Add a place to type in the user name (TextField) to the right of that (column 1).
        TextField userTextField = new TextField();
        loginGrid.add(userTextField, 1, 1);
        
        // Create password text for the password field. This will be below "User Name"
        Label pwLabel = new Label("Password:");
        loginGrid.add(pwLabel, 0, 2);
        
        // Add a place to enter the password (PasswordField) to the right of the password label.
        PasswordField passwordField = new PasswordField();
        loginGrid.add(passwordField, 1, 2);
        
        // Add some gridlines so we can see what we are doing. This should be deleted before pushed to production.
        // loginGrid.setGridLinesVisible(true);
        
        // Add a sign in button to the bottom right of the form.
        Button signInButton;
        signInButton = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(signInButton);
        loginGrid.add(hbBtn, 1, 4);
        
        // Create a way to see the output without the command line.
        final Text actionText = new Text();
        loginGrid.add(actionText, 1, 6);
        
        // When we hit the button, handle the event. How? Don't worry. It is in the Handler.
        signInButton.setOnAction(new EventHandlerImpl(actionText));
        
        // build a scene from the loginGrid we made. The screensize should be 300 by 275.
        Scene scene = new Scene(loginGrid, 300, 275);
        
        // put the scene on the stage
        primaryStage.setScene(scene);
        
        // Add a stylesheet to the scene
        scene.getStylesheets()
                .add(Login.class.getResource("Login.css").toExternalForm());
        
        // Open curtins. Show the scene.
        primaryStage.show();
    }

    /**
     * This function will be called if JavaFX is not integrated properly.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    private static class EventHandlerImpl implements EventHandler<ActionEvent> {
        /**
         * This is what will be changed when the button is pressed.
         */
        private final Text text;

        /**
         * We need an action target to create an instance of this class.
         * @param text 
         */
        public EventHandlerImpl(Text text) {
            this.text = text;
        }

        @Override
        public void handle(ActionEvent e) {
            text.setFill(Color.FIREBRICK);
            text.setText("Sign in button pressed");
        }
    }
    
}
