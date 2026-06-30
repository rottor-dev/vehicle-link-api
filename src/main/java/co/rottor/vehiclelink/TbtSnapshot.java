package co.rottor.vehiclelink;

import android.os.Parcel;
import android.os.Parcelable;

/** Turn-by-turn navigation snapshot for vehicle displays. */
public final class TbtSnapshot implements Parcelable {

    public final long timestampMs;
    public final String maneuverText;
    public final String distanceText;
    public final String etaText;
    public final int maneuverIconType;
    public final int distanceMeters;
    public final int remainingSeconds;

    public TbtSnapshot(
            long timestampMs,
            String maneuverText,
            String distanceText,
            String etaText,
            int maneuverIconType,
            int distanceMeters,
            int remainingSeconds) {
        this.timestampMs = timestampMs;
        this.maneuverText = maneuverText;
        this.distanceText = distanceText;
        this.etaText = etaText;
        this.maneuverIconType = maneuverIconType;
        this.distanceMeters = distanceMeters;
        this.remainingSeconds = remainingSeconds;
    }

    protected TbtSnapshot(Parcel in) {
        timestampMs = in.readLong();
        maneuverText = in.readString();
        distanceText = in.readString();
        etaText = in.readString();
        maneuverIconType = in.readInt();
        distanceMeters = in.readInt();
        remainingSeconds = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(timestampMs);
        dest.writeString(maneuverText);
        dest.writeString(distanceText);
        dest.writeString(etaText);
        dest.writeInt(maneuverIconType);
        dest.writeInt(distanceMeters);
        dest.writeInt(remainingSeconds);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<TbtSnapshot> CREATOR = new Creator<TbtSnapshot>() {
        @Override
        public TbtSnapshot createFromParcel(Parcel in) {
            return new TbtSnapshot(in);
        }

        @Override
        public TbtSnapshot[] newArray(int size) {
            return new TbtSnapshot[size];
        }
    };
}
