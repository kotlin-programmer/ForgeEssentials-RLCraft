package com.forgeessentials.multiworld.v2.provider.chunkGenTypes;

import com.forgeessentials.multiworld.v2.provider.ChunkGeneratorHolderBase;
import com.forgeessentials.multiworld.v2.provider.FEChunkGenProvider;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import net.minecraftforge.server.ServerLifecycleHooks;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;

@FEChunkGenProvider(providerName = "minecraft:noise")
public class MinecraftNoiseChunkGeneratorHolder extends ChunkGeneratorHolderBase {
	@Override
	public ChunkGenerator createChunkGenerator(Registry<Biome> biomes, Registry<StructureSet> structureSets, long seed, BiomeSource biome,
			Holder<NoiseGeneratorSettings> dimSettings) {
		Registry<NormalNoise.NoiseParameters> registry4 = ServerLifecycleHooks.getCurrentServer().registryAccess().registryOrThrow(Registry.NOISE_REGISTRY);
		return new NoiseBasedChunkGenerator(structureSets, registry4, biome, seed, dimSettings);
	}

	@Override
	public String getClassName() {
		return "net.minecraft.world.level.levelgen.NoiseChunkGenerator";
	}
}
