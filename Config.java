package modderspolaroid2;

import java.io.File;
import java.util.logging.Level;

import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

public class Config {

	public static int guiId = 56;
	public static int x = 306;
	public static int y = 104;
	public static int width = 236;
	public static int height = 112;
	public static int interval = 20;
	public static int start;
	public static boolean oldFileName;
	public void load(File file) {
		Configuration cfg = new Configuration(file);
		try {
			cfg.load();
			guiId = cfg.get(Configuration.CATEGORY_GENERAL, "guiId", guiId).getInt();
			interval = cfg.get(Configuration.CATEGORY_GENERAL, "interval", interval).getInt();
			x = cfg.get(Configuration.CATEGORY_GENERAL, "x", x).getInt();
			y = cfg.get(Configuration.CATEGORY_GENERAL, "y", y).getInt();
			width = cfg.get(Configuration.CATEGORY_GENERAL, "width", width).getInt();
			height = cfg.get(Configuration.CATEGORY_GENERAL, "height", height).getInt();
			start = cfg.get(Configuration.CATEGORY_GENERAL, "start", CraftingManager.getInstance().getRecipeList().size() - 1).getInt();
			oldFileName = cfg.get(Configuration.CATEGORY_GENERAL, "oldFileName", false, "Legacy: 265_Magenta Dye.png\nNew: ItemDyePowderMagenta.png").getBoolean(false);
			cfg.save();
		} catch (Exception e) {
			FMLLog.log(Level.SEVERE, e, "Modder's Polaroid2 load config exception");
		} finally {
			cfg.save();
		}
	}

}
