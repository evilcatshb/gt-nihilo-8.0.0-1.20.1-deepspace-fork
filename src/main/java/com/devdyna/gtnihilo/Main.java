package com.devdyna.gtnihilo;

import com.devdyna.gtnihilo.init.CreativeTab;
import com.devdyna.gtnihilo.init.ItemVein;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Main.MODID)
public class Main
{

    public static final String MODID = "gtnihilo";

    @SuppressWarnings("removal")
    public Main()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemVein.register(modEventBus);
        CreativeTab.register(modEventBus);
        // ColorTinting is registered automatically via its own @Mod.EventBusSubscriber(value = Dist.CLIENT)
        // annotation below - it must NOT be registered here, since that would force this class (and its
        // @SubscribeEvent method's client-only RegisterColorHandlersEvent.Item parameter) to be reflectively
        // inspected on the dedicated server too, crashing with:
        // "Attempted to load class net/minecraft/client/color/item/ItemColors for invalid dist DEDICATED_SERVER"
    }

}
