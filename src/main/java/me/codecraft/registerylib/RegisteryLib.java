package me.codecraft.registerylib;

import me.codecraft.registerylib.utils.Registry;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegisteryLib implements ModInitializer {
    public static final String  MOD_ID = "registry";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    @Override
    public void onInitialize() {
        Registry.registerRegistry();
    }
}
