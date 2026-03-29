package com.angelin01.resupplystation.block.entity;

import com.angelin01.resupplystation.CommonRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ResupplyStationBlockEntity extends BlockEntity {
	public ResupplyStationBlockEntity(BlockPos blockPos, BlockState state) {
		super(CommonRegistry.RESUPPLY_STATION.get(), blockPos, state);
	}
}
