package Pck1;

public class Throttle {

    // Data Members
    private int position;
    // Constructors
    public Throttle(int position) {
        this.position = position;
    }
    // Membership Functions
    public boolean is_on() {
        return flow() > 0;
    }

    public double flow() {
        return position / 6.0;
    }

    public void shift(int amount) {
        position += amount;

        if (position < 0)
            position = 0;
        else if (position > 6)
            position = 6;
    }

    public void shut_off() {
        position = 0;
    }
}
