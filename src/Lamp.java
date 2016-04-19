/**
 * Created by msv on 15.04.2016.
 */
public class Lamp implements Signal, Runnable {

    public static final int SECONDS_IN_MINUTE = 60;
    public static final int TIMEOUT_SECOND = 1000;
    private int timeLeft;

    enum COLORS {GREEN, YELLOW, RED};
    private COLORS color;
    private int durationBlink;

    @Override
    public void run() {
        timeLeft = getDurationBlink();
        while (timeLeft-- != 0) {
            try {
                Thread.sleep(TIMEOUT_SECOND);
                showSignal();
            } catch (InterruptedException e) {
                System.out.println("Лампа перегорела!!!");
            }
        }
    }

    public Lamp(COLORS color) {
        this.color = color;
    }

    public void setDurationBlink(int durationBlink) {
        this.durationBlink = durationBlink * SECONDS_IN_MINUTE;
    }

    public int getDurationBlink() {
        return durationBlink;
    }


    public COLORS getColor() {
        return color;
    }

    @Override
    public Thread startBlink() {
        Thread thread = new Thread(this);
        thread.start();
        return thread;
    }

    @Override
    public void showSignal() {
        System.out.print('\r');
        System.out.print(getColor().toString() + "  " + timeLeft + " seconds");
    }
}
