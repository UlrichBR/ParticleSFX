package hm.zelha.particlesfx.shapers;

import hm.zelha.particlesfx.particles.parents.Particle;
import hm.zelha.particlesfx.shapers.parents.ParticleShaper;
import org.apache.commons.lang3.Validate;
import org.bukkit.Location;
import org.bukkit.util.Vector;

import java.util.Collections;

public class ParticleCircle extends ParticleShaper {

    private Location center;
    private double xRadius;
    private double zRadius;
    private double trueFrequency;
    private boolean halfCircle;

    public ParticleCircle(Particle particle, Location center, double xRadius, double zRadius, double pitch, double yaw, double roll, double frequency, boolean halfCircle) {
        super(particle, pitch, yaw, roll, frequency);

        Validate.notNull(center, "Location cannot be null!");
        Validate.notNull(center.getWorld(), "Location's world cannot be null!");
        locationHelper.setWorld(center.getWorld());
        rot2.addOrigins(center);

        this.center = center;
        this.xRadius = xRadius;
        this.zRadius = zRadius;
        this.trueFrequency = (Math.PI * 2) / frequency;
        this.halfCircle = halfCircle;
    }

    public ParticleCircle(Particle particle, Location center, double xRadius, double zRadius, double pitch, double yaw, double roll, double frequency) {
        this(particle, center, xRadius, zRadius, pitch, yaw, roll, frequency, false);
    }

    public ParticleCircle(Particle particle, Location center, double xRadius, double zRadius, double pitch, double yaw, double roll, boolean halfCircle) {
        this(particle, center, xRadius, zRadius, pitch, yaw, roll, Math.PI / 50, halfCircle);
    }

    public ParticleCircle(Particle particle, Location center, double xRadius, double zRadius, double pitch, double yaw, double roll) {
        this(particle, center, xRadius, zRadius, pitch, yaw, roll, Math.PI / 50, false);
    }

    public ParticleCircle(Particle particle, Location center, double xRadius, double zRadius, double frequency) {
        this(particle, center, xRadius, zRadius, 0, 0, 0, frequency, false);
    }

    public ParticleCircle(Particle particle, Location center, double xRadius, double zRadius, boolean halfCircle) {
        this(particle, center, xRadius, zRadius, 0, 0, 0, Math.PI / 50, halfCircle);
    }

    public ParticleCircle(Particle particle, Location center, double xRadius, double zRadius) {
        this(particle, center, xRadius, zRadius, 0, 0, 0, Math.PI / 50, false);
    }

    @Override
    public void display() {
        for (double radian = 0; radian < Math.PI * ((halfCircle) ? 1 : 2); radian += trueFrequency) {
            rot.apply(vectorHelper.setX(xRadius * Math.cos(radian)).setY(0).setZ(zRadius * Math.sin(radian)));
            particle.display(center.add(vectorHelper));
            center.subtract(vectorHelper);
        }
    }

    @Override
    public void rotateAroundLocation(Location around, double pitch, double yaw, double roll) {
        rot2.add(pitch, yaw, roll);
        rot2.apply(around, Collections.singletonList(center));
    }

    @Override
    public void rotate(double pitch, double yaw, double roll) {
        rot.add(pitch, yaw, roll);
    }

    @Override
    public void move(double x, double y, double z) {
        center.add(new Vector(x, y, z));
    }

    public void setCenter(Location center) {
        this.center = center;

        rot2.reset();
        rot2.addOrigins(center);
    }

    public void setXRadius(double xRadius) {
        this.xRadius = xRadius;
    }

    public void setZRadius(double zRadius) {
        this.zRadius = zRadius;
    }

    public void setPitch(double pitch) {
        rot.setPitch(pitch);
    }

    public void setYaw(double yaw) {
        rot.setYaw(yaw);
    }

    public void setRoll(double roll) {
        rot.setRoll(roll);
    }

    @Override
    public void setFrequency(double frequency) {
        super.setFrequency(frequency);

        this.trueFrequency = (Math.PI * 2) / frequency;
    }

    public void setHalfCircle(boolean halfCircle) {
        this.halfCircle = halfCircle;
    }

    public Location getCenter() {
        return center;
    }

    public double getxRadius() {
        return xRadius;
    }

    public double getzRadius() {
        return zRadius;
    }

    public double getPitch() {
        return rot.getPitch();
    }

    public double getYaw() {
        return rot.getYaw();
    }

    public double getRoll() {
        return rot.getRoll();
    }

    public boolean isHalfCircle() {
        return halfCircle;
    }
}
