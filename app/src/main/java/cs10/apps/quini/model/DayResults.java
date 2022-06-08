package cs10.apps.quini.model;

public class DayResults {
    private final int[] resultados = new int[8];
    private int day;

    public void setDay(int day) {
        this.day = day;
    }

    public int getDay() {
        return day;
    }

    public void set(int number, int position){
        resultados[position] = number;
    }

    public int get(int position){
        return resultados[position];
    }
}
