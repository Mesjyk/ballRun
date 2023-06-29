package ballrun;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class BallRun extends Application {

    public static final int HIGHT = 500;
    public static final int WIDTH = 500;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        List<Button> masButtonS=makeButtonS();
        serrialize(masButtonS); 
        for(int i=0;i<masButtonS.size();i++){
            root.getChildren().add(masButtonS.get(i));
        }
        Scene scene = new Scene(root, WIDTH, HIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    public List<Button> makeButtonS() {
        List<Button> result=new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Button btn = MakeButton();
            result.add(btn);
        }
        return result;
    }

    public Button MakeButton() {
        Random random = new Random();
        Button btn = new Button();
        btn.setTranslateX(Math.abs((random.nextInt(WIDTH-16))));
        btn.setTranslateY(Math.abs((random.nextInt(HIGHT-26))));
        btn.setStyle("-fx-background-color: "+getColor()+";-fx-border-width: 5px;");
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btn.setTranslateX(Math.abs((random.nextInt(WIDTH-16))));
                btn.setTranslateY(Math.abs((random.nextInt(HIGHT-26))));
                btn.setStyle("-fx-background-color:"+ getColor()+";-fx-border-width: 5px;");
                System.out.println("Pop");
            }
        });
        return btn;
    }
    
    public static String getColor(){
        Random obj = new Random();
        int rand_num = obj.nextInt(0xffffff + 1);
        String colorCode = String.format("#%06x", rand_num);
        return colorCode;
    }

    private void serrialize(List<Button> masButtonS) {
        try{
           FileInputStream fileStream=new FileInputStream("Buttons.ser");
           ObjectInputStream objStream= new ObjectInputStream(fileStream);
        }
        catch(Exception exception){
            exception.printStackTrace();
        }
    }
}
