import processing.core.PApplet;
import processing.data.Table;

import javax.swing.*;
import java.util.ArrayList;


public class DataAnalysisApp extends PApplet{
    private static DataAnalysisApp app;
    private CheeseBank cheese;
    private int barIndex;
    private boolean displayBarText;

    public static void main(String[] args) {
        PApplet.main("DataAnalysisApp");
    }

    public DataAnalysisApp(){
        app = this;
    }

    public void setup(){
        cheese = new CheeseBank();
        cheese.sort();
        barIndex = -1;
        displayBarText = false;


    }

    public void settings(){
        size(500, 500);

    }

    public void draw(){
        //visualize();
        //textSize(10);
        //text("year", 50, 30);
        //text("Cheese Consumption", 150, 30);
        //text("Average Weight of Male", 250, 30);
        background(0);
        stroke(255);
        line(50, 400, 450, 400);
        line(50, 400, 50, 50);
        ArrayList<CheeseData> arr = cheese.getArrayList();
        int barWidth = 400/ arr.size();
        for (int i = 0; i < arr.size(); i++){
            rect(50* (i+1), 400 - arr.get(i).getConsumption() * 10, barWidth, 10 * arr.get(i).getConsumption());
        }

        textSize(30);
        text("Year", width/2 - 20, 470);
        float x = 30;
        float y = 250;
        textAlign(CENTER,BOTTOM);

        pushMatrix();
        translate(x,y);
        rotate(-HALF_PI);
        text("Cheese Consumption",0,0);

        popMatrix();
        int val = 2000;
        int number = 0;
        for (int i = 0; i < 9; i++){
            textSize(10);
            text(val, 60 + number,420);
            val++;
            number = number + 50;
        }

        if (displayBarText == true){
            textSize(30);
            text("Average Weight:", width/2 - 100, 40);
            text(cheese.getArrayList().get(barIndex).getWeight() + "lbs", width/2 + 75, 40);
        }
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

    public void mouseClicked(){
        displayBarText = false;
        barIndex = -1;
        float offset = 50;
        for (int i = 0; i < cheese.getArrayList().size(); i++){
            float hello = cheese.getArrayList().get(i).getConsumption();
            float barW = app.width/cheese.getArrayList().size();
            if ((mouseX > i * barW) && (mouseX < (i + 1) * barW) && (mouseY > height - hello * 10 - offset)) {
                //
                barIndex = i;
                displayBarText = true;
            }

        }
    }



    public static DataAnalysisApp getApp(){
        return app;
    }

}
