package net.slimesurvival.power;

import io.github.apace100.apoli.power.Power;
import io.github.apace100.apoli.power.PowerType;
import io.github.apace100.apoli.power.PowerTypeReference;
import net.minecraft.util.Identifier;

public class Powers {
	public static final PowerType<Power> BOUNCY = new PowerTypeReference<>(new Identifier("slimesurvival", "bouncy"));
}