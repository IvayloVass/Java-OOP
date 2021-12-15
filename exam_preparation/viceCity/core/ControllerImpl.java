package viceCity.core;

import viceCity.core.interfaces.Controller;
import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.neighbourhood.Neighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


import static viceCity.common.ConstantMessages.*;

public class ControllerImpl implements Controller {

    private List<Player> players;
    private List<Gun> guns;
    private Player mainPlayer;
    private Neighbourhood neighbourhood;


    public ControllerImpl() {
        this.players = new ArrayList<>();
        this.guns = new ArrayList<>();
        this.mainPlayer = new MainPlayer();
        this.neighbourhood = new GangNeighbourhood();
    }

    @Override
    public String addPlayer(String name) {
        Player player = new CivilPlayer(name);
        players.add(player);

        return String.format(PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        Gun gun;
        switch (type) {
            case "Pistol":
                gun = new Pistol(name);
                break;
            case "Rifle":
                gun = new Rifle(name);
                break;
            default:
                return GUN_TYPE_INVALID;
        }
        guns.add(gun);
        return String.format(GUN_ADDED, name, type);
    }

    @Override
    public String addGunToPlayer(String name) {

        if (guns.isEmpty()) {
            return GUN_QUEUE_IS_EMPTY;
        }
        Gun gun = guns.get(0);
        if (name.equals("Vercetti")) {
            mainPlayer.getGunRepository().add(gun);
            guns.remove(gun);
            return String.format(GUN_ADDED_TO_MAIN_PLAYER, gun.getName(), "Tommy Vercetti");
        }
        Player player = players.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);
        if (player == null) {
            return CIVIL_PLAYER_DOES_NOT_EXIST;
        }
        player.getGunRepository().add(gun);
        return String.format(GUN_ADDED_TO_CIVIL_PLAYER, gun.getName(), name);
    }


    @Override
    public String fight() {
        int allPlayers = players.size();

        neighbourhood.action(mainPlayer, players);

        if (mainPlayer.getLifePoints() == 100 && players.stream().allMatch(p -> p.getLifePoints() == 50)) {
            return FIGHT_HOT_HAPPENED;
        }
        List<Player> deadPlayers = players.stream().filter(p -> !p.isAlive()).collect(Collectors.toList());

        StringBuilder output = new StringBuilder(FIGHT_HAPPENED).append(System.lineSeparator());
        output.append(String.format(MAIN_PLAYER_LIVE_POINTS_MESSAGE, mainPlayer.getLifePoints())).append(System.lineSeparator());
        output.append(String.format(MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE, deadPlayers.size()));
        output.append(System.lineSeparator());
        output.append(String.format(CIVIL_PLAYERS_LEFT_MESSAGE, allPlayers - deadPlayers.size()));

        for (Player player : deadPlayers) {
            players.remove(player);
        }

        return output.toString().trim();
    }
}
