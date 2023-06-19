package io.github.codecraftplugin.registrylib;

import io.github.codecraftplugin.registrylib.utils.Registry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RegisteryLib implements ModInitializer {
    public static final String  MOD_ID = "registry";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final RegistryKey<ItemGroup> ITEM_GROUP  = Registry.registerItemGroup("registry_item_group",MOD_ID,()-> new ItemStack(Items.CANDLE));

    @Override
    public void onInitialize() {
        Item x = Registry.registerItems("test",MOD_ID,new Item(new FabricItemSettings()),ITEM_GROUP);

    }
}
