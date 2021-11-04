package exercise01_abstraction.p04_trafficLights;

public class Lights {

    private Signals signal;

    public Lights(Signals signal) {
        this.signal = signal;
    }

    public Signals getSignal() {
        return signal;
    }

    public void changeSignal() {
        switch (this.signal) {
            case RED:
                this.signal = Signals.GREEN;
                break;
            case GREEN:
                this.signal = Signals.YELLOW;
                break;
            case YELLOW:
                this.signal = Signals.RED;
                break;

        }
    }
}
