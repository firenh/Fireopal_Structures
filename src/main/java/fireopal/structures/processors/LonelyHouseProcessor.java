/*package fireopal.structures.processors;

import net.minecraft.structure.Structure.StructureBlockInfo;

import java.util.Random;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import fireopal.structures.FORegister;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.structure.Structure;
import net.minecraft.structure.StructurePlacementData;
import net.minecraft.structure.processor.StructureProcessor;
import net.minecraft.structure.processor.StructureProcessorType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;

public class LonelyHouseProcessor extends StructureProcessor {
    public static final Codec<LonelyHouseProcessor> CODEC = RecordCodecBuilder.create((proc) -> proc.group(
        Codec.FLOAT.fieldOf("randomValue").forGetter(processor -> processor.randomValue)
    ).apply(proc, LonelyHouseProcessor::new));

    float randomValue = random.nextFloat();



    @Override
    public StructureBlockInfo process(WorldView world, BlockPos pos, BlockPos pivot, StructureBlockInfo structureBlockInfo, StructureBlockInfo structureBlockInfo2, StructurePlacementData data) {
        Random random = data.getRandom(structureBlockInfo2.pos);
        BlockState blockState = structureBlockInfo2.state;
        BlockPos blockPos2 = structureBlockInfo2.pos;
        BlockState blockState2 = blockState;

        int foundationType = random.nextInt(3);

        if (blockState.isOf(Blocks.STONE_BRICKS)) {


            switch(foundationType) {
                case 0:
                    break;
                default:
                    if (randomValue < 0.3) {
                        blockState2 = Blocks.MOSSY_STONE_BRICKS.getDefaultState();
                    } else if (randomValue > 0.9) {
                        blockState2 = Blocks.CRACKED_STONE_BRICKS.getDefaultState();
                    };
                    break;
            }
        };

        return new Structure.StructureBlockInfo(blockPos2, blockState2, structureBlockInfo2.nbt);
    }

    @Override
    protected StructureProcessorType<?> getType() {
        return FORegister.LONELY_HOUSE_PROCESSOR;
    }
    
}


*/