package vazkii.cowboyhat;

import java.math.BigDecimal;
import java.math.MathContext;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.resources.ResourceLocation;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.ReflectionHelper;

public class ClientProxy extends CommonProxy {

	@Override
	public void init(FMLPreInitializationEvent event) {
		super.init(event);
		
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	@ForgeSubscribe
	public void renderHUD(RenderGameOverlayEvent.Pre event) {
		if(event.type == ElementType.HEALTHMOUNT) {
			EntityPlayer player = Minecraft.getMinecraft().thePlayer;
			if(player != null && player.getCurrentArmor(3) != null && player.getCurrentArmor(3).itemID == cowboyHat.itemID && player.ridingEntity != null && player.ridingEntity instanceof EntityHorse) {
				EntityHorse horse = (EntityHorse) player.ridingEntity;
				double jump = new BigDecimal(horse.func_110148_a((Attribute) ReflectionHelper.getPrivateValue(EntityHorse.class, null, 1)).func_111126_e()).round(new MathContext(3)).doubleValue();
				double speed = new BigDecimal(horse.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111126_e()).round(new MathContext(3)).doubleValue();
			
				String jumpStr = "Jump Power: " + jump;
				String speedStr = "Speed: " + speed;
				
				GL11.glScalef(0.5F, 0.5F, 1F);
				FontRenderer font = Minecraft.getMinecraft().fontRenderer;
				font.drawStringWithShadow(jumpStr, event.resolution.getScaledWidth() + 185, event.resolution.getScaledHeight() * 2 - 80, 0xFFFFFF);
				font.drawStringWithShadow(speedStr, event.resolution.getScaledWidth() + 185, event.resolution.getScaledHeight() * 2 - 70, 0xFFFFFF);
				GL11.glScalef(2F, 2F, 1F);
			
				Minecraft.getMinecraft().renderEngine.func_110577_a(new ResourceLocation("textures/gui/icons.png"));
			}	
		}
	}
}
