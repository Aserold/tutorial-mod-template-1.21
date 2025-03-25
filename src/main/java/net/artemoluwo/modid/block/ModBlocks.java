package net.artemoluwo.modid.block;

import net.artemoluwo.modid.TutorialMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block PINK_GARNET_BLOCK = registerBlock(
            "pink_garnet_block",
            new Block(
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.PURPLE)
                            .instrument(NoteBlockInstrument.FLUTE)
                            .requiresTool()
                            .strength(4f, 4f)
                            .sounds(BlockSoundGroup.AMETHYST_BLOCK)
            )
    );

    public static final Block RAW_PINK_GARNET_BLOCK = registerBlock(
            "raw_pink_garnet_block",
            new ExperienceDroppingBlock(
                    UniformIntProvider.create(3, 7),
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.PURPLE)
                            .instrument(NoteBlockInstrument.FLUTE)
                            .requiresTool()
                            .strength(5f, 6f)
                            .sounds(BlockSoundGroup.TUFF)
            )
    );

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(TutorialMod.MOD_ID, name), block);
    }

    public static void RegisterModBlocks() {
        TutorialMod.LOGGER.info("Registering Mod BLOCKS for " + TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> entries.add(ModBlocks.PINK_GARNET_BLOCK));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK));
    }
}
