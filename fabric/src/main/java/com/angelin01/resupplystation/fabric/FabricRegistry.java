package com.angelin01.resupplystation.fabric;

import com.angelin01.resupplystation.ResupplyStation;
import com.angelin01.resupplystation.block.ResupplyStationBlock;
import com.angelin01.resupplystation.block.entity.ResupplyStationBlockEntity;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class FabricRegistry {
	public static final ResupplyStationBlock RESUPPLY_STATION = Registry.register(
		BuiltInRegistries.BLOCK,
		ResourceLocation.fromNamespaceAndPath(ResupplyStation.MOD_ID, ResupplyStationBlock.ID),
		ResupplyStationBlock.create()
	);

	public static final BlockItem RESUPPLY_STATION_ITEM = Registry.register(
		BuiltInRegistries.ITEM,
		ResourceLocation.fromNamespaceAndPath(ResupplyStation.MOD_ID, ResupplyStationBlock.ID),
		new BlockItem(RESUPPLY_STATION, new Item.Properties())
	);

	public static final BlockEntityType<ResupplyStationBlockEntity> RESUPPLY_STATION_ENTITY_TYPE = Registry.register(
		BuiltInRegistries.BLOCK_ENTITY_TYPE,
		ResourceLocation.fromNamespaceAndPath(ResupplyStation.MOD_ID, ResupplyStationBlock.ID),
		BlockEntityType.Builder.<ResupplyStationBlockEntity>of(ResupplyStationBlockEntity::new, RESUPPLY_STATION).build(null)
	);

	public static void register() {
		// Static initializer touch
	}
}
