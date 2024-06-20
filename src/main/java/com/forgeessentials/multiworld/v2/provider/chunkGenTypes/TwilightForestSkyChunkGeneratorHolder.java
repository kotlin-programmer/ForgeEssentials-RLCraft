package com.forgeessentials.multiworld.v2.provider.chunkGenTypes;

import java.util.function.Supplier;

import com.forgeessentials.multiworld.v2.provider.ChunkGeneratorHolderBase;
import com.forgeessentials.multiworld.v2.provider.FEChunkGenProvider;
import com.forgeessentials.multiworld.v2.provider.ProvidersReflection;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.structure.StructureSet;

@FEChunkGenProvider(providerName = "twilightforest:sky_noise")
public class TwilightForestSkyChunkGeneratorHolder extends ChunkGeneratorHolderBase {
	@Override
	public ChunkGenerator createChunkGenerator(Registry<Biome> biomes, Registry<StructureSet> structureSets, long seed, BiomeSource biome,
			Holder<NoiseGeneratorSettings> dimSettings) {
		return ProvidersReflection.getChunkProvider(getClassName(),
				new Class<?>[] { BiomeSource.class, long.class, Supplier.class },
				new Object[] { biome, seed, dimSettings });
	}

	@Override
	public String getClassName() {
		return "twilightforest.world.ChunkGeneratorTwilightSky";
	}
}
