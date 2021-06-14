package ScuffedClient.mods.impl;

import java.awt.Button;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

import ScuffedClient.event.EventTarget;
import ScuffedClient.event.impl.KeyEvent;
import ScuffedClient.gui.hud.ScreenPosition;
import ScuffedClient.mods.ModDraggable;
import ScuffedClient.mods.ModInstances;
import net.minecraft.client.Minecraft;

//MIGHT WANNA SET YAW AND PITCH TO DEFUALT F5 POS
//Also get rid of all the extra shit im too tired rn
//RERITE ALL OF THIS
public class ModPerspective extends ModDraggable {

	public ModPerspective() {
		super("Perspective");
	}

	private static Minecraft mc = Minecraft.getMinecraft();
	
	public static boolean returnOnRelease = false;
	public static boolean perspectiveToggled = false;
	private static float cameraYaw = 0F;
	private static float cameraPitch = 0F;
	private static int previousPerspective = 0;
	private static int intt = 0;
	//private static boolean startat90angle = false;
	
	@EventTarget public void onKeyPress(KeyEvent event)
	{
		if (Keyboard.getEventKey() == mc.gameSettings.CLIENT_PERSPECTIVE.getKeyCode() && ModInstances.getModPerspective().isEnabled())
		{
			
			if(mc.gameSettings.CLIENT_PERSPECTIVE.isPressed()) {
				perspectiveToggled = true;
				previousPerspective = mc.gameSettings.thirdPersonView;
			}
			
			if(!mc.gameSettings.CLIENT_PERSPECTIVE.isKeyDown() && perspectiveToggled) {
				perspectiveToggled = false;
				mc.gameSettings.thirdPersonView = previousPerspective;
			}
			
			if(mc.gameSettings.CLIENT_PERSPECTIVE.isKeyDown()) {
				perspectiveToggled = true;
				mc.gameSettings.thirdPersonView = 1;
				cameraYaw = mc.thePlayer.rotationYaw;
				cameraPitch = mc.thePlayer.rotationPitch;
			}
			

	}}

	public static float getCameraYaw()
	{
		return perspectiveToggled ? cameraYaw : mc.thePlayer.rotationYaw;
	}

	public static float getCameraPitch()
	{
		return perspectiveToggled ? cameraPitch : mc.thePlayer.rotationPitch;
	}

	public static boolean overrideMouse()
	{
		if (mc.inGameHasFocus && Display.isActive())
		{
			if (!perspectiveToggled)
			{
				return true;
			}

			// CODE
			mc.mouseHelper.mouseXYChange();
			float f1 = mc.gameSettings.mouseSensitivity * 0.6F + 0.2F;
			float f2 = f1 * f1 * f1 * 8.0F;
			float f3 = (float) mc.mouseHelper.deltaX * f2;
			float f4 = (float) mc.mouseHelper.deltaY * f2;

			cameraYaw += f3 * 0.15F;
			cameraPitch += f4 * 0.15F;

			if (cameraPitch > 90) cameraPitch = 90;
			if (cameraPitch < -90) cameraPitch = -90;
		}

		return false;
	}
	
	
	@Override
	public int getWidth() {
		return 0;
	}

	@Override
	public int getHeight() {
		return 0;
	}

	@Override
	public void render(ScreenPosition pos) {}
	
	@Override
	public void onEnable() {}

}
