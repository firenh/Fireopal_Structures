package fireopal.structures;

import net.fabricmc.fabric.api.structure.v1.FabricStructureBuilder;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.chunk.StructureConfig;
import fireopal.structures.structures.SurfaceStructure;
import fireopal.structures.structures.config.SurfaceStructureConfig;
import fireopal.structures.structures.config.Configs;

public class FORegister {

    public static void registerSurfaceStructure(String id, StructureFeature<SurfaceStructureConfig> structure, SurfaceStructureConfig config, int avgChunks, int minChunks, int salt) {
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
    }

    public static StructureFeature<SurfaceStructureConfig> LONELY_HOUSE = new SurfaceStructure(SurfaceStructureConfig.CODEC);
    public static StructureFeature<SurfaceStructureConfig> AMETHYST_HOUSE = new SurfaceStructure(SurfaceStructureConfig.CODEC);
    public static StructureFeature<SurfaceStructureConfig> FOUNTAIN = new SurfaceStructure(SurfaceStructureConfig.CODEC);

    //public static StructureProcessorType<LonelyHouseProcessor> LONELY_HOUSE_PROCESSOR;

    public static void init() {
        registerSurfaceStructure("lonely_house", LONELY_HOUSE, Configs.LONELY_HOUSE_CONFIG, 25, 10, -1554642242);
        registerSurfaceStructure("amethyst_house", AMETHYST_HOUSE, Configs.AMETHYST_HOUSE_CONFIG, 30, 10, -136596002);
        registerSurfaceStructure("fountain", FOUNTAIN, Configs.FOUNTAIN_CONFIG, 20, 8, 763363108);
    }   

}
