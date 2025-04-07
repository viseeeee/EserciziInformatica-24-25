package Ingredienti;

public class Pizza extends  IngredientiNecessari{
    private Double Prosciutto;
    private Double Farina;
    private Double Pomodoro;

    public Double getPomodoro() {
        return Pomodoro;
    }

    public void setPomodoro(Double pomodoro) {
        Pomodoro = pomodoro;
    }

    public Double getProsciutto() {
        return Prosciutto;
    }

    public void setProsciutto(Double prosciutto) {
        Prosciutto = prosciutto;
    }

    public Double getFarina() {
        return Farina;
    }

    public void setFarina(Double farina) {
        this.Farina = farina;
    }
}
