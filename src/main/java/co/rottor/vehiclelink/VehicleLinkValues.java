package co.rottor.vehiclelink;

/** Sentinel values for unset IPC scalar fields. */
public final class VehicleLinkValues {

    /** Unset floating-point field. */
    public static final float UNSET_FLOAT = Float.NaN;

    /** Unset integral scalar (speed, rpm, counts). Enum fields use proto ordinal 0 instead. */
    public static final int UNSET_INT = -1;

    private VehicleLinkValues() {
    }

    public static boolean isSet(float value) {
        return !Float.isNaN(value);
    }

    public static boolean isSet(int value) {
        return value != UNSET_INT;
    }
}
