package net.povstalec.sgjourney.common.world.biomemod;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.ForgeRegistries;
import net.neoforged.neoforge.registries.RegistryObject;
import net.povstalec.sgjourney.StargateJourney;

public class BiomeModifiers
{
	public static final DeferredRegister<Codec<? extends BiomeModifier>> BIOME_MODIFIERS =
            DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, StargateJourney.MODID);
	
	public static RegistryObject<Codec<OreBiomeModifier>> ORE_MODIFIER = BIOME_MODIFIERS.register("ores", () ->
    RecordCodecBuilder.create(builder -> builder.group(
            Biome.LIST_CODEC.fieldOf("biomes").forGetter(OreBiomeModifier::biomes),
            PlacedFeature.CODEC.fieldOf("feature").forGetter(OreBiomeModifier::feature)
    ).apply(builder, OreBiomeModifier::new)));
	
	public static void register(IEventBus eventBus)
	{
        BIOME_MODIFIERS.register(eventBus);
    }
}
