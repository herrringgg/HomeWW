package Homeworks.homework09;

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

