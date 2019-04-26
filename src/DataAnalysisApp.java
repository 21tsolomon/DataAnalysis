import processing.core.PApplet;


public class DataAnalysisApp extends PApplet{
    private static DataAnalysisApp app;

    public static void main(String[] args) {
        PApplet.main("DataAnalysisApp");
    }

    public static DataAnalysisApp getApp(){
        return app;
    }

}
