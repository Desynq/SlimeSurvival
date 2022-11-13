package net.slimesurvival.common.item;

import io.wispforest.owo.itemgroup.Icon;
import io.wispforest.owo.itemgroup.OwoItemGroup;
import io.wispforest.owo.itemgroup.gui.ItemGroupButton;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.slimesurvival.common.registry.ModItems;
import net.slimesurvival.common.registry.ModItemsNew;

public class SSItemGroups extends OwoItemGroup {

	public SSItemGroups(Identifier id) {
		super(id);
	}



	public enum Tabs {
		MISC,
		BLOCKS,
		MATERIALS,
		CRAFTING,
		TRINKETS,
		ARMOR,
		TOOLS,
		MELEE_WEAPONS,
		RANGED_WEAPONS,
		RANGED_AMMO,
		ICONS
	}



	@Override
	protected void setup() {
		setStackHeight(5);
		keepStaticTitle();

		addTab(Items.LAVA_BUCKET, "misc");

		addTab(ModItems.GMOD_BLOCK, "blocks");

		addTab(ModItemsNew.POLAR_BEAR_FUR, "materials");

		addTab(ModItemsNew.MIXING_BOWL, "crafting");

		addTab(ModItems.UTILITY_BELT, "trinkets");

		addTab(ModItems.MYSTITE_HELMET, "armor");

		addTab(ModItemsNew.MOLTEN_PICKAXE, "tools");

		addTab(ModItems.RIFT_BATTLEAXE, "melee_weapons");

		addTab(ModItems.MYSTITE_SHORTBOW, "ranged_weapons");

		addTab(Items.ARROW, "ranged_ammo");

		addTab(Items.GLASS_PANE, "icons");



		addButton(ItemGroupButton.github("https://github.com/Desynq/SlimeSurvival"));
	}

	private void addTab(Item item, String name) {
		this.addTab(Icon.of(item), name, null);
	}



	@Override
	public ItemStack createIcon() {
		return new ItemStack(Items.SLIME_BALL);
	}
}
