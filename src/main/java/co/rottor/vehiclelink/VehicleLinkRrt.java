package co.rottor.vehiclelink;

import co.rottor.rrt.v1.RrtProto;

/**
 * Helpers for {@link VehicleState}, {@link SensorState}, and {@link EnergyState} enum fields.
 *
 * <p>IPC parcelables store {@code rrt.v1.*} protobuf numbers; use this class for typed access.</p>
 */
public final class VehicleLinkRrt {

    private VehicleLinkRrt() {
    }

    public static int drivingModeOff() {
        return RrtProto.DrivingMode.DRIVING_MODE_OFF.getNumber();
    }

    public static int ridingModeOff() {
        return RrtProto.RidingMode.RIDING_MODE_OFF.getNumber();
    }

    public static RrtProto.DrivingMode parseDrivingMode(int value) {
        RrtProto.DrivingMode parsed = RrtProto.DrivingMode.forNumber(value);
        return parsed != null ? parsed : RrtProto.DrivingMode.DRIVING_MODE_OFF;
    }

    public static RrtProto.RidingMode parseRidingMode(int value) {
        RrtProto.RidingMode parsed = RrtProto.RidingMode.forNumber(value);
        return parsed != null ? parsed : RrtProto.RidingMode.RIDING_MODE_OFF;
    }

    public static RrtProto.Gear parseGear(int value) {
        RrtProto.Gear parsed = RrtProto.Gear.forNumber(value);
        return parsed != null ? parsed : RrtProto.Gear.GEAR_IDLING;
    }

    public static RrtProto.Damping parseDamping(int value) {
        RrtProto.Damping parsed = RrtProto.Damping.forNumber(value);
        return parsed != null ? parsed : RrtProto.Damping.DAMPING_SOFT;
    }

    public static RrtProto.SpringPreload parseSpringPreload(int value) {
        RrtProto.SpringPreload parsed = RrtProto.SpringPreload.forNumber(value);
        return parsed != null ? parsed : RrtProto.SpringPreload.SPRING_PRELOAD_SINGLE;
    }
}
