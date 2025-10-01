package dev.drtheo.yaar.example.data;

import dev.drtheo.yaar.data.TData;
import mock.AbsoluteBlockPos;
import mock.Identifier;

public class TravelData implements TData<TravelData> {

    public static final Holder<TravelData> ID = new GsonBacked<>(
            new Identifier("ait", "travel"), TravelData.class);

    private Identifier dematId;
    private Identifier matId;
    private int flightTicks;
    private int targetTicks;
    private boolean handbrake;
    private boolean autopilot;
    private State state;
    private AbsoluteBlockPos position;
    private AbsoluteBlockPos previousPosition;
    private AbsoluteBlockPos destination;
    private boolean leaveBehind;
    private boolean crashing;
    private boolean antigravs;
    private int speed;
    private int maxSpeed;
    private GroundSearch vGroundSearch;
    private boolean hGroundSearch;
    private int hammerUses;

    public enum State {
        LANDED, DEMAT, FLIGHT, MAT
    }

    public enum GroundSearch {
        CEILING, FLOOR, MEDIAN
    }

    @Override
    public Holder<TravelData> holder() {
        return ID;
    }

    @Override
    public String toString() {
        return "TravelData{" +
                "dematId=" + dematId +
                ", matId=" + matId +
                ", flightTicks=" + flightTicks +
                ", targetTicks=" + targetTicks +
                ", handbrake=" + handbrake +
                ", autopilot=" + autopilot +
                ", state=" + state +
                ", position=" + position +
                ", previousPosition=" + previousPosition +
                ", destination=" + destination +
                ", leaveBehind=" + leaveBehind +
                ", crashing=" + crashing +
                ", antigravs=" + antigravs +
                ", speed=" + speed +
                ", maxSpeed=" + maxSpeed +
                ", vGroundSearch=" + vGroundSearch +
                ", hGroundSearch=" + hGroundSearch +
                ", hammerUses=" + hammerUses +
                '}';
    }
}
