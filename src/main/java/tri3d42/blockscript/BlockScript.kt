package tri3d42.blockscript

import com.mojang.logging.LogUtils
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.event.server.ServerStartingEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.InterModComms
import net.minecraftforge.fml.InterModComms.IMCMessage
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.Mod.EventBusSubscriber
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext
import org.slf4j.Logger
import tri3d42.blockscript.language.symbol.SymbolRegistry
import java.util.stream.Collectors

// The value here should match an entry in the META-INF/mods.toml file
@Mod("blockscript")
class BlockScript {

    init {
        MinecraftForge.EVENT_BUS.register(SymbolRegistry)

        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().modEventBus.addListener { event: FMLCommonSetupEvent ->
            this.setup(
                event
            )
        }
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().modEventBus.addListener { event: InterModEnqueueEvent ->
            this.enqueueIMC(
                event
            )
        }
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().modEventBus.addListener { event: InterModProcessEvent ->
            this.processIMC(
                event
            )
        }

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this)
    }

    private fun setup(event: FMLCommonSetupEvent) {
        // Some preinit code
        LOGGER.info("HELLO FROM PREINIT")
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.registryName)
    }

    private fun enqueueIMC(event: InterModEnqueueEvent) {
        // Some example code to dispatch IMC to another mod
        InterModComms.sendTo("blockscript", "helloworld") {
            LOGGER.info("Hello world from the MDK")
            "Hello world"
        }
    }

    private fun processIMC(event: InterModProcessEvent) {
        // Some example code to receive and process InterModComms from other mods
        LOGGER.info(
            "Got IMC {}", event.imcStream.map
            { m: IMCMessage -> m.messageSupplier().get() }.collect
                (Collectors.toList())
        )
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    fun onServerStarting(event: ServerStartingEvent?) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting")
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
    object RegistryEvents {
        @SubscribeEvent
        fun onBlocksRegistry(blockRegistryEvent: RegistryEvent.Register<Block?>?) {
            // Register a new block here
            LOGGER.info("HELLO from Register Block")
        }
    }

    companion object {
        // Directly reference a slf4j logger
        private val LOGGER: Logger = LogUtils.getLogger()
    }
}
