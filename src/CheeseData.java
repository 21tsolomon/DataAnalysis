public class CheeseData {
        private int year;
        private float consumption;
        private float weight;
        public CheeseData(int year, float consumption, float weight){
            this.year = year;
            this.consumption = consumption;
            this.weight = weight;
        }

        public int getYear(){return year;}

        public float getConsumption(){
            return consumption;
        }

        public float getWeight(){
            return weight;
        }


}
