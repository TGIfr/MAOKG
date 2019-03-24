package sample;


import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Heart extends Application {

    public static void main(String args[]) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 1200, 600);

        //stripebacks
        var s1 = new Ellipse(135, 200, 50, 20);
        s1.setStroke(Color.DARKGOLDENROD);
        s1.setFill(Color.DARKGOLDENROD);
        s1.setStrokeWidth(4);
        root.getChildren().add(s1);

        var s2 = new Ellipse(435, 275, 60, 20);
        s2.setStroke(Color.DARKGOLDENROD);
        s2.setFill(Color.DARKGOLDENROD);
        s2.setStrokeWidth(4);
        root.getChildren().add(s2);

        //Heart
        var h1 = new Ellipse(211, 168, 85, 85);
        h1.setStroke(Color.RED);
        h1.setFill(Color.RED);
        h1.setStrokeWidth(4);
        root.getChildren().add(h1);

        var h2 = new Ellipse(364, 168, 85, 85);
        h2.setStroke(Color.RED);
        h2.setFill(Color.RED);
        h2.setStrokeWidth(4);
        root.getChildren().add(h2);

        var moveTo1 = new MoveTo(135, 205);
        var curve2 = new QuadCurveTo(289, 383, 255, 400);
        var curve3 = new QuadCurveTo(396, 313, 450, 175);
        var heart = new Path();
        heart.setStrokeWidth(2);
        heart.setStroke(Color.RED);
        heart.setFill(Color.RED);
        heart.getElements().addAll(moveTo1, curve2, curve3);
        root.getChildren().add(heart);

        //Stripe
        var moveTo2 = new MoveTo(83, 201);
        var curve4 = new QuadCurveTo(117, 236, 295, 196);
        var curve5 = new QuadCurveTo(479, 162, 494, 203);
        var dash1 = new LineTo(496, 273);
        var curve6 = new QuadCurveTo(479, 242, 295, 276);
        var curve7 = new QuadCurveTo(158, 316, 82, 275);
        var stripe = new Path();
        stripe.setStrokeWidth(2);
        stripe.setStroke(Color.GOLD);
        stripe.setFill(Color.GOLD);
        stripe.getElements().addAll(moveTo2, curve4, curve5, dash1, curve6, curve7);
        root.getChildren().add(stripe);

        //arrow top
        var moveTo3 = new MoveTo(407, 146);
        var dash2 = new LineTo(453, 110);
        var dash3 = new LineTo(495, 124);
        var dash4 = new LineTo(563, 75);
        var dash5 = new LineTo(522, 58);
        var dash6 = new LineTo(530, 48);
        var dash7 = new LineTo(523, 49);
        var dash8 = new LineTo(515, 44);
        var dash9 = new LineTo(505, 6);
        var dash10 = new LineTo(441, 56);
        var dash11 = new LineTo(444, 100);
        var dash12 = new LineTo(395, 138);
        var arTop = new Path();
        arTop.setStrokeWidth(2);
        arTop.setStroke(Color.GOLD);
        arTop.setFill(Color.GOLD);
        arTop.getElements().addAll(moveTo3, dash2, dash3, dash4,
                dash5, dash6, dash7, dash8, dash9, dash10, dash11, dash12);
        root.getChildren().add(arTop);

        //arrow bottom

        var moveTo4 = new MoveTo(214, 302);
        var dash13 = new LineTo(168, 338);
        var qCurve1 = new QuadCurveTo(193, 376, 87, 395);
        var qCurve2 = new QuadCurveTo(127, 298, 156, 328);
        var dash14 = new LineTo(203, 294);

        var arBot = new Path();
        arBot.setStrokeWidth(2);
        arBot.setStroke(Color.GOLD);
        arBot.setFill(Color.GOLD);
        arBot.getElements().addAll(moveTo4, dash13, qCurve1, qCurve2, dash14);
        root.getChildren().add(arBot);

        // Animation
        int cycleCount = 2;
        int time = 2000;

        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(time), root);
        scaleTransition.setToX(2);
        scaleTransition.setToY(2);
        scaleTransition.setAutoReverse(true);

        RotateTransition rotateTransition = new RotateTransition(Duration.millis(time), root);
        rotateTransition.setByAngle(360f);
        rotateTransition.setCycleCount(cycleCount);
        rotateTransition.setAutoReverse(true);

        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(time), root);
        translateTransition.setFromX(150);
        translateTransition.setToX(50);
        translateTransition.setCycleCount(cycleCount + 1);
        translateTransition.setAutoReverse(true);

        TranslateTransition translateTransition2 = new TranslateTransition(Duration.millis(time), root);
        translateTransition2.setFromX(50);
        translateTransition2.setToX(150);
        translateTransition2.setCycleCount(cycleCount + 1);
        translateTransition2.setAutoReverse(true);

        ScaleTransition scaleTransition2 = new ScaleTransition(Duration.millis(time), root);
        scaleTransition2.setToX(0.1);
        scaleTransition2.setToY(0.1);
        scaleTransition2.setCycleCount(cycleCount);
        scaleTransition2.setAutoReverse(true);

        ParallelTransition parallelTransition = new ParallelTransition();
        parallelTransition.getChildren().addAll(
                rotateTransition,
                scaleTransition,
                scaleTransition2,
                translateTransition
        );
        parallelTransition.setCycleCount(Timeline.INDEFINITE);
        parallelTransition.play();
//        // End of animation

        primaryStage.setResizable(false);
        primaryStage.setTitle("Lab 3");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
