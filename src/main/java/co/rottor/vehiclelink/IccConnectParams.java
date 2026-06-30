package co.rottor.vehiclelink;

import android.os.Parcel;
import android.os.Parcelable;

/** Bluetooth endpoint parameters for ICC ICE connection (discovered by the main app). */
public final class IccConnectParams implements Parcelable {

    public final String deviceAddress;
    public final String deviceUuid;
    public final String deviceName;
    /** Local phone Bluetooth MAC used for IceBT published endpoints. */
    public final String localBtAddress;

    public IccConnectParams(
            String deviceAddress,
            String deviceUuid,
            String deviceName,
            String localBtAddress) {
        this.deviceAddress = deviceAddress;
        this.deviceUuid = deviceUuid;
        this.deviceName = deviceName;
        this.localBtAddress = localBtAddress;
    }

    protected IccConnectParams(Parcel in) {
        deviceAddress = in.readString();
        deviceUuid = in.readString();
        deviceName = in.readString();
        localBtAddress = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(deviceAddress);
        dest.writeString(deviceUuid);
        dest.writeString(deviceName);
        dest.writeString(localBtAddress);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<IccConnectParams> CREATOR = new Creator<IccConnectParams>() {
        @Override
        public IccConnectParams createFromParcel(Parcel in) {
            return new IccConnectParams(in);
        }

        @Override
        public IccConnectParams[] newArray(int size) {
            return new IccConnectParams[size];
        }
    };
}
