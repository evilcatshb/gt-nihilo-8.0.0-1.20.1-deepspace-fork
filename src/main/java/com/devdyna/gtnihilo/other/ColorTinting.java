package com.devdyna.gtnihilo.other;

import static com.devdyna.gtnihilo.init.ItemVein.ITEMS;
import static com.devdyna.gtnihilo.other.DataBase.colors;

import com.devdyna.gtnihilo.Main;

import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

// Bound to Dist.CLIENT: FML's mod-file scanner will skip this class entirely on a dedicated server,
// so its @SubscribeEvent method (and the client-only RegisterColorHandlersEvent.Item / ItemColors types
// it touches) are never loaded server-side. Methods must be static for the automatic subscriber to call them.
@Mod.EventBusSubscriber(modid = Main.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ColorTinting {

    @SubscribeEvent
    public static void registerItemColors(RegisterColorHandlersEvent.Item event) {

        for (int i = 0; i < ITEMS.getEntries().size(); i++) {
            regTintItem(event,
                    colors[i],
                    ITEMS.getEntries()
                            .stream().skip(i).findFirst().get().get());
        }

    }

    public static void regTintItem(RegisterColorHandlersEvent.Item e, int color, Item i) {
        e.register((item, tintindex) -> item.getItem()==i ? color: null, i);
    }

}
