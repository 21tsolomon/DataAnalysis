import processing.data.Table;
import processing.data.TableRow;
import java.util.ArrayList;

public class CheeseBank implements Sortable{
    private ArrayList<CheeseData> cheese;
    public CheeseBank(){
        //take CSV and sort it and add sorted to tobeyData
        cheese = new ArrayList<CheeseData>();
        DataAnalysisApp app = DataAnalysisApp.getApp();
        Table table = app.loadTable("Cheese Consumption and Average Weight Data.csv", "header");
        for (TableRow row : table.rows()){
            int year = row.getInt("Year");
            float consumption = row.getFloat("Consumption");
            float weight = row.getFloat("Weight");
            cheese.add(new CheeseData(year, consumption, weight));
            System.out.println("Imported cheese data");

        }

    }

    public void sort(){
        selectionSort();
    }

    private void selectionSort()
    {
        for(int lowerBound = 0; lowerBound < cheese.size() - 1; lowerBound++)
        {
            int minimumIndex = findMin(cheese,lowerBound);
            swap(cheese, lowerBound, minimumIndex);
        }
        System.out.println(cheese);
    }

    private int findMin (ArrayList <CheeseData> cheese,int minimumIndex)
    {

        for (int i = minimumIndex; i < cheese.size(); i++) {
            CheeseData cheeseA = cheese.get(minimumIndex);
            CheeseData cheeseB = cheese.get(i);
            if (cheeseB.getYear() < cheeseA.getYear()) // stringA.compareToIgnoreCase(stringB);
            {
                minimumIndex = i;
            }
        }
        return minimumIndex;
    }

    private static void swap (ArrayList<CheeseData> cheese,int x, int y)
    {
        CheeseData temp = cheese.get(x);
        cheese.set(x, cheese.get(y));
        cheese.set(y, temp);
    }

}

