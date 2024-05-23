package com.zuzu.moremoss;

import com.zuzu.moremoss.item.ModItems;
import com.zuzu.moremoss.config.ConfigLoader;
import net.fabricmc.api.ModInitializer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoreMoss implements ModInitializer {
	public static final String MOD_ID = "moremoss";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ConfigLoader.loadConversions();
		ModItems.registerModItems();
	}
}