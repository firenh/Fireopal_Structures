package fireopal.structures.structures;

import java.util.Random;

import com.mojang.serialization.Codec;
import fireopal.structures.structures.config.SurfaceStructureConfig;
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

public class SurfaceStructure extends StructureFeature<SurfaceStructureConfig> {

    public SurfaceStructure(Codec<SurfaceStructureConfig> codec) {
        super(codec);
    }

    @Override
    public StructureStartFactory<SurfaceStructureConfig> getStructureStartFactory() {
        return SurfaceStructure.Start::new;
    }

    @Override
    public boolean shouldStartAt(ChunkGenerator chunkGenerator, BiomeSource biomeSource, long seed, ChunkRandom chunkRandom, ChunkPos chunkPos, Biome biome, ChunkPos chunkPos2, SurfaceStructureConfig config, HeightLimitView heightLimitView) {
        BlockPos centerOfChunk = new BlockPos(chunkPos.x * 16, 0, chunkPos.z * 16);
        int landHeight = chunkGenerator.getHeightInGround(centerOfChunk.getX(), centerOfChunk.getZ(), Heightmap.Type.WORLD_SURFACE_WG, heightLimitView);
        VerticalBlockSample columnOfBlocks = chunkGenerator.getColumnSample(centerOfChunk.getX(), centerOfChunk.getZ(), heightLimitView);
        BlockState topBlock = columnOfBlocks.getState(centerOfChunk.up(landHeight));
        return topBlock.getFluidState().isEmpty();
    }

    public static class Start extends MarginedStructureStart<SurfaceStructureConfig> {
        public Start(StructureFeature<SurfaceStructureConfig> structureIn, ChunkPos chunkPos, int referenceIn, long seedIn) {
            super(structureIn, chunkPos, referenceIn, seedIn);
        }

        @Override
        public void init(DynamicRegistryManager dynamicRegistryManager, ChunkGenerator chunkGenerator, StructureManager structureManager, ChunkPos chunkPos, Biome biome, SurfaceStructureConfig config, HeightLimitView heightLimitView) {
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

