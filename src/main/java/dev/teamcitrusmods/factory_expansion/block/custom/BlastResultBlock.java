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

    private final Block RESULT;
    private final int MAXVARIANTS, NEXTVARIANTS;
    private IntegerProperty VARIATION = FactoryExpansion.VARIATION;

    public BlastResultBlock(Properties pProperties, Block block, int maxVariants, int nextVariants) {
        super(pProperties);
        this.RESULT = block;
        this.MAXVARIANTS = maxVariants;
        this.NEXTVARIANTS = nextVariants;
        FactoryExpansion.LOGGER.info("----------10");
        this.registerDefaultState(this.defaultBlockState().setValue(VARIATION, 1));
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        Random r = new Random();
        int n = r.nextInt(MAXVARIANTS);
        FactoryExpansion.LOGGER.info("----------11");
        FactoryExpansion.LOGGER.info(String.valueOf(n));
        FactoryExpansion.LOGGER.info("----------");
        return this.defaultBlockState().setValue(VARIATION, 1 + n);
    }

    @Override
    public void wasExploded(Level pLevel, @NotNull BlockPos pPos, @NotNull Explosion pExplosion) {
        if(RESULT.getClass().equals(BlastResultBlock.class)) {
            Random r = new Random();
            int n = r.nextInt(NEXTVARIANTS);
            FactoryExpansion.LOGGER.info("----------12");
            FactoryExpansion.LOGGER.info(String.valueOf(n));
            FactoryExpansion.LOGGER.info("----------");
            RESULT.defaultBlockState().setValue(VARIATION, 1 + n);
        }
        pLevel.setBlockAndUpdate(pPos, RESULT.defaultBlockState());
        pLevel.gameEvent(GameEvent.BLOCK_CHANGE, pPos, GameEvent.Context.of(RESULT.defaultBlockState()));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        VARIATION = FactoryExpansion.VARIATION; // <- I don't want it here
        FactoryExpansion.LOGGER.info("----------19");
        pBuilder.add(VARIATION);
    }
}
