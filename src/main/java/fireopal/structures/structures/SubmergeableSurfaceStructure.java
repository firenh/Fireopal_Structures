package fireopal.structures.structures;

import java.util.Random;

import com.mojang.serialization.Codec;

import fireopal.structures.structures.config.SubmergeableSurfaceStructureConfig;
import net.minecraft.structure.MarginedStructureStart;
import net.minecraft.structure.StructureManager;
import net.minecraft.structure.pool.StructurePoolBasedGenerator;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.registry.DynamicRegistryManager;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.HeightLimitView;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.gen.ChunkRandom;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;
import net.minecraft.structure.PoolStructurePiece;

public class SubmergeableSurfaceStructure extends StructureFeature<SubmergeableSurfaceStructureConfig> {

    public SubmergeableSurfaceStructure(Codec<SubmergeableSurfaceStructureConfig> codec) {
        super(codec);
    }

    @Override
    public StructureStartFactory<SubmergeableSurfaceStructureConfig> getStructureStartFactory() {
        return SubmergeableSurfaceStructure.Start::new;
    }

    @Override
    public boolean shouldStartAt(ChunkGenerator chunkGenerator, BiomeSource biomeSource, long seed, ChunkRandom chunkRandom, ChunkPos chunkPos, Biome biome, ChunkPos chunkPos2, SubmergeableSurfaceStructureConfig config, HeightLimitView heightLimitView) {
        return true;
    }

    public static class Start extends MarginedStructureStart<SubmergeableSurfaceStructureConfig> {
        public Start(StructureFeature<SubmergeableSurfaceStructureConfig> structureIn, ChunkPos chunkPos, int referenceIn, long seedIn) {
            super(structureIn, chunkPos, referenceIn, seedIn);
        }

        @Override
        public void init(DynamicRegistryManager dynamicRegistryManager, ChunkGenerator chunkGenerator, StructureManager structureManager, ChunkPos chunkPos, Biome biome, SubmergeableSurfaceStructureConfig config, HeightLimitView heightLimitView) {
            Random random = this.random;
            
            Identifier jigsawPool = config.identifier();
            
            int x = chunkPos.x * 16;
            int z = chunkPos.z * 16;
            BlockPos.Mutable centerPos = new BlockPos.Mutable(x, (double) (config.verticalOffset().get(random)), z);
            StructurePoolFeatureConfig structureSettingsAndStartPool = new StructurePoolFeatureConfig(() -> dynamicRegistryManager.get(Registry.STRUCTURE_POOL_KEY)
                    .get(jigsawPool),
                    10);

            StructurePoolBasedGenerator.generate(
                dynamicRegistryManager,
                structureSettingsAndStartPool,
                PoolStructurePiece::new,
                chunkGenerator,
                structureManager,
                centerPos,
                this,
                this.random,
                false,
                true,
                heightLimitView
            );
        }
    }
}

