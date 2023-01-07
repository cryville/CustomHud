package world.cryville.customhud;

import io.netty.buffer.Unpooled;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.internal.FMLProxyPacket;

public class CustomHudApi {
	public static void put(EntityPlayerMP player, int id, float posX, float posY, float anchorX, float anchorY, boolean dropShadow) {
		PacketBuffer buf = new PacketBuffer(Unpooled.buffer());
		buf.writeByte(0);
		buf.writeInt(id);
		buf.writeFloat(posX);
		buf.writeFloat(posY);
		buf.writeFloat(anchorX);
		buf.writeFloat(anchorY);
		buf.writeByte(dropShadow ? 1 : 0);
		CustomHud.channel.sendTo(new FMLProxyPacket(buf, CustomHud.CHANNELID), player);
	}
	public static void set(EntityPlayerMP player, int id, String content) {
		int len = content.length();
		if (len > Short.MAX_VALUE) return;
		PacketBuffer buf = new PacketBuffer(Unpooled.buffer());
		buf.writeByte(1);
		buf.writeInt(id);
		ByteBufUtils.writeUTF8String(buf, content);
		CustomHud.channel.sendTo(new FMLProxyPacket(buf, CustomHud.CHANNELID), player);
	}
	public static void remove(EntityPlayerMP player, int id) {
		PacketBuffer buf = new PacketBuffer(Unpooled.buffer());
		buf.writeByte(2);
		buf.writeInt(id);
		CustomHud.channel.sendTo(new FMLProxyPacket(buf, CustomHud.CHANNELID), player);
	}
}
