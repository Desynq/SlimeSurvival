package net.slimesurvival.common.item.weapon.melee;

import net.minecraft.item.AxeItem;
import net.slimesurvival.common.item.SSToolMaterials;
import net.slimesurvival.common.registry.ModItemGroups;

public class RiftBattleaxe extends AxeItem {
	public RiftBattleaxe(Settings settings) {
		super(SSToolMaterials.MYSTITE, 39.0F, -3.2F, settings
			.group(ModItemGroups.WEAPONS)
			.fireproof()
		);
	}
}
