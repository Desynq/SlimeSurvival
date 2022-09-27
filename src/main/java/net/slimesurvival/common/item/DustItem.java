package net.slimesurvival.common.item;

import net.minecraft.item.Item;
import net.slimesurvival.common.registry.ModItemGroups;

public class DustItem extends Item {

	public DustItem(Settings settings) {
		super(settings.group(ModItemGroups.MATERIALS).maxCount(64));
	}
}