package com.suixin.tavern.handler;

import com.suixin.tavern.Tavern;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class BetDataHandler {
    private final Tavern tavern;

    public BetDataHandler(final Tavern tavern) {
        this.tavern = tavern;
        this.SaveDbConfig();
    }
    //读取数据库配置数据
    public FileConfiguration LoadDbData( ) {
        final File file = new File(this.tavern.getDataFolder(), "db.yml");
        final FileConfiguration config = YamlConfiguration.loadConfiguration(file);
        return config;
    }

    public void SaveDbConfig() {
        final File file = new File(this.tavern.getDataFolder(), "db.yml");

        if (!file.exists()) {
            this.tavern.getDataFolder().mkdirs();
            final FileConfiguration config = new YamlConfiguration();
            config.set("Mysql.dbDriver", "com.mysql.cj.jdbc.Driver");
            config.set("Mysql.dbURL", "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone = GMT");
            config.set("Mysql.userName", "root");
            config.set("Mysql.password", "1234");
            try {
                config.save(file);
            } catch (final IOException e) {
                e.printStackTrace();
            }
        }
    }
}
