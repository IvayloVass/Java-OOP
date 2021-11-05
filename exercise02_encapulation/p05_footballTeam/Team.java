package exercise02_encapulation.p05_footballTeam;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        this.name = name;
        this.players = new ArrayList<>();
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(String name) {

        boolean isRemoved = players.removeIf(player -> player.getName().equals(name));
        if (!isRemoved) {
            throw new IllegalArgumentException(String.format("exercise02_encapulation.p05_footballTeam.Player %s is not in Arsenal team.\n", name));
        }
    }

    public double getRating() {
        return players.stream().mapToDouble(Player::overallSkillLevel).average().orElse(0.0);
    }

    public List<Player> getPlayers() {
        return players;
    }
}
