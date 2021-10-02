package fireopal.structures;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public class FireopalStructures implements ModInitializer {
	static String MODID = "fireopal_structures";

    @Override
	public void onInitialize() {
		FORegister.init();
		FOBiomeModifications.init();
	}


	public static Identifier id(String id) {
		return new Identifier(MODID, id);
	}
}
