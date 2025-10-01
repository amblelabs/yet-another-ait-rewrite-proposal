package dev.drtheo.yaar.example.data;

import dev.drtheo.yaar.data.TData;
import mock.Identifier;

public class DoorData implements TData<DoorData> {

    public static final Holder<DoorData> ID = new GsonBacked<>(
            new Identifier("ait", "door"), DoorData.class);

    private boolean locked;
    private boolean deadlocked;

    private State state;

    private float leftDoorRot;
    private float rightDoorRot;

    public enum State {
        CLOSED, HALF, BOTH
    }

    @Override
    public Holder<DoorData> holder() {
        return ID;
    }

    @Override
    public String toString() {
        return "DoorData{" +
                "locked=" + locked +
                ", deadlocked=" + deadlocked +
                ", state=" + state +
                ", leftDoorRot=" + leftDoorRot +
                ", rightDoorRot=" + rightDoorRot +
                '}';
    }
}
