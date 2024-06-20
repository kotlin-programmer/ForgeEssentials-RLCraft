package com.forgeessentials.multiworld.v2.provider.chunkGenTypes;

import com.forgeessentials.multiworld.v2.provider.ChunkGeneratorHolderBase;
import com.forgeessentials.multiworld.v2.provider.FEChunkGenProvider;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.DebugLevelSource;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.structure.StructureSet;

@FEChunkGenProvider(providerName = "minecraft:debug")
public class MinecraftDebugChunkGeneratorHolder extends ChunkGeneratorHolderBase {
	@Override
	public ChunkGenerator createChunkGenerator(Registry<Biome> biomes, Registry<StructureSet> structureSets, long seed, BiomeSource biome,
			Holder<NoiseGeneratorSettings> dimSettings) {
		return new DebugLevelSource(structureSets, biomes);
	}

	@Override
	public String getClassName() {
		return "net.minecraft.world.gen.DebugChunkGenerator";
	}
}
