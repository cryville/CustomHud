package world.cryville.customhud;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.FMLNetworkEvent.ClientCustomPacketEvent;

public class PacketHandlerClient {
	@SubscribeEvent
	public void onServerPacket(ClientCustomPacketEvent ev) {
		ByteBuf buf = ev.getPacket().payload();
		byte type = buf.readByte();
		Integer id = buf.readInt();
		if (type == 0) {
			Hud hud = CustomHud.huds.get(id);
			if (hud == null) {
				hud = new Hud();
				CustomHud.huds.put(id, hud);
			}
			hud.posX = buf.readFloat();
			hud.posY = buf.readFloat();
			hud.anchorX = buf.readFloat();
			hud.anchorY = buf.readFloat();
			hud.dropShadow = buf.readByte() != 0;
		}
		else if (type == 1) {
			Hud hud = CustomHud.huds.get(id);
			if (hud == null) return;
			hud.content = ByteBufUtils.readUTF8String(buf).split("\n");
		}
		else if (type == 2) {
			CustomHud.huds.remove(id);
		}
	}
}
