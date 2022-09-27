package net.slimesurvival.common.item.material;

import net.minecraft.item.Item;
import net.slimesurvival.common.registry.ModItemGroups;

public class SmallLeather extends Item {

	public SmallLeather(Settings settings) {
		super(settings.group(ModItemGroups.MATERIALS).maxCount(32));
	}
}