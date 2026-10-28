# Código antigo (antes da refatoração)

Versão original do Sistema de Monitoramento Meteorológico, mantida apenas como referência.
Aqui a `WeatherStation` conhece diretamente cada painel concreto e chama a operação específica de cada um.

## CurrentConditionsDisplay.java

```java
public class CurrentConditionsDisplay {

    public void showTemperature(double temperature) {
        System.out.println("Current temperature: " + temperature + " C");
    }
}
```

## TemperatureAlert.java

```java
public class TemperatureAlert {

    public void checkTemperature(double temperature) {
        if (temperature >= 35.0) {
            System.out.println("High temperature alert: " + temperature + " C");
        }
    }
}
```

## WeatherStation.java

```java
public class WeatherStation {

    private double temperature;
    private CurrentConditionsDisplay display;
    private TemperatureAlert alert;

    public WeatherStation(CurrentConditionsDisplay display, TemperatureAlert alert) {
        this.display = display;
        this.alert = alert;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
        display.showTemperature(this.temperature);
        alert.checkTemperature(this.temperature);
    }
}
```

## Main.java

```java
public class Main {

    public static void main(String[] args) {

        CurrentConditionsDisplay display = new CurrentConditionsDisplay();
        TemperatureAlert alert = new TemperatureAlert();
        WeatherStation station = new WeatherStation(display, alert);

        station.setTemperature(28.0);
        station.setTemperature(36.0);
    }
}
```

## Problemas desta versão

- `WeatherStation` depende de cada destinatário concreto (`CurrentConditionsDisplay`, `TemperatureAlert`) e precisa conhecer o método específico de cada um (`showTemperature`, `checkTemperature`).
- Incluir um novo painel ou serviço de alerta exige modificar a estação (viola o princípio Aberto/Fechado).
- Não há como cadastrar ou remover interessados em tempo de execução: a lista de destinatários é fixa, definida no construtor.
