package me.skreem;

import me.skreem.event.Event;
import me.skreem.game.net.Server;
import me.skreem.listeners.BombListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    private static Main instance;
    private TrayIcon trayIcon;

    public static Main getInstance() {
        if(instance == null)
            instance = new Main();
        return instance;
    }

    private Main() {
        instance = this;
        setupTray();
        setupIntegration();
    }

    private void setupIntegration() {
        Event.addListener(new BombListener());
        Server server = new Server();
        try {
            server.start(3000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setupTray() {
        if (SystemTray.isSupported()) {
            SystemTray tray = SystemTray.getSystemTray();

            Image image = null;
            try {
                image = new ImageIcon(ImageIO.read(this.getClass().getResourceAsStream("tray.png"))).getImage();
            } catch (IOException e) {
                e.printStackTrace();
            }
            trayIcon = new TrayIcon(image, "CSGO Alert");
            trayIcon.setImageAutoSize(true);


            try {
                tray.add(trayIcon);
            } catch (AWTException e) {
                System.err.println("TrayIcon could not be added.");
            }
        }
    }

    public TrayIcon getTrayIcon() {
        return this.trayIcon;
    }

    public static void main(String[] args) {
        new Main();
    }
}
