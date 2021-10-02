package fireopal.structures.structures.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.world.gen.feature.FeatureConfig;

public record SubmergeableSurfaceStructureConfig(Identifier identifier, IntProvider verticalOffset) implements FeatureConfig {
   public static final Codec<SubmergeableSurfaceStructureConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
      Identifier.CODEC.fieldOf("identifier").forGetter(SubmergeableSurfaceStructureConfig::identifier),
      IntProvider.VALUE_CODEC.fieldOf("verticalOffset").forGetter(SubmergeableSurfaceStructureConfig::verticalOffset)
   ).apply(instance, instance.stable(SubmergeableSurfaceStructureConfig::new)));
}