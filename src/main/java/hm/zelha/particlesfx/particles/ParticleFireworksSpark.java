package hm.zelha.particlesfx.particles;

import hm.zelha.particlesfx.particles.parents.TravellingParticle;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.util.Vector;

public class ParticleFireworksSpark extends TravellingParticle {
    public ParticleFireworksSpark(Location toGo, double offsetX, double offsetY, double offsetZ, int count) {
        super(Effect.FIREWORKS_SPARK, 0.09, null, toGo, offsetX, offsetY, offsetZ, count);
    }

    public ParticleFireworksSpark(Vector velocity, double offsetX, double offsetY, double offsetZ, int count) {
        super(Effect.FIREWORKS_SPARK, 0.09, velocity, null, offsetX, offsetY, offsetZ, count);
    }

    public ParticleFireworksSpark(Location toGo, double offsetX, double offsetY, double offsetZ) {
        this(toGo, offsetX, offsetY, offsetZ, 1);
    }

    public ParticleFireworksSpark(Vector velocity, double offsetX, double offsetY, double offsetZ) {
        this(velocity, offsetX, offsetY, offsetZ, 1);
    }

    public ParticleFireworksSpark(double offsetX, double offsetY, double offsetZ, int count) {
        this((Location) null, offsetX, offsetY, offsetZ, count);
    }

    public ParticleFireworksSpark(double offsetX, double offsetY, double offsetZ) {
        this((Location) null, offsetX, offsetY, offsetZ, 1);
    }

    public ParticleFireworksSpark(int count) {
        this((Location) null, 0, 0, 0, count);
    }

    public ParticleFireworksSpark(Location toGo) {
        this(toGo, 0, 0, 0, 1);
    }

    public ParticleFireworksSpark(Vector velocity) {
        this(velocity, 0, 0, 0, 1);
    }

    public ParticleFireworksSpark() {
        this((Location) null, 0, 0, 0, 1);
    }
}
