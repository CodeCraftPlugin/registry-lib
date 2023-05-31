package io.github.codecraftplugin.registrylib.utils;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
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
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;

import java.util.function.Supplier;


public class Registry {
    /**
     * Register items item.
     *
     * @param name      the name of the item
     * @param MOD_ID    the mod id of your mod
     * @param item      the item settings
     * @param itemGroup the item group
     * @return the item will be created and returned
     */
    public static Item registerItems(String name, String MOD_ID, Item item, ItemGroup itemGroup){
        Item createditem = net.minecraft.registry.Registry.register(Registries.ITEM,new Identifier(MOD_ID,name),item);
        addToItemGroup(itemGroup,createditem);
        return createditem;
    }
    /**
     * Register items item.
     *
     * @param name      the name of the item
     * @param MOD_ID    the mod id of your mod
     * @param block      the block settings
     * @return the block and the block item  will be created and returned
     */
    public static Block registerBlocks(String name, String MOD_ID, Block block, ItemGroup itemGroup){
        registerBlockItem(name,MOD_ID,block,itemGroup);
        return net.minecraft.registry.Registry.register(Registries.BLOCK,new Identifier(MOD_ID,name),block);
    }

    /**
     *
     * @param name the name of the item
     * @param MOD_ID the Mod id of your mod
     * @param block the reference of the block this item is for
     * @param itemGroup the item group that the block item will be shown
     * @return the block item without creating the block (for crops)
     */
    public static Item registerBlockItem(String name, String MOD_ID, Block block, ItemGroup itemGroup) {
        Item blockItem =  net.minecraft.registry.Registry.register(Registries.ITEM,new Identifier(MOD_ID,name),
                new BlockItem(block,new FabricItemSettings()));
        addToItemGroup(itemGroup,blockItem);
        return blockItem;
    }

    /**
     *
     * @param name the name of the group make sure the name is same the name you want to be displayed in the game
     * @param MOD_ID the mod id of your mod
     * @param itemStack the item that you want to use as the icon as an item stack e.g. new ItemStack(Items.APPLE);
     * @return the item group
     */
    public static ItemGroup registerItemGroup(String name, String MOD_ID, Supplier<ItemStack> itemStack){
        String formattedName = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        return FabricItemGroup.builder(new Identifier(MOD_ID,name)).displayName(Text.literal(formattedName)).icon(itemStack).build();
    }
    //Adds Group to the items created

    /**
     * Add an item to an item group
     * @param group reference of the item Group
     * @param item reference of the item
     */
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

    /**
     * Register enchantments enchantment.
     *
     * @param name        the name of the enchantment
     * @param enchantment the enchantment settings
     * @param MOD_ID      the mod id of your mod
     * @return the enchantment
     */
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

    /**
     * Register status effects status effect.
     *
     * @param name         the name of the status effect / potion effect
     * @param MOD_ID       the mod id of your mod
     * @param statusEffect the status effect settings
     * @return the status effect
     */
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