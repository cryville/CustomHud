package world.cryville.customhud;

import java.util.concurrent.ConcurrentHashMap;

import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.FMLEventChannel;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@Mod(modid = CustomHud.MODID, name = CustomHud.NAME, version = CustomHud.VERSION)
public class CustomHud {
    public static final String MODID = "world.cryville.customhud";
    public static final String NAME = "Custom HUD";
    public static final String VERSION = "0.4";
    public static final String CHANNELID = "CustomHUD";

    public static Logger logger;
    public static FMLEventChannel channel;
    public static ConcurrentHashMap<Integer, Hud> huds;
    
    @SidedProxy(clientSide = "world.cryville.customhud.ClientProxy", serverSide = "world.cryville.customhud.ServerProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    public void onPreInit(FMLPreInitializationEvent ev) {
    	logger = ev.getModLog();
    	channel = NetworkRegistry.INSTANCE.newEventDrivenChannel(CHANNELID);
    	proxy.onPreInit(ev);
    }
    
    @EventHandler
    public void onPostInit(FMLPostInitializationEvent ev) {
    	proxy.onPostInit(ev);
    }
}
