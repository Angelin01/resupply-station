package com.angelin01.resupplystation.block;

import com.angelin01.resupplystation.block.entity.ResupplyStationBlockEntity;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ResupplyStationBlock extends BaseEntityBlock {
	public static final DirectionProperty FACING = BlockStateProperties.FACING;
	public static final BooleanProperty OPEN = BlockStateProperties.OPEN;
	public static final MapCodec<ResupplyStationBlock> CODEC = BlockBehaviour.simpleCodec(ResupplyStationBlock::new);
	public static final String ID = "resupplystation";

	public static ResupplyStationBlock create() {
		return new ResupplyStationBlock(BlockBehaviour.Properties.of()
			.mapColor(MapColor.WOOD)
			.strength(2.5F)
			.requiresCorrectToolForDrops()
			.sound(SoundType.WOOD)
			.instrument(NoteBlockInstrument.BASS)
			.ignitedByLava()
		);
	}

	public ResupplyStationBlock(BlockBehaviour.Properties properties) {
		super(properties);
	}

	@Override
	protected @NotNull InteractionResult useWithoutItem(BlockState blockState, Level level, BlockPos blockPos, Player player, BlockHitResult blockHitResult) {
		if (level.isClientSide) {
			return InteractionResult.SUCCESS;
		}

		if (level.getBlockEntity(blockPos) instanceof MenuProvider menu) {
			player.openMenu(menu);
		}

		return InteractionResult.CONSUME;
	}

	@Override
	protected @NotNull MapCodec<? extends BaseEntityBlock> codec() {
		return ResupplyStationBlock.CODEC;
	}

	@Override
	public @Nullable BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
		return new ResupplyStationBlockEntity(pos, state);
	}

	@Override
	protected @NotNull RenderShape getRenderShape(BlockState blockState) {
		return RenderShape.MODEL;
	}
}
