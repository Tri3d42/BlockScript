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
        CharacterSymbol.setRegistryName("blockscript", "blockscript_character")
        DefineSymbol.setRegistryName("blockscript", "blockscript_define")
        AssignSymbol.setRegistryName("blockscript", "blockscript_assign")
        ReferSymbol.setRegistryName("blockscript", "blockscript_refer")
        blockRegistryEvent.registry.register(ArraySymbol)
        blockRegistryEvent.registry.register(CharacterSymbol)
        blockRegistryEvent.registry.register(DefineSymbol)
        blockRegistryEvent.registry.register(AssignSymbol)
        blockRegistryEvent.registry.register(ReferSymbol)
    }

    @SubscribeEvent
    @JvmStatic
    fun onBlockItemsRegistry(blockRegistryEvent: RegistryEvent.Register<Item?>) {
        ArraySymbol.ITEM.setRegistryName("blockscript", "blockscript_array")
        CharacterSymbol.ITEM.setRegistryName("blockscript", "blockscript_character")
        DefineSymbol.ITEM.setRegistryName("blockscript", "blockscript_define")
        AssignSymbol.ITEM.setRegistryName("blockscript", "blockscript_assign")
        ReferSymbol.ITEM.setRegistryName("blockscript", "blockscript_refer")
        blockRegistryEvent.registry.register(ArraySymbol.ITEM)
        blockRegistryEvent.registry.register(CharacterSymbol.ITEM)
        blockRegistryEvent.registry.register(DefineSymbol.ITEM)
        blockRegistryEvent.registry.register(AssignSymbol.ITEM)
        blockRegistryEvent.registry.register(ReferSymbol.ITEM)
    }
}