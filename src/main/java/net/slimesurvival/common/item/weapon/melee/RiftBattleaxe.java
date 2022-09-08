package net.slimesurvival.common.item.weapon.melee;

import net.minecraft.item.AxeItem;
import net.slimesurvival.common.registry.ModItemGroups;
import net.slimesurvival.common.registry.ModToolMaterials;

public class RiftBattleaxe extends AxeItem {
	public RiftBattleaxe(Settings settings) {
		super(ModToolMaterials.MYSTITE, 39.0F, -3.2F, settings
			.group(ModItemGroups.WEAPONS)
			.fireproof()
		);
	}
}
