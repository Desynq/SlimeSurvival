package net.slimesurvival.common.item.weapon.melee;

import net.minecraft.item.SwordItem;
import net.slimesurvival.common.registry.ModItemGroups;
import net.slimesurvival.common.registry.ModToolMaterials;

public class RiftGreatsword extends SwordItem {

	public RiftGreatsword(Settings settings) {
		super(ModToolMaterials.MYSTITE, 29, -3.1F, settings
			.group(ModItemGroups.WEAPONS)
			.fireproof()
		);
	}
}
