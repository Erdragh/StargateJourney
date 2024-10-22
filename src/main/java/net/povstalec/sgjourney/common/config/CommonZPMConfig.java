package net.povstalec.sgjourney.common.config;

import net.neoforged.neoforge.common.NeoForgeConfigSpec;

public class CommonZPMConfig
{
	public static NeoForgeConfigSpec.LongValue zpm_energy_per_level_of_entropy;
	public static NeoForgeConfigSpec.LongValue zpm_hub_max_transfer;
	
	public static void init(NeoForgeConfigSpec.Builder server)
	{
		zpm_energy_per_level_of_entropy = server
				.comment("The energy that can be extracted from a single level of entropy")
				.defineInRange("server.zpm_energy_per_level_of_entropy", 100000000000L, 1L, 9223372036854775807L);

		zpm_hub_max_transfer = server
				.comment("Maximum amount of energy that can be transferred from the ZPM Hub in one tick")
				.defineInRange("server.zpm_hub_max_transfer", 100000000000L, 1L, 9223372036854775807L);
	}
}
