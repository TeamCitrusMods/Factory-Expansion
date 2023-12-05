package dev.teamcitrusmods.factory_expansion.block.custom;

import dev.teamcitrusmods.factory_expansion.FactoryExpansion;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.Random;

public class BlastResultBlock extends Block {

    //this needs to be defined by the time super is called in the constructor
    public static final IntegerProperty VARIANT = IntegerProperty.create("variant", 0, 7);

    private final Block result;
    private final int maxVariants;

    //storing the max variants of this ver. and the block of the next (vanilla uses blockstates over blocks for this stuff idk why)
    public BlastResultBlock(Properties pProperties, int maxVariants, Block result) {
        super(pProperties);
        this.result = result;
        this.maxVariants = maxVariants;
        this.registerDefaultState(this.stateDefinition.any().setValue(VARIANT, 0)); //starting at 0 instead of 1 is generally better practice
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        int n = context.getLevel().random.nextInt(maxVariants);
        return this.defaultBlockState().setValue(VARIANT, n);
    }

    @Override
    public void wasExploded(Level level, @NotNull BlockPos pos, @NotNull Explosion explosion) {
        BlockState newState = result.defaultBlockState();
        //check if result block is a blast result block. If so, randomize the state
        if(result instanceof BlastResultBlock resultBlock) {
            int n = level.random.nextInt(resultBlock.getMaxVariants()); //get the max variants of our result block
            newState = newState.setValue(VARIANT, n); //you have to reassign values for blockstates because idk.
        }
        //set block
        level.setBlockAndUpdate(pos, newState);
        level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(newState));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(VARIANT);
    }

    /**
     * Get the max variants of this block. This way, we don't need to store maxVariants of the next block.
     */
    public int getMaxVariants() {
        return maxVariants;
    }
}
