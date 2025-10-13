package org.example.inter;

import org.example.zz.Race;

public class DragRace extends Race {
    public DragRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    public String startRace() {
        return "Drag Race started! Route: " + getRoute() + ", Length: " + getLength()
                + "m, Participants: " + getParticipants().size();
    }
}
