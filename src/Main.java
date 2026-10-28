public class Main {

    public static void main(String[] args) {

        WeatherStation station = new WeatherStation();
        CurrentConditionsDisplay display = new CurrentConditionsDisplay();
        TemperatureAlert alert = new TemperatureAlert();

        station.addObserver(display);
        station.addObserver(alert);
        station.addObserver(display);

        System.out.println("--- 28 C (painel + alerta) ---");
        station.setTemperature(28.0);

        System.out.println("--- 36 C (painel + alerta) ---");
        station.setTemperature(36.0);

        station.removeObserver(alert);
        System.out.println("--- 38 C (somente painel) ---");
        station.setTemperature(38.0);

        station.removeObserver(display);
        station.removeObserver(display);
        System.out.println("--- 40 C (sem observadores) ---");
        station.setTemperature(40.0);
        System.out.println("Station still running. Last temperature: " + station.getTemperature() + " C");
    }
}
