package net.povstalec.sgjourney.common.config;

import net.neoforged.neoforge.common.NeoForgeConfigSpec;

public class ClientDHDConfig
{
	public static NeoForgeConfigSpec.BooleanValue milky_way_dhd_canon_symbol_positions;
	public static NeoForgeConfigSpec.BooleanValue pegasus_dhd_canon_symbol_positions;
	
	public static void init(NeoForgeConfigSpec.Builder client)
	{
		milky_way_dhd_canon_symbol_positions = client
				.comment("If true, Milky Way DHD symbol positions won't be ordered and instead be based on the canon")
				.define("client.milky_way_dhd_canon_symbol_positions", false);
		
			pegasus_dhd_canon_symbol_positions = client
					.comment("If true, Pegasus DHD symbol positions won't be ordered and instead be based on the canon")
					.define("client.pegasus_dhd_canon_symbol_positions", false);
	}
}
