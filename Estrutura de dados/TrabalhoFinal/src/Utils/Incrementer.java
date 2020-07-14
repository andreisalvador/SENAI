package Utils;

public class Incrementer {
    public int Value;

    public Incrementer(){
        this(0);
    }
    public Incrementer(int startValue) {
        this.Value = startValue;
    }

    public void Increment() { Increment(1); }

    public void Increment(int valueToIncrement) { Value += valueToIncrement; }
}