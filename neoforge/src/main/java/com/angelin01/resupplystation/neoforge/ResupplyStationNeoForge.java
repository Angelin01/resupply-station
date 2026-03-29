package com.angelin01.resupplystation.neoforge;

import com.angelin01.resupplystation.CommonRegistry;
import com.angelin01.resupplystation.ResupplyStation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(ResupplyStation.MOD_ID)
public final class ResupplyStationNeoForge {
	public ResupplyStationNeoForge(IEventBus modBus) {
		NeoforgeRegistry.registerEvents(modBus);
		CommonRegistry.RESUPPLY_STATION = NeoforgeRegistry.RESUPPLY_STATION_ENTITY_TYPE;

		ResupplyStation.init();
	}
}
