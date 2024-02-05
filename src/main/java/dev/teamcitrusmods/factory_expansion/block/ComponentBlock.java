package dev.teamcitrusmods.factory_expansion.block;

import cofh.lib.api.item.ICoFHItem;
import cofh.thermal.core.ThermalCore;
//import cofh.thermal.core.init.TCoreItems;
import dev.teamcitrusmods.factory_expansion.FactoryExpansion;
import dev.teamcitrusmods.factory_expansion.registry.BlockRegistry;
import dev.teamcitrusmods.factory_expansion.registry.ItemRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

//import static cofh.core.item.ItemCoFH.

public class ComponentBlock extends Block {

    public static final IntegerProperty VARIANT = IntegerProperty.create("variant", 0, 3);
    // 0: no top, 1: hardened, 2: reinforced, 3: resonant
    public ComponentBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(VARIANT, 0));
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return pState.getValue(VARIANT) == 0 ?
                Block.box(0, 0, 0, 16, 8, 16) :
                Block.box(0, 0, 0, 16, 16, 16);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return super.getStateForPlacement(pContext)
                .setValue(VARIANT, 0);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        Item item = itemstack.getItem();
        if(pState.getValue(VARIANT) == 0){
            FactoryExpansion.LOGGER.debug("--a var is 0");
            if(itemstack.is(ThermalCore.ITEMS.get("upgrade_augment_1"))) {
                FactoryExpansion.LOGGER.debug("--b hand is hardened");
                pLevel.setBlock(pPos, pState.setValue(VARIANT, 1), 11);
                //event

                //NO
                return InteractionResult.CONSUME;
            }
            else {
                FactoryExpansion.LOGGER.debug("--b hand is NOT hardened");
                return InteractionResult.CONSUME;
            }
        }
        else {
            return InteractionResult.CONSUME;
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(VARIANT);
    }
}
