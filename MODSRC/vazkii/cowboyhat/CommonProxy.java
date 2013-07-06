package vazkii.cowboyhat;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy {

	public static Item cowboyHat;
	
	public void init(FMLPreInitializationEvent event) {
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		
		config.load();
		
		cowboyHat = new ItemCowboyHat(config.get(config.CATEGORY_ITEM, "cowboyHatID", 17280).getInt(17280));
		
		config.save();
		
		GameRegistry.addShapelessRecipe(new ItemStack(cowboyHat), Item.helmetLeather, Item.wheat);
	}
	
}
