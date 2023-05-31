package io.github.codecraftplugin.registrylib;

import io.github.codecraftplugin.registrylib.utils.Registry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RegisteryLib implements ModInitializer {
    public static final String  MOD_ID = "registry";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    @Override
    public void onInitialize() {
        Item itemgroupicon = Registry.registerItems("itemgroupicon",MOD_ID,new Item(new FabricItemSettings()), ItemGroups.TOOLS);
        ItemGroup testitemgroup = Registry.registerItemGroup("testitemgroup",MOD_ID,()->new ItemStack(itemgroupicon));
        Item registeritem = Registry.registerItems("registeritem",MOD_ID,new Item(new FabricItemSettings()), testitemgroup);
    }
}
