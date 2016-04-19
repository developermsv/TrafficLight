import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by msv on 15.04.2016.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            TrafficLight trafficLight = new TrafficLight();
            System.out.print("Введите время работы зеленого сигнала светофора в минутах: ");
            trafficLight.setDurationBlinkByColorLamp(Lamp.COLORS.GREEN, Integer.valueOf(reader.readLine()));
            System.out.print("Введите время работы желтого сигнала светофора в минутах: ");
            trafficLight.setDurationBlinkByColorLamp(Lamp.COLORS.YELLOW, Integer.valueOf(reader.readLine()));
            System.out.print("Введите время работы красного сигнала светофора в минутах: ");
            trafficLight.setDurationBlinkByColorLamp(Lamp.COLORS.RED, Integer.valueOf(reader.readLine()));
            trafficLight.on();
        }
    }
}
