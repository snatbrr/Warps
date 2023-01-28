package me.snat.warps.managers;

import me.snat.warps.Main;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class WarpManager {

    private Main main;
    private File file;
    private YamlConfiguration warps;


    public WarpManager(Main main) {
        this.main = main;
        this.file = new File(main.getDataFolder(), "warps.yml");
        this.warps = YamlConfiguration.loadConfiguration(file);

        if (!file.exists()) {
            try {
                file.createNewFile();
                warps = YamlConfiguration.loadConfiguration(file);
            } catch (IOException e) {
                System.out.println("Could not load warps.yml");
            }
        }
    }


    public void saveWarps() {
        try {
            warps.save(file);
        } catch (IOException e) {
            System.out.println("Could not save warps.yml");
        }
    }

    public YamlConfiguration getWarps() { return warps; }
}
