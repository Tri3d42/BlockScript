package tri3d42.blockscript.language.symbol

import net.minecraft.core.Direction
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.item.context.BlockPlaceContext
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.block.state.StateDefinition
import net.minecraft.world.level.block.state.properties.BlockStateProperties
import net.minecraft.world.level.material.Material


object AssignSymbol:
    Block(Properties.of(Material.STONE).noOcclusion().destroyTime(6.5f)) {
    val ITEM = BlockItem(this, Item.Properties().tab(SymbolRegistry.Group))

    init {
        this.registerDefaultState(
            stateDefinition.any().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH)
        )
    }

    override fun createBlockStateDefinition(p_49915_: StateDefinition.Builder<Block, BlockState>) {
        super.createBlockStateDefinition(p_49915_)
        p_49915_.add(BlockStateProperties.HORIZONTAL_FACING)
    }

    override fun getStateForPlacement(p_49820_: BlockPlaceContext): BlockState? {
        return super.getStateForPlacement(p_49820_)?.setValue(BlockStateProperties.HORIZONTAL_FACING,p_49820_.horizontalDirection)
    }
}