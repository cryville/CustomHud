package world.cryville.customhud;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	@Override
    public void onPreInit(FMLPreInitializationEvent ev) {
		super.onPreInit(ev);
    	MinecraftForge.EVENT_BUS.register(new EventHandlerClient());
    	MinecraftForge.EVENT_BUS.register(new HudRenderer());
    	CustomHud.channel.register(new PacketHandlerClient());
    }
	
	@Override
    public void onPostInit(FMLPostInitializationEvent ev) {
		super.onPostInit(ev);
    	HudRenderer.renderer = Minecraft.getMinecraft().fontRenderer;
    }
}
