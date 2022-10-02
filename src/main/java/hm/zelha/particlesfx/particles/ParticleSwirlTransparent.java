package hm.zelha.particlesfx.particles;

import hm.zelha.particlesfx.particles.parents.ColorableParticle;
import net.minecraft.server.v1_8_R3.EnumParticle;
import org.bukkit.Color;

import javax.annotation.Nullable;

public class ParticleSwirlTransparent extends ColorableParticle {
    public ParticleSwirlTransparent(@Nullable Color color, int brightness, double offsetX, double offsetY, double offsetZ, int count) {
        super(EnumParticle.SPELL_MOB_AMBIENT, color, brightness, offsetX, offsetY, offsetZ, count);
    }

    public ParticleSwirlTransparent(double offsetX, double offsetY, double offsetZ, int count) {
        this(null, 100, offsetX, offsetY, offsetZ, count);
    }

    public ParticleSwirlTransparent(double offsetX, double offsetY, double offsetZ) {
        this(null, 100, offsetX, offsetY, offsetZ, 1);
    }

    public ParticleSwirlTransparent(@Nullable Color color, int brightness, int count) {
        this(color, brightness, 0, 0, 0, count);
    }

    public ParticleSwirlTransparent(@Nullable Color color, int brightness) {
        this(color, brightness, 0, 0, 0, 1);
    }

    public ParticleSwirlTransparent(@Nullable Color color) {
        this(color, 100, 0, 0, 0, 1);
    }

    public ParticleSwirlTransparent(int count) {
        this(null, 100, 0, 0, 0, count);
    }

    public ParticleSwirlTransparent() {
        this(null, 100, 0, 0, 0, 1);
    }
}
