package fireopal.structures;

import net.fabricmc.fabric.api.structure.v1.FabricStructureBuilder;
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.chunk.StructureConfig;
import fireopal.structures.structures.SurfaceStructure;
import fireopal.structures.structures.UndergroundStructure;
import fireopal.structures.structures.config.SurfaceStructureConfig;
import fireopal.structures.structures.config.UndergroundStructureConfig;
import fireopal.structures.structures.config.Configs;

public class FORegister {

    public static void register(String id, StructureFeature<SurfaceStructureConfig> structure, ConfiguredStructureFeature<?, ?> configuredStructure, SurfaceStructureConfig config, int avgChunks, int minChunks, int salt) {
        FabricStructureBuilder.create(FireopalStructures.id(id), structure)
            .step(GenerationStep.Feature.SURFACE_STRUCTURES)
            .defaultConfig(new StructureConfig(
                avgChunks, /* Average chunks between structures */
                minChunks, /* Minimum chunks between structures */
                salt /* Random value to offset structures */
            ))
            .superflatFeature(structure.configure(config))
            .adjustsSurface()
            .register();

            String configuredId = "configured_" + id;

            Registry.register(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, FireopalStructures.id(configuredId), configuredStructure);
    }

    public static void register(String id, StructureFeature<UndergroundStructureConfig> structure, ConfiguredStructureFeature<?, ?> configuredStructure, UndergroundStructureConfig config, int avgChunks, int minChunks, int salt) {
        FabricStructureBuilder.create(FireopalStructures.id(id), structure)
            .step(GenerationStep.Feature.SURFACE_STRUCTURES)
            .defaultConfig(new StructureConfig(
                avgChunks, /* Average chunks between structures */
                minChunks, /* Minimum chunks between structures */
                salt /* Random value to offset structures */
            ))
            .superflatFeature(structure.configure(config))
            .register();

            String configuredId = "configured_" + id;

            Registry.register(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, FireopalStructures.id(configuredId), configuredStructure);
    }

    public static void registerConfiguredStructure(String id, ConfiguredStructureFeature<?, ?> configuredStructure) {
        Registry.register(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, FireopalStructures.id(id), configuredStructure);
    }

    public static StructureFeature<SurfaceStructureConfig> surfaceStructure() {
        return new SurfaceStructure(SurfaceStructureConfig.CODEC);
    }

    public static StructureFeature<UndergroundStructureConfig> undergroundStructure() {
        return new UndergroundStructure(UndergroundStructureConfig.CODEC);
    }


    //Structure Instances

    public static StructureFeature<SurfaceStructureConfig> LONELY_HOUSE = surfaceStructure();
    public static StructureFeature<SurfaceStructureConfig> AMETHYST_HOUSE = surfaceStructure();
    public static StructureFeature<SurfaceStructureConfig> FOUNTAIN = surfaceStructure();

    public static StructureFeature<UndergroundStructureConfig> UNDERGROUND_BUNKER = undergroundStructure();



    //Structure Configurations

    public static ConfiguredStructureFeature<?, ?> CONFIGURED_LONELY_HOUSE = LONELY_HOUSE.configure(Configs.LONELY_HOUSE_CONFIG);
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_AMETHYST_HOUSE = AMETHYST_HOUSE.configure(Configs.AMETHYST_HOUSE_CONFIG);
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_FOUNTAIN = FOUNTAIN.configure(Configs.FOUNTAIN_CONFIG);

    public static ConfiguredStructureFeature<?, ?> CONFIGURED_UNDERGROUND_BUNKER = UNDERGROUND_BUNKER.configure(Configs.UNDERGROUND_BUNKER_CONFIG);

    //public static StructureProcessorType<LonelyHouseProcessor> LONELY_HOUSE_PROCESSOR;

    public static void init() {
        register("lonely_house", LONELY_HOUSE, CONFIGURED_LONELY_HOUSE, Configs.LONELY_HOUSE_CONFIG, 35, 20, -1554642242);
        register("amethyst_house", AMETHYST_HOUSE, CONFIGURED_AMETHYST_HOUSE, Configs.AMETHYST_HOUSE_CONFIG, 40, 20, -136596002);
        register("fountain", FOUNTAIN, CONFIGURED_FOUNTAIN, Configs.FOUNTAIN_CONFIG, 20, 10, 763363108);

        register("underground_bunker", UNDERGROUND_BUNKER, CONFIGURED_UNDERGROUND_BUNKER, Configs.UNDERGROUND_BUNKER_CONFIG, 20, 8, 32365135);
    }   
}
