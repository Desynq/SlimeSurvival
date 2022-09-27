package net.slimesurvival.common.item.material;

import net.minecraft.item.Item;
import net.slimesurvival.common.registry.ModItemGroups;

public class Niter extends Item {

	public Niter(Settings settings) {
		super(settings.group(ModItemGroups.MATERIALS).maxCount(32));
	}
}