/*package fireopal.structures.processors;

import net.minecraft.structure.Structure.StructureBlockInfo;

import java.util.Random;

import com.google.common.collect.ImmutableList;

import fireopal.structures.FORegister;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.structure.Structure;
import net.minecraft.structure.StructurePlacementData;
import net.minecraft.structure.processor.StructureProcessor;
import net.minecraft.structure.processor.StructureProcessorType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;
import static fireopal.structures.processors.BlockProcessorEntry.blockProcessorEntry;

public class GeneralBlockDecayProcessor extends StructureProcessor {

    @Override
    public StructureBlockInfo process(WorldView world, BlockPos pos, BlockPos pivot, StructureBlockInfo structureBlockInfo, StructureBlockInfo structureBlockInfo2, StructurePlacementData data) {
        
        Random random = data.getRandom(structureBlockInfo2.pos);
        BlockState blockState = structureBlockInfo2.state;
        BlockPos blockPos2 = structureBlockInfo2.pos;
        BlockState blockState2 = blockState;

        for (BlockProcessorEntry b : PROCESSOR_ENTRIES) {
            if (blockState.isOf(b.getTargetBlock())) {
                blockState2 = b.getPossibleBlock(random);
            }
        }

        return new Structure.StructureBlockInfo(blockPos2, blockState2, structureBlockInfo2.nbt);
    }

    @Override
    protected StructureProcessorType<?> getType() {
        return FORegister.GENERAL_BLOCK_DECAY_PROCESSOR;
    }

    private static final ImmutableList<BlockProcessorEntry> PROCESSOR_ENTRIES = ImmutableList.of(
        blockProcessorEntry(Blocks.STONE_BRICKS, 0.5, Blocks.CRACKED_STONE_BRICKS.getDefaultState(), Blocks.MOSSY_STONE_BRICKS.getDefaultState()),
        blockProcessorEntry(Blocks.COBBLESTONE, 0.5, Blocks.MOSSY_COBBLESTONE.getDefaultState()),
        blockProcessorEntry(Blocks.POLISHED_BLACKSTONE_BRICKS, 0.5, Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS.getDefaultState(), Blocks.BLACKSTONE.getDefaultState()),
        blockProcessorEntry(Blocks.POLISHED_BLACKSTONE, 0.2, Blocks.BLACKSTONE.getDefaultState()),
        blockProcessorEntry(Blocks.POLISHED_ANDESITE, 0.5, Blocks.ANDESITE.getDefaultState()),
        blockProcessorEntry(Blocks.POLISHED_DIORITE, 0.5, Blocks.DIORITE.getDefaultState()),
        blockProcessorEntry(Blocks.POLISHED_GRANITE, 0.5, Blocks.GRANITE.getDefaultState())
        );
}


*/