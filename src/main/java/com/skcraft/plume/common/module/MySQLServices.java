package com.skcraft.plume.common.module;

import com.google.inject.Inject;
import com.sk89q.worldedit.util.eventbus.Subscribe;
import com.skcraft.plume.common.auth.Hive;
import com.skcraft.plume.common.ban.BanManager;
import com.skcraft.plume.common.config.Config;
import com.skcraft.plume.common.config.InjectConfig;
import com.skcraft.plume.common.event.lifecycle.InitializationEvent;
import com.skcraft.plume.common.extension.ServiceLocator;
import com.skcraft.plume.common.extension.module.Module;
import com.skcraft.plume.common.party.PartyManager;
import com.skcraft.plume.common.sql.DatabaseBans;
import com.skcraft.plume.common.sql.DatabaseHive;
import com.skcraft.plume.common.sql.DatabaseManager;
import com.skcraft.plume.common.sql.DatabaseParties;
import lombok.Getter;
import ninja.leaping.configurate.objectmapping.Setting;

@Module(name = "mysql-services")
public class MySQLServices {

    @InjectConfig("mysql/services")
    private Config<ServicesConfig> config;

    private final MySQLPool pool;
    private final ServiceLocator services;

    @Getter private Hive hive;
    @Getter private BanManager bans;
    @Getter private PartyManager parties;

    @Inject
    public MySQLServices(MySQLPool pool, ServiceLocator services) {
        this.pool = pool;
        this.services = services;
    }

    @Subscribe
    public void onInitializationEvent(InitializationEvent event) {
        DatabaseManager database = pool.getDatabase();
        database.setDataSchema(config.get().schema);

        (hive = new DatabaseHive(database)).load();
        (bans = new DatabaseBans(database)).load();
        (parties = new DatabaseParties(database)).load();

        services.register(Hive.class, hive);
        services.register(BanManager.class, bans);
        services.register(PartyManager.class, parties);
    }

    private static class ServicesConfig {
        @Setting(comment = "The schema/database name for the user/bans/etc. tables")
        private String schema = "plume_data";
    }

}