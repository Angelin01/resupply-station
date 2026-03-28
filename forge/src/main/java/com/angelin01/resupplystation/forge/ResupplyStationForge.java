package com.angelin01.resupplystation.forge;

import com.angelin01.resupplystation.ResupplyStation;

import net.minecraftforge.fml.common.Mod;

@Mod(ResupplyStation.MOD_ID)
public final class ResupplyStationForge {
    public ResupplyStationForge() {
	    ResupplyStation.init();
    }
}
