package world.cryville.customhud;

import java.util.concurrent.ConcurrentHashMap;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent.ClientConnectedToServerEvent;

public class EventHandlerClient {
    @SubscribeEvent
    public void onLogin(ClientConnectedToServerEvent ev) {
		CustomHud.huds = new ConcurrentHashMap<Integer, Hud>();
    }
}
