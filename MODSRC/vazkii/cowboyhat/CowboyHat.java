package vazkii.cowboyhat;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "CowboyHat", name = "Cowboy Hat", version = "1.0")
public class CowboyHat {
	
	@SidedProxy(clientSide = "vazkii.cowboyhat.ClientProxy", serverSide = "vazkii.cowboyhat.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void init(FMLPreInitializationEvent event) {
		proxy.init(event);
	}

}
