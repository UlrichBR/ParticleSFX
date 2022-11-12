package hm.zelha.particlesfx.shapers.parents;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.util.Vector;

public interface Shape {

    public void start();

    public void stop();

    public void display();

    public void rotate(double pitch, double yaw, double roll);

    public void rotateAroundLocation(Location around, double pitch, double yaw, double roll);

    public void face(Location toFace);

    public void faceAroundLocation(Location toFace, Location around);

    public void move(double x, double y, double z);

    public void move(Vector vector);

    public void move(Location location);

    public Shape clone();

    public void setWorld(World world);

    public void setRotation(double pitch, double yaw, double roll);

    public void setPitch(double pitch);

    public void setYaw(double yaw);

    public void setRoll(double roll);

    public void setAroundRotation(Location around, double pitch, double yaw, double roll);

    public void setAroundPitch(Location around, double pitch);

    public void setAroundYaw(Location around, double yaw);

    public void setAroundRoll(Location around, double roll);

    public double getPitch();

    public double getYaw();

    public double getRoll();

    public double getAroundPitch();

    public double getAroundYaw();

    public double getAroundRoll();

    public int getLocationAmount();

    public double getTotalDistance();

    public Location getClonedCenter();
}
