package tri3d42.blockscript.language.symbol

import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.block.Block
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod.EventBusSubscriber


@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
object SymbolRegistry {
    val Group: CreativeModeTab = CreativeModeTab.TAB_MISC

    @SubscribeEvent
    @JvmStatic
    fun onBlocksRegistry(blockRegistryEvent: RegistryEvent.Register<Block?>) {
        ArraySymbol.setRegistryName("blockscript", "blockscript_array")
        blockRegistryEvent.registry.register(ArraySymbol)
    }

    @SubscribeEvent
    @JvmStatic
    fun onBlockItemsRegistry(blockRegistryEvent: RegistryEvent.Register<Item?>) {
        ArraySymbol.ITEM.setRegistryName("blockscript", "blockscript_array")
        blockRegistryEvent.registry.register(ArraySymbol.ITEM)
    }
}