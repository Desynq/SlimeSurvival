package net.slimesurvival.common.power;

import io.github.apace100.apoli.power.Power;
import io.github.apace100.apoli.power.PowerType;
import io.github.apace100.apoli.power.factory.PowerFactory;
import io.github.apace100.calio.data.SerializableData;
import io.github.apace100.calio.data.SerializableDataTypes;
import net.minecraft.entity.LivingEntity;
import net.slimesurvival.SlimeSurvival;

public class BouncyPower extends Power {
	private final float velocity;

	public BouncyPower(PowerType<?> type, LivingEntity livingEntity, float velocity) {
		super(type, livingEntity);
		this.velocity = velocity;
	}



	public float getVelocity() {
		return velocity;
	}



	public static PowerFactory<?> getFactory() {
		return new PowerFactory<BouncyPower>(SlimeSurvival.ID("bouncy"),
			new SerializableData()
				.add("velocity", SerializableDataTypes.FLOAT),
			data -> (type, entity) ->
				new BouncyPower(type, entity, data.getFloat("velocity"))
		).allowCondition();
	}
}
