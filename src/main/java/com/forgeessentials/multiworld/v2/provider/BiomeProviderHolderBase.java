package com.forgeessentials.multiworld.v2.provider;

import net.minecraft.core.Registry;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.levelgen.structure.StructureSet;

public abstract class BiomeProviderHolderBase {
	public abstract BiomeSource createBiomeProvider(Registry<Biome> biomes, Registry<StructureSet> structureSets, long seed);
	public abstract String getClassName();
}
