package Rings;

public class TowerRingBase {
    private byte ringId = 0;
    private char ringIcon;

    public TowerRingBase(byte ringId, char ringIcon) {
        this.ringIcon = ringIcon;
        this.ringId = ringId;
    }

    @Override
    public String toString() {
        return String.valueOf(ringIcon).repeat(ringId);
    }

    public byte GetRingId() {
        return this.ringId;
    }

    public char GetRingIcon() {
        return this.ringIcon;
    }
}
