package net.povstalec.sgjourney.common.datagen;

import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.povstalec.sgjourney.StargateJourney;
import net.povstalec.sgjourney.common.world.WorldGenProvider;

@Mod.EventBusSubscriber(modid = StargateJourney.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGeneration
{
	@SubscribeEvent
    public static void gatherData(GatherDataEvent event)
    {
		DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        
        //generator.addProvider(true, LootTableGen.create(packOutput));
        generator.addProvider(event.includeServer(), new WorldGenProvider(packOutput, lookupProvider));
    }
}
