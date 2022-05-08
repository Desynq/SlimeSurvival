package desynq.slimesurvival.item.material;

import java.util.List;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

public class WoolOfBat extends Item {
	public WoolOfBat(Settings settings) {
		super(settings);
	}

	@Override
	public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
		tooltip.add( new TranslatableText("item.slimesurvival.wool_of_bat.tooltip") );
		tooltip.add( new TranslatableText("item.slimesurvival.wool_of_bat.tooltip2") );
	}
}
