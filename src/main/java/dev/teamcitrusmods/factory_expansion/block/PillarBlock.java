package dev.teamcitrusmods.factory_expansion.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.Nullable;

public class PillarBlock extends Block {

    public static final IntegerProperty SECTION = IntegerProperty.create("section", 0, 3);
    // 0 = shortest // 1 = bottom // 2 = middle // 3 = top

    public PillarBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(SECTION, 0));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        BlockState above = pContext.getLevel().getBlockState(pContext.getClickedPos().above());
        BlockState below = pContext.getLevel().getBlockState(pContext.getClickedPos().below());
        int sec = checkPillar(above.getBlock(), below.getBlock());
        return this.defaultBlockState().setValue(SECTION, sec);
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
        if(level.isClientSide()){
            return;
        }

        BlockState above = level.getBlockState(pos.above());
        BlockState below = level.getBlockState(pos.below());
        int sec = checkPillar(above.getBlock(), below.getBlock());
        BlockState newState = this.defaultBlockState();
        newState = newState.setValue(SECTION, sec);
        level.setBlockAndUpdate(pos, newState);
        level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(newState));
    }

    public int checkPillar(Block above, Block below) {
        if(below instanceof PillarBlock) {
            if(above instanceof  PillarBlock) {
                return 2; //mid red
            } else {
                return 3; //top green
            }
        } else if(above instanceof PillarBlock) {
            return 1; //bot blue
        }
        return 0; //nul yellow
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(SECTION);
    }
}
