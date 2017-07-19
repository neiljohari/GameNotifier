package me.skreem.listeners;

import me.skreem.Main;
import me.skreem.event.EventHandler;
import me.skreem.event.Listener;
import me.skreem.game.events.bomb.BombDefuseEvent;
import me.skreem.game.events.bomb.BombExplodeEvent;
import me.skreem.game.events.bomb.BombPlantEvent;
import me.skreem.game.events.round.RoundEndEvent;
import me.skreem.game.events.round.RoundFreezetimeEvent;
import me.skreem.game.events.round.RoundStartEvent;

import java.awt.*;

public class RoundListener implements Listener {
    @EventHandler
    public void onRoundFreezetimeEvent(RoundFreezetimeEvent event) {
        System.out.println("Freezetime");
        Main.getInstance().getTrayIcon().displayMessage("CSGO Alert", "Round is now in freezetime.", TrayIcon.MessageType.INFO);
    }

    @EventHandler
    public void onRoundStartEvent(RoundStartEvent event) {
        System.out.println("Round start");
        Main.getInstance().getTrayIcon().displayMessage("CSGO Alert", "Round is now live", TrayIcon.MessageType.INFO);
    }

    @EventHandler
    public void onRoundEndEvent(RoundEndEvent event) {
        System.out.println("Round end");
        Main.getInstance().getTrayIcon().displayMessage("CSGO Alert", "Round is now over", TrayIcon.MessageType.INFO);
    }
}
