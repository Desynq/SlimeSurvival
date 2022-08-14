package net.slimesurvival.common.registry;

import net.minecraft.stat.StatFormatter;
import net.minecraft.stat.Stats;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.slimesurvival.SlimeSurvival;

public class ModStats {

	public static final Identifier PARRY = SlimeSurvival.ID("parry");




	public static void register() {
		Registry.register(Registry.CUSTOM_STAT, SlimeSurvival.ID("parry"), PARRY);
		Stats.CUSTOM.getOrCreateStat(PARRY, StatFormatter.DEFAULT);
	}
}
