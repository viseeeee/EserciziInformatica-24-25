package Ingredienti;

import java.util.PrimitiveIterator;

public class IngredientiNecessari {
    private Double farina;
    private Double pomodoro;
    private Double prosciutto;
    private Double sommaTotale;
    private Double pomodoroProsciutto;
    private Pizza pizza;

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public Double getSommaTotale() {
        return sommaTotale;
    }
    public void setSommaTotale(Pizza pizza) {
        this.sommaTotale =pizza.getPomodoro()+pizza.getProsciutto()+pizza.getFarina();
    }

    public Double getPomodoro() {
        return pomodoro;
    }

    public void setPomodoro(Double pomodoro) {
        this.pomodoro = pomodoro;
    }

    public Double getProsciutto() {
        return prosciutto;
    }

    public void setProsciutto(Double prosciutto) {
        this.prosciutto = prosciutto;
    }

    public Double getFarina() {
        return farina;
    }

    public void setFarina(Double farina) {
        this.farina = farina;
    }

    public void setPomodoroProsciutto(Double pomodoroProsciutto) {
        this.pomodoroProsciutto = pomodoroProsciutto;
    }

    public Double getPomodoroProsciutto() {
        return pomodoroProsciutto;
    }
}
