package dev.teamcitrusmods.factory_expansion.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RedstoneTorchBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

import javax.annotation.Nullable;
import java.util.function.ToIntFunction;

public class FluxLampBlock extends Block {
    public static final BooleanProperty LIT = RedstoneTorchBlock.LIT;

    public FluxLampBlock(Properties pProperties) {
        super(pProperties);
    }


    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(LIT, Boolean.valueOf(pContext.getLevel().hasNeighborSignal(pContext.getClickedPos())));
    }

    public void neighborChanged(BlockState pState, Level pLevel, BlockPos pPos, Block pBlock, BlockPos pFromPos, boolean pIsMoving) {
        if (!pLevel.isClientSide) {
            boolean flag = pState.getValue(LIT);
            if (flag != pLevel.hasNeighborSignal(pPos)) {
                if (flag) {
                    pLevel.scheduleTick(pPos, this, 4);
                } else {
                    pLevel.setBlock(pPos, pState.cycle(LIT), 2);
                }
            }

        }
    }

    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pState.getValue(LIT) && !pLevel.hasNeighborSignal(pPos)) {
            pLevel.setBlock(pPos, pState.cycle(LIT), 2);
        }

    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(LIT);
    }
}
