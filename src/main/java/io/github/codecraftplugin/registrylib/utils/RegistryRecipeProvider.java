package io.github.codecraftplugin.registrylib.utils;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.function.Consumer;

public class RegistryRecipeProvider {

    /**
     * for making an Axe recipe
     * @param exporter the exporter
     * @param output the output that is the axe
     * @param input the material the axe is made up of (wood, stone, iron, gold, diamond, any modded material)
     */

    public static void offerAxeRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output).input(Character.valueOf('#'), input).input('S', Items.STICK)
                .pattern("## ")
                .pattern("#S ")
                .pattern(" S ")
                .group("axe")
                .criterion(FabricRecipeProvider.hasItem(input),
                FabricRecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }
    /**
     * for making a Pickaxe recipe
     * @param exporter the exporter
     * @param output the output that is the pickaxe
     * @param input the material the pickaxe is made up of (wood, stone, iron, gold, diamond, any modded material)
     */
    public static void offerPickaxeRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output).input(Character.valueOf('#'), input).input('S', Items.STICK)
                .pattern("###")
                .pattern(" S ").pattern(" S ")
                .group("pickaxe")
                .criterion(FabricRecipeProvider.hasItem(input),
                FabricRecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }
    /**
     * for making a Hoe recipe
     * @param exporter the exporter
     * @param output the output that is the Hoe
     * @param input the material the Hoe is made up of (wood, stone, iron, gold, diamond, any modded material)
     */

    public static void offerHoeRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output).input(Character.valueOf('#'), input).input('S', Items.STICK)
                .pattern("## ")
                .pattern(" S ")
                .pattern(" S ")
                .group("hoe").criterion(FabricRecipeProvider.hasItem(input),
                FabricRecipeProvider.conditionsFromItem(input))
                .offerTo(exporter);
    }/**
     * for making an Shovel recipe
     * @param exporter the exporter
     * @param output the output that is the Shovel
     * @param input the material the Shovel is made up of (wood, stone, iron, gold, diamond, any modded material)
     */

    public static void offerShovelRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output).input(Character.valueOf('#'), input).input('S', Items.STICK)
                .pattern(" # ")
                .pattern(" S ")
                .pattern(" S ")
                .group("shovel")
                .criterion(FabricRecipeProvider.hasItem(input),
                FabricRecipeProvider.conditionsFromItem(input))
                .offerTo(exporter);
    }
    /**
     * for making a Sword recipe
     * @param exporter the exporter
     * @param output the output that is the Sword
     * @param input the material the Sword is made up of (wood, stone, iron, gold, diamond, any modded material)
     */
    public static void offerSwordRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output).input(Character.valueOf('#'), input).input('S', Items.STICK)
                .pattern(" # ")
                .pattern(" # ")
                .pattern(" S ")
                .criterion(FabricRecipeProvider.hasItem(input),
                FabricRecipeProvider.conditionsFromItem(input))
                .group("sword").offerTo(exporter);
    }

    /**
     * for making a Chestplate recipe
     * @param exporter the expoter
     * @param output the output that is the Chestplate
     * @param input the material the Chestplate is made up of (wood, stone, iron, gold, diamond, any modded material)
     */
    public static void offerChestplateRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output).input(Character.valueOf('#'), input)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .criterion(FabricRecipeProvider.hasItem(input),
                        FabricRecipeProvider.conditionsFromItem(input))
                .group("chestplate").offerTo(exporter);
    }
    /**
     * for making a Boots recipe
     * @param exporter the exporter
     * @param output the output that is the Boots
     * @param input the material the Boots is made up of (wood, stone, iron, gold, diamond, any modded material)
     */
    public static void offerBootsRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output).input(Character.valueOf('#'), input)
                .pattern("   ")
                .pattern("# #")
                .pattern("# #")
                .criterion(FabricRecipeProvider.hasItem(input),
                        FabricRecipeProvider.conditionsFromItem(input))
                .group("boots").offerTo(exporter);
    }
    /**
     * for making a Leggings recipe
     * @param exporter the exporter
     * @param output the output that is the Leggings
     * @param input the material the Leggings is made up of (wood, stone, iron, gold, diamond, any modded material)
     */
    public static void offerLeggingsRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output).input(Character.valueOf('#'), input)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .criterion(FabricRecipeProvider.hasItem(input),
                        FabricRecipeProvider.conditionsFromItem(input))
                .group("leggings").offerTo(exporter);
    }
    /**
     * for making a Helmet recipe
     * @param exporter the exporter
     * @param output the output that is the Helmet
     * @param input the material the Helmet is made up of (wood, stone, iron, gold, diamond, any modded material)
     */
    public static void offerHelmetRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output).input(Character.valueOf('#'), input)
                .pattern("###")
                .pattern("# #")
                .pattern("   ")
                .criterion(FabricRecipeProvider.hasItem(input),
                        FabricRecipeProvider.conditionsFromItem(input))
                .group("helmet").offerTo(exporter);
    }
}
