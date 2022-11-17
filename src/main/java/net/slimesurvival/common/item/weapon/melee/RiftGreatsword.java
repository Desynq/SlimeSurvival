package net.slimesurvival.common.item.weapon.melee;

import net.minecraft.item.SwordItem;
import net.slimesurvival.common.item.SSToolMaterials;
import net.slimesurvival.common.registry.ModItemGroups;

public class RiftGreatsword extends SwordItem {

	public RiftGreatsword(Settings settings) {
		super(SSToolMaterials.MYSTITE, 29, -3.1F, settings
			.group(ModItemGroups.WEAPONS)
			.fireproof()
		);
	}
}
