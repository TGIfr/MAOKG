package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Lab1");
        Group mygroup = new Group();
        Scene scene = new Scene (mygroup, 386, 236);

        var body = new Polygon(100, 108, 198, 31, 350, 98, 254, 138, 285, 202, 151, 213);
        mygroup.getChildren().add(body);
        body.setFill(Color.rgb(0, 255, 0));

        var back = new Polygon(273, 139, 336, 126, 296, 187);
        mygroup.getChildren().add(back);
        back.setFill(Color.YELLOW);

        var middle = new Line(101, 108, 254, 138);
        mygroup.getChildren().add(middle);
        middle.setStroke(Color.BLACK);
        middle.setStrokeWidth(3);

        var hornTop = new Line(126, 90, 64, 34);
        mygroup.getChildren().add(hornTop);
        hornTop.setStroke(Color.BLACK);
        hornTop.setStrokeWidth(6);
        hornTop.setStrokeLineCap(StrokeLineCap.ROUND);

        var hornBottom = new Line(127, 161, 56, 187);
        mygroup.getChildren().add(hornBottom);
        hornBottom.setStroke(Color.BLACK);
        hornBottom.setStrokeWidth(6);
        hornBottom.setStrokeLineCap(StrokeLineCap.ROUND);

        var eyeTop = new Rectangle(166, 86, 10, 10);
        mygroup.getChildren().add(eyeTop);
        eyeTop.setFill(Color.GREEN);

        var eyeBottom = new Rectangle(150, 142, 10, 10);
        mygroup.getChildren().add(eyeBottom);
        eyeBottom.setFill(Color.GREEN);


        scene.setFill(Color.rgb(0, 128, 128));

        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
