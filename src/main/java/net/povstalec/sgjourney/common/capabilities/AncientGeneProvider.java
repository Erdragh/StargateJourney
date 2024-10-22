package net.povstalec.sgjourney.common.capabilities;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.neoforged.neoforge.common.capabilities.Capability;
import net.neoforged.neoforge.common.capabilities.CapabilityManager;
import net.neoforged.neoforge.common.capabilities.CapabilityToken;
import net.neoforged.neoforge.common.capabilities.ICapabilityProvider;
import net.neoforged.neoforge.common.util.INBTSerializable;
import net.neoforged.neoforge.common.util.LazyOptional;

public class AncientGeneProvider implements ICapabilityProvider, INBTSerializable<CompoundTag>
{
	public static Capability<AncientGene> ANCIENT_GENE = CapabilityManager.get(new CapabilityToken<AncientGene>() {});
	private AncientGene ancientGene = null;
	private final LazyOptional<AncientGene> optional = LazyOptional.of(this::getOrCreateAncientGene);
	
	@Override
	public CompoundTag serializeNBT()
	{
		CompoundTag tag = new CompoundTag();
		getOrCreateAncientGene().saveData(tag);
		
		return tag;
	}

	@Override
	public void deserializeNBT(CompoundTag tag)
	{
		getOrCreateAncientGene().loadData(tag);
	}

	@Override
	public <T> @NotNull LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side)
	{
		if(cap == ANCIENT_GENE)
			return optional.cast();
		return LazyOptional.empty();
	}
	
	private AncientGene getOrCreateAncientGene()
	{
		if(this.ancientGene == null)
			this.ancientGene = new AncientGene();
		return this.ancientGene;
	}
}
