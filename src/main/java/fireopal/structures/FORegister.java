package fireopal.structures;

import net.fabricmc.fabric.api.structure.v1.FabricStructureBuilder;
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.chunk.StructureConfig;
import fireopal.structures.structures.SubmergeableSurfaceStructure;
//import fireopal.structures.processors.GeneralBlockDecayProcessor;
import fireopal.structures.structures.SurfaceStructure;
import fireopal.structures.structures.UndergroundStructure;
import fireopal.structures.structures.config.SurfaceStructureConfig;
import fireopal.structures.structures.config.UndergroundStructureConfig;
import fireopal.structures.structures.config.Configs;
import fireopal.structures.structures.config.SubmergeableSurfaceStructureConfig;

import static fireopal.structures.FireopalStructures.id;

public class FORegister {
    private static void register(String id, StructureFeature<SurfaceStructureConfig> structure, ConfiguredStructureFeature<?, ?> configuredStructure, SurfaceStructureConfig config, int avgChunks, int minChunks, int salt) {
        FabricStructureBuilder.create(id(id), structure)
            .step(GenerationStep.Feature.TOP_LAYER_MODIFICATION)
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

    private static void register(String id, StructureFeature<SubmergeableSurfaceStructureConfig> structure, ConfiguredStructureFeature<?, ?> configuredStructure, SubmergeableSurfaceStructureConfig config, int avgChunks, int minChunks, int salt) {
        FabricStructureBuilder.create(id(id), structure)
            .step(GenerationStep.Feature.TOP_LAYER_MODIFICATION)
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

    private static void register(String id, StructureFeature<UndergroundStructureConfig> structure, ConfiguredStructureFeature<?, ?> configuredStructure, UndergroundStructureConfig config, int avgChunks, int minChunks, int salt) {
        FabricStructureBuilder.create(id(id), structure)
            .step(GenerationStep.Feature.TOP_LAYER_MODIFICATION)
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
        Registry.register(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, id(id), configuredStructure);
    }

    private static StructureFeature<SurfaceStructureConfig> surfaceStructure() {
        return new SurfaceStructure(SurfaceStructureConfig.CODEC);
    }

    private static StructureFeature<SubmergeableSurfaceStructureConfig> submergeableSurfaceStructure() {
        return new SubmergeableSurfaceStructure(SubmergeableSurfaceStructureConfig.CODEC);
    }

    private static StructureFeature<UndergroundStructureConfig> undergroundStructure() {
        return new UndergroundStructure(UndergroundStructureConfig.CODEC);
    }


    //Processors

        //public static StructureProcessorType<GeneralBlockDecayProcessor> GENERAL_BLOCK_DECAY_PROCESSOR;
        //public static StructureProcessorType<LonelyHouseProcessor> LONELY_HOUSE_PROCESSOR;

    //Structure Instances

    public static StructureFeature<SurfaceStructureConfig> LONELY_HOUSE = surfaceStructure();
    public static StructureFeature<SurfaceStructureConfig> AMETHYST_HOUSE = surfaceStructure();
    public static StructureFeature<SurfaceStructureConfig> FOUNTAIN = surfaceStructure();

        //public static StructureFeature<SubmergeableSurfaceStructureConfig> STATUE = submergeableSurfaceStructure();

    public static StructureFeature<UndergroundStructureConfig> UNDERGROUND_BUNKER = undergroundStructure();



    //Structure Configurations

    public static ConfiguredStructureFeature<?, ?> CONFIGURED_LONELY_HOUSE = LONELY_HOUSE.configure(Configs.LONELY_HOUSE_CONFIG);
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_AMETHYST_HOUSE = AMETHYST_HOUSE.configure(Configs.AMETHYST_HOUSE_CONFIG);
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_FOUNTAIN = FOUNTAIN.configure(Configs.FOUNTAIN_CONFIG);

        //public static ConfiguredStructureFeature<?, ?> CONFIGURED_STATUE = STATUE.configure(Configs.STATUE_CONFIG);

    public static ConfiguredStructureFeature<?, ?> CONFIGURED_UNDERGROUND_BUNKER = UNDERGROUND_BUNKER.configure(Configs.UNDERGROUND_BUNKER_CONFIG);

    public static void init() {
            //Registry.register(Registry.STRUCTURE_PROCESSOR, FireopalStructures.id("general_block_decay_processor"), GENERAL_BLOCK_DECAY_PROCESSOR);

        register("lonely_house", LONELY_HOUSE, CONFIGURED_LONELY_HOUSE, Configs.LONELY_HOUSE_CONFIG, 35, 20, -1554642242);
        register("amethyst_house", AMETHYST_HOUSE, CONFIGURED_AMETHYST_HOUSE, Configs.AMETHYST_HOUSE_CONFIG, 40, 20, -136596002);
        register("fountain", FOUNTAIN, CONFIGURED_FOUNTAIN, Configs.FOUNTAIN_CONFIG, 20, 10, 763363108);

            //register("statue", STATUE, CONFIGURED_STATUE, Configs.STATUE_CONFIG, 10, 3, 1288897705);

        register("underground_bunker", UNDERGROUND_BUNKER, CONFIGURED_UNDERGROUND_BUNKER, Configs.UNDERGROUND_BUNKER_CONFIG, 20, 8, 32365135);
    }   
}
