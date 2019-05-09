import processing.core.PApplet;
import processing.data.Table;

import javax.swing.*;
import java.util.ArrayList;


public class DataAnalysisApp extends PApplet{
    private static DataAnalysisApp app;
    private CheeseBank cheese;

    public static void main(String[] args) {
        PApplet.main("DataAnalysisApp");
    }

    public DataAnalysisApp(){
        app = this;
    }

    public void setup(){
        cheese = new CheeseBank();
        cheese.sort();


    }

    public void settings(){
        size(500, 500);

    }

    public void draw(){
        visualize();
        //textSize(10);
        //text("year", 50, 30);
        //text("Cheese Consumption", 150, 30);
        //text("Average Weight of Male", 250, 30);


    }

    private void visualize(){
        ArrayList<CheeseData> arr = cheese.getArrayList();
        int counter = 100;
        textSize(20);
        text("Year", 60, 100);
        textSize(10);
        text("Cheese Consumption (lbs)", 150, 110);
        textSize(10);
        text("Average Weight (lbs)", 280, 100);
        for (int i = 0; i < arr.size(); i++){
            textSize(20);
            text(arr.get(i).getYear(), 50, 50 + counter);
            text(arr.get(i).getConsumption(), 150, 50 + counter);
            text(arr.get(i).getWeight(), 250, 50 + counter);

            counter = counter + 30;

        }
    }

    public static DataAnalysisApp getApp(){
        return app;
    }

}
