package world.cryville.customhud;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class HudRenderer {
	public static FontRenderer renderer;
	
	@SubscribeEvent
	public void OnRender(RenderGameOverlayEvent.Text ev) {
		ScaledResolution res = ev.getResolution();
		for (Integer index : CustomHud.huds.keySet()) {
			Hud hud = CustomHud.huds.get(index);
			int tw = 0;
			for (String l : hud.content) {
				int ltw = renderer.getStringWidth(l);
				if (ltw > tw) tw = ltw;
			}
			int th = renderer.FONT_HEIGHT * hud.content.length;
			float x = hud.posX * res.getScaledWidth() - hud.anchorX * tw;
			float y = hud.posY * res.getScaledHeight() - hud.anchorY * th;
			int i = 0;
			for (String l : hud.content) {
				renderer.drawString(l, x, y + i++ * renderer.FONT_HEIGHT, 0xffffff, hud.dropShadow);
			}
		}
	}
}
