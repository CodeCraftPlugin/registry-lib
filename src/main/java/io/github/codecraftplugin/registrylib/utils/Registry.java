package io.github.codecraftplugin.registrylib.utils;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;


public class Registry {


    public static Item registerItems(String name, String MOD_ID, Item item, ItemGroup itemGroup){
        Item createditem = net.minecraft.registry.Registry.register(Registries.ITEM,new Identifier(MOD_ID,name),item);
        addToItemGroup(itemGroup,createditem);
        return createditem;
    }
    public static Block registerBlocks(String name, String MOD_ID, Block block, ItemGroup itemGroup){
        registerBlockItem(name,MOD_ID,block,itemGroup);
        return net.minecraft.registry.Registry.register(Registries.BLOCK,new Identifier(MOD_ID,name),block);
    }
    public static Item registerBlockItem(String name, String MOD_ID, Block block, ItemGroup itemGroup) {
        return net.minecraft.registry.Registry.register(Registries.ITEM,new Identifier(MOD_ID,name),
                new BlockItem(block,new FabricItemSettings()));
    }
    //Adds Group to the items created

    public static void addToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
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
        return net.minecraft.registry.Registry.register(Registries.BLOCK,new Identifier(MOD_ID,name),block);
    }

    //register enchantments
    public static Enchantment registerEnchantments(String name, Enchantment enchantment, String MOD_ID){
        return net.minecraft.registry.Registry.register(Registries.ENCHANTMENT, new Identifier(MOD_ID, name),enchantment);

    }

    /**
     * Register fluids .
     * @param name
     * @param MOD_ID
     * @param flowableFluid
     * @return
     */
    private static FlowableFluid registerFluids(String name, String MOD_ID,FlowableFluid flowableFluid) {
        return net.minecraft.registry.Registry.register(Registries.FLUID, new Identifier(MOD_ID, name), flowableFluid);
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
        return net.minecraft.registry.Registry.register(Registries.ENTITY_TYPE, new Identifier(MOD_ID,name),entity);
    }
    //register status effects
    public static StatusEffect registerStatusEffects(String name,String MOD_ID, StatusEffect statusEffect){
        return net.minecraft.registry.Registry.register(Registries.STATUS_EFFECT, new Identifier(MOD_ID, name), statusEffect);
    }
    //register entities with spawn egg
    public static <T extends Entity> EntityType<T> buildEntity(EntityType.EntityFactory<T> entity, Class<T> entityClass,
                                                               float width, float height, SpawnGroup group, String MOD_ID) {
        if (FabricLoader.getInstance().isDevelopmentEnvironment()) {
            String name = entityClass.getSimpleName().toLowerCase();
            return EntityRegistryBuilder.<T>createBuilder(new Identifier(MOD_ID, name)).entity(entity)
                    .category(group).dimensions(EntityDimensions.changing(width, height)).build();
        }
        return null;
    }
    //register spawn egg without entity

    /**
     * Register spawn egg without entity.
     * @param item
     * @param name
     * @return
     * @param <I>
     */
    public static <I extends Item> I registerEgg(I item, Identifier name) {
        if (FabricLoader.getInstance().isDevelopmentEnvironment()) {
            return net.minecraft.registry.Registry.register(Registries.ITEM, name, item);
        }
        return null;
    }
    
}