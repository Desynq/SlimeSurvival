package net.slimesurvival.util;

import net.minecraft.util.Identifier;
import net.slimesurvival.SlimeSurvival;

public class RegistryHelper {
	
	public static Identifier id(String path) {
		return new Identifier(SlimeSurvival.MOD_ID, path);
	}
}
