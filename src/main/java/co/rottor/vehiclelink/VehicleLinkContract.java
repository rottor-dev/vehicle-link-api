package co.rottor.vehiclelink;

/** Shared constants for binding the ICC connector from the main app. */
public final class VehicleLinkContract {

    public static final int API_VERSION = 3;

    public static final String CONNECTOR_ICC_PACKAGE = "co.rottor.connector.icc";
    public static final String ACTION_BIND_VEHICLE_LINK = "co.rottor.vehiclelink.BIND";
    public static final String PERMISSION_BIND = "co.rottor.vehiclelink.permission.BIND";

    /** {@link IVehicleLink#pushNavigationIceMessage} payload types (ICE object class hash). */
    public static final int NAV_MSG_ROUTING_STATE = 1;
    public static final int NAV_MSG_MANEUVER_DATA = 2;
    public static final int NAV_MSG_POSITION_STATUS = 3;
    public static final int NAV_MSG_GUIDING_STEP = 4;
    public static final int NAV_MSG_SPEED_LIMIT = 5;
    public static final int NAV_MSG_TRAFFIC_STATUS = 6;
    public static final int NAV_MSG_LANE_INFO = 7;
    public static final int NAV_MSG_DESTINATION = 8;

    private VehicleLinkContract() {
    }
}
