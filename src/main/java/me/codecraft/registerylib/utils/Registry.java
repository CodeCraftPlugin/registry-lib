package me.codecraft.registerylib.utils;

import me.codecraft.registerylib.RegisteryLib;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;

public class Registry {
    public static Item registerItems(String name, String MOD_ID, Item item){
        return net.minecraft.util.registry.Registry.register(net.minecraft.util.registry.Registry.ITEM,new Identifier(MOD_ID,name),item);
    }
    public static Block registerBlocks(String name, String MOD_ID, Block block, ItemGroup itemGroup){
        registerBlockItem(name,MOD_ID,block,itemGroup);
        return net.minecraft.util.registry.Registry.register(net.minecraft.util.registry.Registry.BLOCK,new Identifier(MOD_ID,name),block);
    }
    public static Item registerBlockItem(String name, String MOD_ID, Block block, ItemGroup itemGroup) {
        return net.minecraft.util.registry.Registry.register(net.minecraft.util.registry.Registry.ITEM,new Identifier(MOD_ID,name),
                new BlockItem(block,new FabricItemSettings().group(itemGroup)));
    }


    /**
     * Register blocks without block item block.
     *
     * @param name   the name
     * @param MOD_ID the mod id
     * @param block  the block
     * @return the block
     */
    public static Block registerBlocksWithoutBlockItem(String name, String MOD_ID, Block block){
        //register the block without block items so you have to register it manually using registerItems
        return net.minecraft.util.registry.Registry.register(net.minecraft.util.registry.Registry.BLOCK,new Identifier(MOD_ID,name),block);
    }
    public static void registerRegistry(){
        RegisteryLib.LOGGER.info("registered all the registry");
    }
}
