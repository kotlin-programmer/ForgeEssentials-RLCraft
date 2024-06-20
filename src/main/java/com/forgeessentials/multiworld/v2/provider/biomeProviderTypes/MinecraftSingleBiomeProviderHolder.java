package com.forgeessentials.multiworld.v2.provider.biomeProviderTypes;

import com.forgeessentials.multiworld.v2.provider.BiomeProviderHolderBase;
import com.forgeessentials.multiworld.v2.provider.FEBiomeProvider;

import net.minecraft.core.Registry;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.FixedBiomeSource;
import net.minecraft.world.level.levelgen.structure.StructureSet;

@FEBiomeProvider(providerName = "minecraft:single")
public class MinecraftSingleBiomeProviderHolder extends BiomeProviderHolderBase {
	@Override
	public BiomeSource createBiomeProvider(Registry<Biome> biomes, Registry<StructureSet> structureSets, long seed) {
		return new FixedBiomeSource(biomes.getHolderOrThrow(Biomes.PLAINS));
	}

	@Override
	public String getClassName() {
		return FixedBiomeSource.class.getName();
	}
}
