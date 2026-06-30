package co.rottor.vehiclelink;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Vehicle-side slice of {@code rrt.v1.TimelineSample} (no {@code GeoPosition}).
 *
 * <p>Connectors merge ICC/OBD updates into this payload; the main app adds phone GPS when recording.</p>
 */
public final class VehicleSample implements Parcelable {

    public final long timestampMs;
    public final boolean connected;
    public final VehicleState vehicle;
    public final SensorState sensors;
    public final EnergyState energy;

    public VehicleSample(
            long timestampMs,
            boolean connected,
            VehicleState vehicle,
            SensorState sensors,
            EnergyState energy) {
        this.timestampMs = timestampMs;
        this.connected = connected;
        this.vehicle = vehicle;
        this.sensors = sensors;
        this.energy = energy;
    }

    protected VehicleSample(Parcel in) {
        timestampMs = in.readLong();
        connected = in.readByte() != 0;
        vehicle = in.readParcelable(VehicleState.class.getClassLoader());
        sensors = in.readParcelable(SensorState.class.getClassLoader());
        energy = in.readParcelable(EnergyState.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(timestampMs);
        dest.writeByte((byte) (connected ? 1 : 0));
        dest.writeParcelable(vehicle, flags);
        dest.writeParcelable(sensors, flags);
        dest.writeParcelable(energy, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<VehicleSample> CREATOR = new Creator<VehicleSample>() {
        @Override
        public VehicleSample createFromParcel(Parcel in) {
            return new VehicleSample(in);
        }

        @Override
        public VehicleSample[] newArray(int size) {
            return new VehicleSample[size];
        }
    };
}
