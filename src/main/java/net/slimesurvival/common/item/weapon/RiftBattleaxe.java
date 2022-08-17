package net.slimesurvival.common.item.weapon;

import java.util.List;

import org.jetbrains.annotations.Nullable;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.slimesurvival.common.interfaces.ExtendableTooltipProvider;

public class RiftBattleaxe extends AxeItem implements ExtendableTooltipProvider {
	public RiftBattleaxe(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
		super(material, attackDamage, attackSpeed, settings);
	}





	@Override
	public String tooltipTranslationKey() {
		return this.getTranslationKey();
	}
	@Override
	public boolean hasDetails() {
		return true;
	}
	
	@Override
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		tryAppend(tooltip);
	}
}
