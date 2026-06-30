package co.rottor.vehiclelink;

import co.rottor.vehiclelink.VehicleSample;
import co.rottor.vehiclelink.VehicleIdentityInfo;

interface IVehicleLinkCallback {
    void onConnectionChanged(boolean connected, String connectionId);
    void onVehicleSample(in VehicleSample sample);
    void onVehicleIdentity(in VehicleIdentityInfo identity);
}
