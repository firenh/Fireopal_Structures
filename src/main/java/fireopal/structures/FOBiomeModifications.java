package fireopal.structures;

import java.util.function.Predicate;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;

public class FOBiomeModifications {
    public static void addStructure(String id, ConfiguredStructureFeature<?, ?> configuredStructureFeature, Predicate<BiomeSelectionContext> biomeSelectors) {
        BiomeModifications.create(FireopalStructures.id(id))
            .add(
                ModificationPhase.ADDITIONS,
                biomeSelectors,
                context -> {
                    context.getGenerationSettings().addBuiltInStructure(configuredStructureFeature);
                }
            );
    }

    public static void init() {
        addStructure("amethyst_house_addition", FORegister.CONFIGURED_AMETHYST_HOUSE, BiomeSelectors.foundInOverworld());
        addStructure("lonely_house_addition", FORegister.CONFIGURED_LONELY_HOUSE, BiomeSelectors.foundInOverworld());
        addStructure("fountain_addition", FORegister.CONFIGURED_FOUNTAIN, BiomeSelectors.foundInOverworld());

        addStructure("underground_bunker_addition", FORegister.CONFIGURED_UNDERGROUND_BUNKER, BiomeSelectors.all());
    }
}
