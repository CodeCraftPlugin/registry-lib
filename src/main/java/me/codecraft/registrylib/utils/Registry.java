package me.codecraft.registrylib.utils;

import me.codecraft.registrylib.RegisteryLib;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;


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
        //register the block without block items, so you have to register it manually using registerItems
        return net.minecraft.util.registry.Registry.register(net.minecraft.util.registry.Registry.BLOCK,new Identifier(MOD_ID,name),block);
    }


    public static Enchantment registerEnchantments(String name, Enchantment enchantment, String MOD_ID){
        return net.minecraft.util.registry.Registry.register(net.minecraft.util.registry.Registry.ENCHANTMENT, new Identifier(MOD_ID, name),enchantment);

    }
    private static FlowableFluid registerFluids(String name, String MOD_ID,FlowableFluid flowableFluid) {
        return net.minecraft.util.registry.Registry.register(net.minecraft.util.registry.Registry.FLUID, new Identifier(MOD_ID, name), flowableFluid);
    }
    public static void registerRegistry(Logger logger){
        logger.info("registered all the registry");
    }

    /**
     * Registery entity type.
     *
     * @param name   the name
     * @param MOD_ID the mod id
     * @param entity the entity
     * @return The Entity
     */
    public static EntityType registerEntity(String name,String MOD_ID, EntityType entity){
        return net.minecraft.util.registry.Registry.register(net.minecraft.util.registry.Registry.ENTITY_TYPE, new Identifier(MOD_ID,name),entity);
    }
    //write main method to test the code
    public static void main(String[] args) {
        System.out.printf("Hello World");
    }
}