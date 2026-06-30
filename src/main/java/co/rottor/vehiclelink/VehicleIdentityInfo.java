package co.rottor.vehiclelink;

import android.os.Parcel;
import android.os.Parcelable;

/** Vehicle identity from ICC SessionFactory, for bike DB resolution in the main app. */
public final class VehicleIdentityInfo implements Parcelable {

    public final byte[] vehicleId;
    /** {@code ConnectedRide.VehicleType} wire value. */
    public final int vehicleType;

    public VehicleIdentityInfo(byte[] vehicleId, int vehicleType) {
        this.vehicleId = vehicleId;
        this.vehicleType = vehicleType;
    }

    protected VehicleIdentityInfo(Parcel in) {
        vehicleId = in.createByteArray();
        vehicleType = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByteArray(vehicleId);
        dest.writeInt(vehicleType);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<VehicleIdentityInfo> CREATOR = new Creator<VehicleIdentityInfo>() {
        @Override
        public VehicleIdentityInfo createFromParcel(Parcel in) {
            return new VehicleIdentityInfo(in);
        }

        @Override
        public VehicleIdentityInfo[] newArray(int size) {
            return new VehicleIdentityInfo[size];
        }
    };
}
