package fireopal.structures.structures.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.world.gen.feature.FeatureConfig;

public record UndergroundStructureConfig(Identifier jigsawPool, int minY, int maxY, IntProvider topOffset) implements FeatureConfig {
   public static final Codec<UndergroundStructureConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
      Identifier.CODEC.fieldOf("jigsawPool").forGetter(UndergroundStructureConfig::jigsawPool),
      Codec.INT.fieldOf("minY").forGetter(UndergroundStructureConfig::minY),
      Codec.INT.fieldOf("maxY").forGetter(UndergroundStructureConfig::maxY),
      IntProvider.VALUE_CODEC.fieldOf("topOffset").forGetter(UndergroundStructureConfig::topOffset)
   ).apply(instance, instance.stable(UndergroundStructureConfig::new)));
}