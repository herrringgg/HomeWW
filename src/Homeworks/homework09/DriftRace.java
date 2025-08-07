package Homeworks.homework09;

public class DriftRace extends Race {
    public DriftRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    public String startRace() {
        return "Drift Race started! Route: " + getRoute() + ", Length: " + getLength()
                + "m, Participants: " + getParticipants().size();
    }
}
