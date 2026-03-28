package com.angelin01.resupplystation;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

public final class ResupplyStation {
	public static final String MOD_ID = "resupplystation";
	private static final Logger LOGGER = LogUtils.getLogger();

	public static void init() {
		ResupplyStation.LOGGER.info("Resupply Station stocking up");
	}
}
