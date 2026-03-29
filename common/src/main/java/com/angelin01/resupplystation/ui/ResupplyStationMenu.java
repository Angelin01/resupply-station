package com.angelin01.resupplystation.ui;

import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ResupplyStationMenu extends AbstractContainerMenu {
	private static final int LOADOUT_ROWS = 3;
	private static final int ROW_SIZE = 9;
	private static final int LOADOUT_SIZE = ROW_SIZE * LOADOUT_ROWS;

	private static final int SLOT_SIZE = 18;
	private static final int BORDER_OFFSET = 8;
	private static final int LOADOUT_TOP = 18;
	private static final int PLAYER_INVENTORY_TOP = 103;
	private static final int PLAYER_HOTBAR_TOP = 161;

	public ResupplyStationMenu(int containerId, Inventory playerInventory) {
		super(MenuType.GENERIC_9x3, containerId);

		Container loadout = new SimpleContainer(LOADOUT_SIZE);

		for (int row = 0; row < LOADOUT_ROWS; row++) {
			for (int col = 0; col < ROW_SIZE; col++) {
				this.addSlot(new Slot(loadout, col + row * ROW_SIZE, BORDER_OFFSET + col * SLOT_SIZE, LOADOUT_TOP + row * SLOT_SIZE));
			}
		}

		for (int row = 0; row < LOADOUT_ROWS; row++) {
			for (int col = 0; col < ROW_SIZE; col++) {
				this.addSlot(new Slot(playerInventory, col + row * ROW_SIZE + ROW_SIZE, BORDER_OFFSET + col * SLOT_SIZE, PLAYER_INVENTORY_TOP + row * SLOT_SIZE));
			}
		}

		for (int col = 0; col < ROW_SIZE; col++) {
			this.addSlot(new Slot(playerInventory, col, BORDER_OFFSET + col * SLOT_SIZE, PLAYER_HOTBAR_TOP));
		}
	}

	@Override
	public @NotNull ItemStack quickMoveStack(Player player, int index) {
		return ItemStack.EMPTY;
	}

	@Override
	public boolean stillValid(Player player) {
		return true;
	}
}
