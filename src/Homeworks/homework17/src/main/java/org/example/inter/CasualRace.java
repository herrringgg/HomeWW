package org.example.inter;

import org.example.zz.Race;

public class CasualRace extends Race {
    public CasualRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    public String startRace() {
        return "Casual Race started! Route: " + getRoute() + ", Length: " + getLength()
                + "m, Participants: " + getParticipants().size();
    }
}

