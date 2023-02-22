package net.slimesurvival.common.item;

import io.wispforest.owo.itemgroup.Icon;
import io.wispforest.owo.itemgroup.OwoItemGroup;
import net.minecraft.item.Items;
import net.slimesurvival.util.RegistryHelper;

public class SSItemGroup {

	public static final OwoItemGroup GROUP = OwoItemGroup
		.builder(RegistryHelper.id("item_group"), () -> Icon.of(Items.SLIME_BLOCK))
		.initializer(group -> {
			group.addTab(Icon.of(Items.STICK), "materials", null, true);
		})
		.build();
}
