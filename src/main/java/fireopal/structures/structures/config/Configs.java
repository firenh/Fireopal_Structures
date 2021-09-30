package fireopal.structures.structures.config;

import static fireopal.structures.FireopalStructures.id;

import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class Configs {
    public static final SurfaceStructureConfig LONELY_HOUSE_CONFIG = new SurfaceStructureConfig(id("lonely_house"), UniformIntProvider.create(-3, -1));
    public static final SurfaceStructureConfig AMETHYST_HOUSE_CONFIG =  new SurfaceStructureConfig(id("amethyst_house"), ConstantIntProvider.create(-2));
    public static final SurfaceStructureConfig FOUNTAIN_CONFIG = new SurfaceStructureConfig(id("fountain"), ConstantIntProvider.create(-3));

    public static final UndergroundStructureConfig TEST_UNDERGROUND_CONFIG = new UndergroundStructureConfig(id("underground_bunker"), UniformIntProvider.create(-20, 255));
}
