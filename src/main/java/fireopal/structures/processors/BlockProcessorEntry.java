package fireopal.structures.processors;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;

public class BlockProcessorEntry {
    private Block targetBlock;
    private double chance;
    private BlockState[] possibleBlocks;

    public BlockProcessorEntry(Block targetBlock, double chance, BlockState... possibleBlocks) {
        this.targetBlock = targetBlock;
        this.chance = chance;
        this.possibleBlocks = possibleBlocks;
    }

    public Block getTargetBlock() {
        return targetBlock;
    }

    public BlockState getPossibleBlock(int index) {
        return possibleBlocks[index];
    }

    public BlockState getPossibleBlock(Random random) {
        if (random.nextDouble() <= chance) {
            return possibleBlocks[random.nextInt(possibleBlocks.length)];
        } else {
            return targetBlock.getDefaultState();
        }
    }

    public static BlockProcessorEntry blockProcessorEntry(Block targetBlock, double chance, BlockState... possibleBlocks) {
        return new BlockProcessorEntry(targetBlock, chance, possibleBlocks);
    }

}
