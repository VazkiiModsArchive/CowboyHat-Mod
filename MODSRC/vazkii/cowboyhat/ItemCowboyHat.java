package vazkii.cowboyhat;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemCowboyHat extends ItemArmor  {

	public ItemCowboyHat(int par1) {
		super(par1, EnumArmorMaterial.CHAIN, 0, 0);
		
		setUnlocalizedName("cowboyHat");
		LanguageRegistry.addName(this, "Cowboy Hat");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		itemIcon = par1IconRegister.registerIcon("cowboyhat:hat");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add("Yee haw!");
	}
	
	@Override
	public int getColor(ItemStack par1ItemStack) {
		return 10511680;
	}

}
