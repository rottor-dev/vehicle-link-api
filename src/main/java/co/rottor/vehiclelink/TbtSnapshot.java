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
    /** ICC maneuver index (0-based). */
    public final int maneuverIndex;
    public final int totalManeuvers;
    /** ICC {@code GuidingStep} enum wire value. */
    public final int guidingStepWire;
    public final int nearDistanceMeters;
    public final int distanceToDestinationMeters;
    public final String nextRoadLabel;
    public final String exitNumber;
    public final String exitText;

    public TbtSnapshot(
            long timestampMs,
            String maneuverText,
            String distanceText,
            String etaText,
            int maneuverIconType,
            int distanceMeters,
            int remainingSeconds,
            int maneuverIndex,
            int totalManeuvers,
            int guidingStepWire,
            int nearDistanceMeters,
            int distanceToDestinationMeters,
            String nextRoadLabel,
            String exitNumber,
            String exitText) {
        this.timestampMs = timestampMs;
        this.maneuverText = maneuverText != null ? maneuverText : "";
        this.distanceText = distanceText != null ? distanceText : "";
        this.etaText = etaText != null ? etaText : "";
        this.maneuverIconType = maneuverIconType;
        this.distanceMeters = distanceMeters;
        this.remainingSeconds = remainingSeconds;
        this.maneuverIndex = maneuverIndex;
        this.totalManeuvers = totalManeuvers;
        this.guidingStepWire = guidingStepWire;
        this.nearDistanceMeters = nearDistanceMeters;
        this.distanceToDestinationMeters = distanceToDestinationMeters;
        this.nextRoadLabel = nextRoadLabel != null ? nextRoadLabel : "";
        this.exitNumber = exitNumber != null ? exitNumber : "";
        this.exitText = exitText != null ? exitText : "";
    }

    protected TbtSnapshot(Parcel in) {
        timestampMs = in.readLong();
        maneuverText = in.readString();
        distanceText = in.readString();
        etaText = in.readString();
        maneuverIconType = in.readInt();
        distanceMeters = in.readInt();
        remainingSeconds = in.readInt();
        maneuverIndex = in.readInt();
        totalManeuvers = in.readInt();
        guidingStepWire = in.readInt();
        nearDistanceMeters = in.readInt();
        distanceToDestinationMeters = in.readInt();
        nextRoadLabel = in.readString();
        exitNumber = in.readString();
        exitText = in.readString();
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
        dest.writeInt(maneuverIndex);
        dest.writeInt(totalManeuvers);
        dest.writeInt(guidingStepWire);
        dest.writeInt(nearDistanceMeters);
        dest.writeInt(distanceToDestinationMeters);
        dest.writeString(nextRoadLabel);
        dest.writeString(exitNumber);
        dest.writeString(exitText);
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
