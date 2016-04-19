/**
 * Created by msv on 15.04.2016.
 */
public class TrafficLight {
    Lamp[] lamps = new Lamp[3];

    public TrafficLight() {
        for (int i = 0; i < lamps.length; i++) {
            lamps[i] = new Lamp(Lamp.COLORS.values()[i]);
        }
    }

    public void setDurationBlinkByColorLamp(Lamp.COLORS color, int durationInMinute) {
        for (Lamp lamp : lamps) {
            if (lamp.getColor().equals(color)) {
                lamp.setDurationBlink(durationInMinute);
            }
        }
    }

    public void on() {
        System.out.println("Включаем светофор...");
        for (Lamp lamp : lamps) {
            Thread threadLamp = lamp.startBlink();
            try {
                threadLamp.join();
            } catch (InterruptedException e) {
                System.out.println("Светофор сломался!!!");
            }
        }
        System.out.println("\nСветофор отработал цикл и выключился ...");
    }
}

