package com.zuzu.moremoss.config_loader;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.zuzu.moremoss.MoreMoss;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.block.Block;

import java.io.InputStreamReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class ConfigLoader {
    private static final Map<Block, Block> conversions = new HashMap<>();

    public static void loadConversions() {
        try (InputStream inputStream = ConfigLoader.class.getResourceAsStream("/assets/moremoss/block_conversions.json")) {
            if (inputStream == null) {
                throw new IOException("Resource not found: block_conversions.json");
            }

            JsonObject configuration = JsonParser.parseReader(new InputStreamReader(inputStream)).getAsJsonObject();

            for (String key : configuration.keySet()) {
                Identifier sourceId = new Identifier(key);
                Identifier targetId = new Identifier(configuration.get(key).getAsString());

                Block sourceBlock = Registries.BLOCK.get(sourceId);
                Block targetBlock = Registries.BLOCK.get(targetId);

                conversions.put(sourceBlock, targetBlock);
            }

        } catch (IOException e) {
            MoreMoss.LOGGER.error(e.toString());
        }
    }

    public static Block getConversion(Block block) {
        return conversions.get(block);
    }
}