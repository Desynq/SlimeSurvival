package net.slimesurvival.util;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.resource.language.I18n;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

public class TooltipHelper {
	public static final Text SHOW_DETAILS_TOOLTIP = new TranslatableText("tooltip.slimesurvival.show_details");
	public static final Text SHOW_HOW_TO_OBTAIN_TOOLTIP = new TranslatableText("tooltip.slimesurvival.show_how_to_obtain");
	public static final Text SHOW_LORE = new TranslatableText("tooltip.slimesurvival.show_lore");
	public static final Text SHOW_CREDITS = new TranslatableText("tooltip.slimesurvival.show_credits");



	public static void append(List<Text> tooltip, String translationKey) {
		String[] lines = I18n.translate(translationKey).split("\n");
		ArrayList<Text> texts = new ArrayList<Text>();

		for (String line : lines) {
			texts.add(new LiteralText(line));
		}

		tooltip.addAll(texts);
	}
}
