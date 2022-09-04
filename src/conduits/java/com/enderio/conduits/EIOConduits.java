package com.enderio.conduits;

import com.enderio.EnderIO;
import com.enderio.api.conduit.ConduitItemFactory;
import com.enderio.api.conduit.ConduitTypes;
import com.enderio.conduits.common.init.*;
import com.enderio.conduits.common.items.ConduitBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod.EventBusSubscriber(modid = EnderIO.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EIOConduits {
    @SubscribeEvent
    public static void onConstruct(FMLConstructModEvent event) {
        System.out.println("================ Conduits construct ==================");
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ConduitTypes.register(bus);
        EnderConduitTypes.register();
        ConduitBlockEntities.register();
        ConduitMenus.register();
        ConduitBlocks.register();
        ConduitItems.register();
        ConduitItemFactory.setFactory((type, properties) -> new ConduitBlockItem(type, ConduitBlocks.CONDUIT.get(), properties));
    }
}
