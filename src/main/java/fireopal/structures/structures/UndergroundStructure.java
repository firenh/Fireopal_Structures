package fireopal.structures.structures;

import java.util.Random;

import com.mojang.serialization.Codec;
import fireopal.structures.structures.config.UndergroundStructureConfig;
import net.minecraft.block.BlockState;
import net.minecraft.structure.MarginedStructureStart;
import net.minecraft.structure.StructureManager;
import net.minecraft.structure.pool.StructurePoolBasedGenerator;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.registry.DynamicRegistryManager;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.HeightLimitView;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.gen.ChunkRandom;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.VerticalBlockSample;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;
import net.minecraft.structure.PoolStructurePiece;

public class UndergroundStructure extends StructureFeature<UndergroundStructureConfig> {

    public UndergroundStructure(Codec<UndergroundStructureConfig> codec) {
        super(codec);
    }

    @Override
    public StructureStartFactory<UndergroundStructureConfig> getStructureStartFactory() {
        return UndergroundStructure.Start::new;
    }

    @Override
    public boolean shouldStartAt(ChunkGenerator chunkGenerator, BiomeSource biomeSource, long seed, ChunkRandom chunkRandom, ChunkPos chunkPos, Biome biome, ChunkPos chunkPos2, UndergroundStructureConfig config, HeightLimitView heightLimitView) {
        return true;
    }

    public static class Start extends MarginedStructureStart<UndergroundStructureConfig> {
        public Start(StructureFeature<UndergroundStructureConfig> structureIn, ChunkPos chunkPos, int referenceIn, long seedIn) {
            super(structureIn, chunkPos, referenceIn, seedIn);
        }

        @Override
        public void init(DynamicRegistryManager dynamicRegistryManager, ChunkGenerator chunkGenerator, StructureManager structureManager, ChunkPos chunkPos, Biome biome, UndergroundStructureConfig config, HeightLimitView heightLimitView) {
            Random random = this.random;
            Identifier jigsawPool = config.identifier();

            int x = chunkPos.x * 16;
            int z = chunkPos.z * 16;

            int minY = config.range().getMin();
            int maxY = config.range().getMax();

            int landHeight = chunkGenerator.getHeightInGround(x, z, Heightmap.Type.WORLD_SURFACE_WG, heightLimitView);
            int randomUpperBound = maxY > landHeight ? landHeight : maxY;

            int y = random.nextInt(randomUpperBound - minY) + minY;

            BlockPos centerPos = new BlockPos(x, y, z);
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
                false,
                heightLimitView
            );
        }
    }
}
