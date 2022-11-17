package net.slimesurvival.common.item.weapon.melee;

import net.minecraft.item.AxeItem;
import net.slimesurvival.common.item.SSToolMaterials;
import net.slimesurvival.common.registry.ModItemGroups;

public class RiftHalberd extends AxeItem {
	public RiftHalberd(Settings settings) {
		super(SSToolMaterials.MYSTITE, 19.0F, -2.8F, settings
			.group(ModItemGroups.WEAPONS)
			.fireproof()
		);
	}
}
