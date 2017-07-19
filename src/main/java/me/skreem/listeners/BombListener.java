package me.skreem.listeners;

import me.skreem.Main;
import me.skreem.event.EventHandler;
import me.skreem.event.Listener;
import me.skreem.game.events.bomb.BombDefuseEvent;
import me.skreem.game.events.bomb.BombExplodeEvent;
import me.skreem.game.events.bomb.BombPlantEvent;

import java.awt.*;

public class BombListener implements Listener {
    @EventHandler
    public void onBombPlantEvent(BombPlantEvent event) {
        System.out.println("Bomb planted");
        Main.getInstance().getTrayIcon().displayMessage("CSGO Alert", "Bomb has been planted!", TrayIcon.MessageType.INFO);
    }

    @EventHandler
    public void onBombExplodeEvent(BombExplodeEvent event) {
        System.out.println("Bomb exploded");
        Main.getInstance().getTrayIcon().displayMessage("CSGO Alert", "Bomb has exploded!", TrayIcon.MessageType.INFO);
    }

    @EventHandler
    public void onBombDefuseEvent(BombDefuseEvent event) {
        System.out.println("Bomb defused");
        Main.getInstance().getTrayIcon().displayMessage("CSGO Alert", "Bomb has defused!", TrayIcon.MessageType.INFO);
    }
}
