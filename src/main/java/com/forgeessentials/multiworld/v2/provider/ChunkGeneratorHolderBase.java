package com.forgeessentials.multiworld.v2.provider;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.structure.StructureSet;

public abstract class ChunkGeneratorHolderBase {
	public abstract ChunkGenerator createChunkGenerator(Registry<Biome> biomes, Registry<StructureSet> structureSets, long seed, BiomeSource biome, Holder<NoiseGeneratorSettings> dimSettings);
	public abstract String getClassName();
}
