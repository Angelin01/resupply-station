package com.angelin01.resupplystation.fabric;

import com.angelin01.resupplystation.CommonRegistry;
import com.angelin01.resupplystation.ResupplyStation;

import net.fabricmc.api.ModInitializer;

public final class ResupplyStationFabric implements ModInitializer {

	@Override
	public void onInitialize() {
		FabricRegistry.register();
		CommonRegistry.RESUPPLY_STATION = () -> FabricRegistry.RESUPPLY_STATION_ENTITY_TYPE;
		ResupplyStation.init();
	}
}
