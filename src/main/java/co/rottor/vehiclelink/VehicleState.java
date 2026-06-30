package co.rottor.vehiclelink;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Powertrain, chassis, comfort, and driver-aid state.
 *
 * <p>Field semantics align with {@code rrt.v1.VehicleState}. Enum fields store protobuf ordinals.</p>
 */
public final class VehicleState implements Parcelable {

    /** Vehicle speed in meters per hour ({@code rrt.v1.VehicleState.speed}). */
    public final int speedMetersPerHour;
    public final int rpm;
    /** {@code rrt.v1.Gear} ordinal. */
    public final int gear;
    /** Throttle opening in [0.0, 1.0], or {@link VehicleLinkValues#UNSET_FLOAT}. */
    public final float throttle;

    public final float trip1Km;
    public final float trip2Km;
    public final float totalKm;

    /** {@code rrt.v1.SystemState} ordinals. */
    public final int absBraking;
    public final int ascControl;

    /** {@code rrt.v1.RidingMode} ordinal. */
    public final int ridingMode;
    /** {@code rrt.v1.DrivingMode} ordinal. */
    public final int drivingMode;

    /** {@code rrt.v1.Damping} ordinal. */
    public final int damping;
    /** {@code rrt.v1.SpringPreload} ordinal. */
    public final int springPreload;
    /** {@code rrt.v1.DampingLevel} ordinal. */
    public final int dampingLevel;
    /** {@code rrt.v1.SpringPreloadLevel} ordinal. */
    public final int springPreloadLevel;

    /** {@code rrt.v1.Heating} ordinals. */
    public final int seatHeatingFront;
    public final int seatHeatingRear;
    public final int gripHeating;

    /** {@code rrt.v1.LaunchControl} ordinal. */
    public final int launchControl;
    /** {@code rrt.v1.RaceKit} ordinal. */
    public final int raceKit;
    /** {@code rrt.v1.DtcSetting} ordinal. */
    public final int dtcSetting;
    /** {@code rrt.v1.AudioSource} ordinal. */
    public final int audioSource;

    public final float timeSinceLapTriggerSec;
    public final float mileageSinceLapTriggerM;
    public final int lapTriggerCount;

    public VehicleState(
            int speedMetersPerHour,
            int rpm,
            int gear,
            float throttle,
            float trip1Km,
            float trip2Km,
            float totalKm,
            int absBraking,
            int ascControl,
            int ridingMode,
            int drivingMode,
            int damping,
            int springPreload,
            int dampingLevel,
            int springPreloadLevel,
            int seatHeatingFront,
            int seatHeatingRear,
            int gripHeating,
            int launchControl,
            int raceKit,
            int dtcSetting,
            int audioSource,
            float timeSinceLapTriggerSec,
            float mileageSinceLapTriggerM,
            int lapTriggerCount) {
        this.speedMetersPerHour = speedMetersPerHour;
        this.rpm = rpm;
        this.gear = gear;
        this.throttle = throttle;
        this.trip1Km = trip1Km;
        this.trip2Km = trip2Km;
        this.totalKm = totalKm;
        this.absBraking = absBraking;
        this.ascControl = ascControl;
        this.ridingMode = ridingMode;
        this.drivingMode = drivingMode;
        this.damping = damping;
        this.springPreload = springPreload;
        this.dampingLevel = dampingLevel;
        this.springPreloadLevel = springPreloadLevel;
        this.seatHeatingFront = seatHeatingFront;
        this.seatHeatingRear = seatHeatingRear;
        this.gripHeating = gripHeating;
        this.launchControl = launchControl;
        this.raceKit = raceKit;
        this.dtcSetting = dtcSetting;
        this.audioSource = audioSource;
        this.timeSinceLapTriggerSec = timeSinceLapTriggerSec;
        this.mileageSinceLapTriggerM = mileageSinceLapTriggerM;
        this.lapTriggerCount = lapTriggerCount;
    }

    protected VehicleState(Parcel in) {
        speedMetersPerHour = in.readInt();
        rpm = in.readInt();
        gear = in.readInt();
        throttle = in.readFloat();
        trip1Km = in.readFloat();
        trip2Km = in.readFloat();
        totalKm = in.readFloat();
        absBraking = in.readInt();
        ascControl = in.readInt();
        ridingMode = in.readInt();
        drivingMode = in.readInt();
        damping = in.readInt();
        springPreload = in.readInt();
        dampingLevel = in.readInt();
        springPreloadLevel = in.readInt();
        seatHeatingFront = in.readInt();
        seatHeatingRear = in.readInt();
        gripHeating = in.readInt();
        launchControl = in.readInt();
        raceKit = in.readInt();
        dtcSetting = in.readInt();
        audioSource = in.readInt();
        timeSinceLapTriggerSec = in.readFloat();
        mileageSinceLapTriggerM = in.readFloat();
        lapTriggerCount = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(speedMetersPerHour);
        dest.writeInt(rpm);
        dest.writeInt(gear);
        dest.writeFloat(throttle);
        dest.writeFloat(trip1Km);
        dest.writeFloat(trip2Km);
        dest.writeFloat(totalKm);
        dest.writeInt(absBraking);
        dest.writeInt(ascControl);
        dest.writeInt(ridingMode);
        dest.writeInt(drivingMode);
        dest.writeInt(damping);
        dest.writeInt(springPreload);
        dest.writeInt(dampingLevel);
        dest.writeInt(springPreloadLevel);
        dest.writeInt(seatHeatingFront);
        dest.writeInt(seatHeatingRear);
        dest.writeInt(gripHeating);
        dest.writeInt(launchControl);
        dest.writeInt(raceKit);
        dest.writeInt(dtcSetting);
        dest.writeInt(audioSource);
        dest.writeFloat(timeSinceLapTriggerSec);
        dest.writeFloat(mileageSinceLapTriggerM);
        dest.writeInt(lapTriggerCount);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<VehicleState> CREATOR = new Creator<VehicleState>() {
        @Override
        public VehicleState createFromParcel(Parcel in) {
            return new VehicleState(in);
        }

        @Override
        public VehicleState[] newArray(int size) {
            return new VehicleState[size];
        }
    };
}
