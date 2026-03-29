package com.angelin01.resupplystation.neoforge;

import com.angelin01.resupplystation.ResupplyStation;
import com.angelin01.resupplystation.block.ResupplyStationBlock;
import com.angelin01.resupplystation.block.entity.ResupplyStationBlockEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class NeoforgeRegistry {
	private static final DeferredRegister.Blocks BLOCKS = DeferredRegister.Blocks.createBlocks(ResupplyStation.MOD_ID);
	private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
		DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, ResupplyStation.MOD_ID);
	private static final DeferredRegister.Items ITEMS = DeferredRegister.Items.createItems(ResupplyStation.MOD_ID);

	public static final DeferredBlock<Block> RESUPPLY_STATION = NeoforgeRegistry.BLOCKS.register(ResupplyStationBlock.ID, ResupplyStationBlock::create);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ResupplyStationBlockEntity>> RESUPPLY_STATION_ENTITY_TYPE =
		NeoforgeRegistry.registerBlockEntity(ResupplyStationBlock.ID, ResupplyStationBlockEntity::new, NeoforgeRegistry.RESUPPLY_STATION);

	public static final DeferredItem<BlockItem> RESUPPLY_STATION_ITEM =
		NeoforgeRegistry.ITEMS.registerSimpleBlockItem(ResupplyStationBlock.ID, NeoforgeRegistry.RESUPPLY_STATION);

	public static void registerEvents(IEventBus modBus) {
		NeoforgeRegistry.BLOCKS.register(modBus);
		NeoforgeRegistry.BLOCK_ENTITIES.register(modBus);
		NeoforgeRegistry.ITEMS.register(modBus);
	}

	private static <T extends BlockEntity> DeferredHolder<BlockEntityType<?>, BlockEntityType<T>> registerBlockEntity(
		String id,
		BlockEntityType.BlockEntitySupplier<T> supplier,
		DeferredBlock<Block> deferredBlock
	) {
		Supplier<BlockEntityType<T>> sup = () -> BlockEntityType.Builder.of(supplier, deferredBlock.get()).build(null);
		return NeoforgeRegistry.BLOCK_ENTITIES.register(id, sup);
	}
}
