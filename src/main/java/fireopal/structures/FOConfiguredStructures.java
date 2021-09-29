package fireopal.structures;

import fireopal.structures.structures.config.Configs;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;

public class FOConfiguredStructures {
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_LONELY_HOUSE = FORegister.LONELY_HOUSE.configure(Configs.LONELY_HOUSE_CONFIG);
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_AMETHYST_HOUSE = FORegister.AMETHYST_HOUSE.configure(Configs.AMETHYST_HOUSE_CONFIG);
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_FOUNTAIN = FORegister.FOUNTAIN.configure(Configs.FOUNTAIN_CONFIG);

    public static void register(String id, ConfiguredStructureFeature<?, ?> configuredStructure) {
        Registry.register(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, FireopalStructures.id(id), configuredStructure);
    }

    public static void init() {
        register("configured_lonely_house", CONFIGURED_LONELY_HOUSE);
        register("configured_amethyst_house", CONFIGURED_AMETHYST_HOUSE);
        register("configured_fountain", CONFIGURED_FOUNTAIN);
    }
}
