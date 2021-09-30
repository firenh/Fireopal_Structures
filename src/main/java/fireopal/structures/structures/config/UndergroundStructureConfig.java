package fireopal.structures.structures.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.world.gen.feature.FeatureConfig;

public record UndergroundStructureConfig(Identifier identifier, IntProvider range) implements FeatureConfig {
   public static final Codec<UndergroundStructureConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
      Identifier.CODEC.fieldOf("identifier").forGetter(UndergroundStructureConfig::identifier),
      IntProvider.VALUE_CODEC.fieldOf("range").forGetter(UndergroundStructureConfig::range)
   ).apply(instance, instance.stable(UndergroundStructureConfig::new)));
}