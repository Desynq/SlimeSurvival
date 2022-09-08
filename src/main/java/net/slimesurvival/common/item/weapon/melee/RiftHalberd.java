package net.slimesurvival.common.item.weapon.melee;

import net.minecraft.item.AxeItem;
import net.slimesurvival.common.registry.ModItemGroups;
import net.slimesurvival.common.registry.ModToolMaterials;

public class RiftHalberd extends AxeItem {
	public RiftHalberd(Settings settings) {
		super(ModToolMaterials.MYSTITE, 19.0F, -2.8F, settings
			.group(ModItemGroups.WEAPONS)
			.fireproof()
		);
	}
}
