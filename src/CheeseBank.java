import processing.data.Table;
import processing.data.TableRow;
import java.util.ArrayList;

public class CheeseBank implements Sortable{
    private ArrayList<CheeseData> tobeyData;
    public CheeseBank(){
        //take CSV and sort it and add sorted to tobeyData
        tobeyData = new ArrayList<CheeseData>();
        DataAnalysisApp app = DataAnalysisApp.getApp();
        Table table = app.loadTable("CatsPerYear.csv", "header");
        for (TableRow row : table.rows()){
            int year = row.getInt("Year");
            float consumption = row.getFloat("Consumption");
            float weight = row.getFloat("Weight");
            tobeyData.add(new CheeseData(year, consumption, weight));
            System.out.println("Imported cat data");

        }

    }
}

