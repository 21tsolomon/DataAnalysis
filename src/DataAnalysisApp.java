import processing.core.PApplet;


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

    public void draw(){

    }

    public static DataAnalysisApp getApp(){
        return app;
    }

}
