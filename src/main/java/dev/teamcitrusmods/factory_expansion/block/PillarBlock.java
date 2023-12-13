package dev.teamcitrusmods.factory_expansion.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.jetbrains.annotations.Nullable;

public class PillarBlock extends Block {

    public static final BooleanProperty UP = PipeBlock.UP;
    public static final BooleanProperty DOWN = PipeBlock.DOWN;

    public PillarBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(UP, false)
                .setValue(DOWN, false));
    }

    public boolean connectsTo(BlockState state) {
        return state.getBlock() instanceof PillarBlock;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return super.getStateForPlacement(pContext)
                .setValue(UP, this.connectsTo(pContext.getLevel().getBlockState(pContext.getClickedPos().above())))
                .setValue(DOWN, this.connectsTo(pContext.getLevel().getBlockState(pContext.getClickedPos().below())));
    }

    @Override
    public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pNeighborPos) {
        return pState
                .setValue(UP, this.connectsTo(pLevel.getBlockState(pCurrentPos.above())))
                .setValue(DOWN, this.connectsTo(pLevel.getBlockState(pCurrentPos.below())));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(UP, DOWN);
    }
}
