package com.angelin01.resupplystation;

import com.angelin01.resupplystation.block.entity.ResupplyStationBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class CommonRegistry {
	public static Supplier<BlockEntityType<ResupplyStationBlockEntity>> RESUPPLY_STATION;
}
