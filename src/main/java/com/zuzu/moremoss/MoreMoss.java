package com.zuzu.moremoss;

import com.zuzu.moremoss.block.ModBlocks;
import com.zuzu.moremoss.item.ModItems;
import com.zuzu.moremoss.config_loader.ConfigLoader;
import net.fabricmc.api.ModInitializer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoreMoss implements ModInitializer {
	public static final String MOD_ID = "moremoss";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Starting initialization for More Moss - Zuzu");

		ConfigLoader.loadConversions();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}
