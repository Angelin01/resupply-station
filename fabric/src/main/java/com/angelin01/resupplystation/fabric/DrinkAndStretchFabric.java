package com.angelin01.resupplystation.fabric;

import com.angelin01.resupplystation.ResupplyStation;

import net.fabricmc.api.ModInitializer;

public final class DrinkAndStretchFabric implements ModInitializer {

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ResupplyStation.init();
	}
}
