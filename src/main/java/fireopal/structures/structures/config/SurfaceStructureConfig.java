package fireopal.structures.structures.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.world.gen.feature.FeatureConfig;

public record SurfaceStructureConfig(Identifier identifier, IntProvider verticalOffset) implements FeatureConfig {
   public static final Codec<SurfaceStructureConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
      Identifier.CODEC.fieldOf("identifier").forGetter(SurfaceStructureConfig::identifier),
      IntProvider.VALUE_CODEC.fieldOf("verticalOffset").forGetter(SurfaceStructureConfig::verticalOffset)
   ).apply(instance, instance.stable(SurfaceStructureConfig::new)));
}