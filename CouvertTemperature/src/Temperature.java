public class Temperature {
    
    private double valeurCelcius;
    
    /**
     * Par défaut, la température est initialise à 0°C
     */
    public Temperature(){
        this.valeurCelcius = 0;
    }

    /**
     * @param  temperature  une tempéraure en degré Celcius (°C)
     */
    public Temperature(double temperature){
        this.valeurCelcius = temperature;
    }
    
    public double valeurCelcius(){
        return this.valeurCelcius;
    }

    public double valeurFahrenheit(){
        return this.valeurCelcius * 1.8 + 32;
    }

    /**
     * @param  nouvelleValeurCelcius  une tempéraure en degré Celcius (°C)
     */
    public void setvaleurCelcius(double nouvelleValeurCelcius){
        this.valeurCelcius = nouvelleValeurCelcius;
    }

    /**
     * @param  nouvelleValeurFahrenheit  une tempéraure en degré Fahrenheit (°F)
     */
     public void setvaleurFahrenheit(double nouvelleValeurFahrenheit){
        double nouvelleValeurCelcius = (nouvelleValeurFahrenheit - 32)/1.8;
        this.valeurCelcius = nouvelleValeurCelcius;
    }
    
    @Override
    public String toString(){
        return this.valeurCelcius+"°C = "+ this.valeurFahrenheit()+"°F";
    }
}

