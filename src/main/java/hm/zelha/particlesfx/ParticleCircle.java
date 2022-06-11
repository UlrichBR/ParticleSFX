package hm.zelha.particlesfx;

import org.apache.commons.lang3.Validate;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

public class ParticleCircle {

    //tomorrow optimize the rotation methods so they dont recalculate when its not necessary

    private BukkitTask animator = null;
    private Effect particle;
    private Location center;
    private double xRadius;
    private double zRadius;
    private double pitch = 0;
    private double yaw = 0;
    private double roll = 0;
    private boolean halfCircle = false;
    private double color = 0;

    public ParticleCircle(Effect particle, Location center, double xRadius, double zRadius, double pitch, double yaw, double roll, boolean halfCircle) {
        this(particle, center, xRadius, zRadius, pitch, yaw, roll);

        this.halfCircle = halfCircle;
    }

    public ParticleCircle(Effect particle, Location center, double xRadius, double zRadius, double pitch, double yaw, double roll) {
        this(particle, center, xRadius, zRadius);

        this.pitch = pitch;
        this.yaw = yaw;
        this.roll = roll;
    }

    public ParticleCircle(Effect particle, Location center, double xRadius, double zRadius, boolean halfCircle) {
        this(particle, center, xRadius, zRadius);

        this.halfCircle = halfCircle;
    }

    public ParticleCircle(Effect particle, Location center, double xRadius, double zRadius) {
        Validate.isTrue(particle.getType() == Effect.Type.PARTICLE, "Effect must be of Type.PARTICLE!");

        this.particle = particle;
        this.center = center;
        this.xRadius = xRadius;
        this.zRadius = zRadius;

        start();
    }

    public void start() {
        if (animator != null) return;

        animator = new BukkitRunnable() {
            @Override
            public void run() {
                for (double radian = 0; radian < Math.PI * ((halfCircle) ? 1 : 2); radian += Math.PI / (20 * ((xRadius + zRadius) * 0.25))) {
                    Vector addition = new Vector(xRadius * Math.cos(radian), 0, zRadius * Math.sin(radian));

                    applyPitch(addition);
                    applyYaw(addition);
                    applyRoll(addition);

                    center.getWorld().spigot().playEffect(center.add(addition), particle, 0, 0, 0, 0, 0, 0, 1, 150);
                    center.subtract(addition);
                }
            }
        }.runTaskTimer(Main.getPlugin(), 0, 1);
    }

    public void stop() {
        if (animator == null) return;

        animator.cancel();
        animator = null;
    }

    private void applyPitch(Vector v) {
        if (pitch == 0) return;

        double y, z, cos, sin, angle;
        angle = Math.toRadians(pitch);
        cos = Math.cos(angle);
        sin = Math.sin(angle);
        y = v.getY() * cos - v.getZ() * sin;
        z = v.getY() * sin + v.getZ() * cos;

        v.setY(y).setZ(z);
    }

    private void applyYaw(Vector v) {
        if (yaw == 0) return;

        double x, z, cos, sin, angle;
        angle = -yaw;
        angle = Math.toRadians(angle);
        cos = Math.cos(angle);
        sin = Math.sin(angle);
        x = v.getX() * cos + v.getZ() * sin;
        z = v.getX() * -sin + v.getZ() * cos;

        v.setX(x).setZ(z);
    }

    private void applyRoll(Vector v) {
        if (roll == 0) return;

        double x, y, cos, sin, angle;
        angle = Math.toRadians(roll);
        cos = Math.cos(angle);
        sin = Math.sin(angle);
        x = v.getX() * cos - v.getY() * sin;
        y = v.getX() * sin + v.getY() * cos;

        v.setX(x).setY(y);
    }

    public void setParticle(Effect particle) {
        Validate.isTrue(particle.getType() == Effect.Type.PARTICLE, "Effect must be of Type.PARTICLE!");

        this.particle = particle;
    }

    public void setCenter(Location center) {
        this.center = center;
    }

    public void setxRadius(double xRadius) {
        this.xRadius = xRadius;
    }

    public void setzRadius(double zRadius) {
        this.zRadius = zRadius;
    }

    public void setPitch(double pitch) {
        this.pitch = pitch;
    }

    public void setYaw(double yaw) {
        this.yaw = yaw;
    }

    public void setRoll(double roll) {
        this.roll = roll;
    }

    public void setColor(double color) {
        this.color = color;
    }

    public void setHalfCircle(boolean halfCircle) {
        this.halfCircle = halfCircle;
    }

    public Effect getParticle() {
        return particle;
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
        return pitch;
    }

    public double getYaw() {
        return yaw;
    }

    public double getRoll() {
        return roll;
    }

    public double getColor() {
        return color;
    }

    public boolean isHalfCircle() {
        return halfCircle;
    }
}
