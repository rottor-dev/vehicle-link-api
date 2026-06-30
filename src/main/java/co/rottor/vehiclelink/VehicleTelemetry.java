package co.rottor.vehiclelink;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Lightweight vehicle metrics for UI and Android Auto.
 *
 * <p>Derived from {@link VehicleSample}; not sent directly over Binder.</p>
 */
public final class VehicleTelemetry implements Parcelable {

    public final boolean connected;
    public final long timestampMs;
    public final float speedKph;
    public final float engineRpm;
    public final int gear;
    public final float throttlePercent;
    public final float tirePressureFrontBar;
    public final float tirePressureRearBar;
    public final float bankingAngleDeg;
    public final float rangeKm;
    public final float energyLevelPercent;
    public final float outsideTemperatureC;
    public final int drivingMode;
    public final int ridingMode;
    public final int damping;
    public final int springPreload;

    public VehicleTelemetry(
            boolean connected,
            long timestampMs,
            float speedKph,
            float engineRpm,
            int gear,
            float throttlePercent,
            float tirePressureFrontBar,
            float tirePressureRearBar,
            float bankingAngleDeg,
            float rangeKm,
            float energyLevelPercent,
            float outsideTemperatureC,
            int drivingMode,
            int ridingMode,
            int damping,
            int springPreload) {
        this.connected = connected;
        this.timestampMs = timestampMs;
        this.speedKph = speedKph;
        this.engineRpm = engineRpm;
        this.gear = gear;
        this.throttlePercent = throttlePercent;
        this.tirePressureFrontBar = tirePressureFrontBar;
        this.tirePressureRearBar = tirePressureRearBar;
        this.bankingAngleDeg = bankingAngleDeg;
        this.rangeKm = rangeKm;
        this.energyLevelPercent = energyLevelPercent;
        this.outsideTemperatureC = outsideTemperatureC;
        this.drivingMode = drivingMode;
        this.ridingMode = ridingMode;
        this.damping = damping;
        this.springPreload = springPreload;
    }

    public static VehicleTelemetry fromSample(VehicleSample sample) {
        if (sample == null) {
            return disconnected();
        }
        VehicleState vehicle = sample.vehicle;
        SensorState sensors = sample.sensors;
        EnergyState energy = sample.energy;

        float speedKph = VehicleLinkValues.UNSET_FLOAT;
        float engineRpm = VehicleLinkValues.UNSET_FLOAT;
        int gear = VehicleLinkValues.UNSET_INT;
        float throttlePercent = VehicleLinkValues.UNSET_FLOAT;
        int drivingMode = VehicleLinkRrt.drivingModeOff();
        int ridingMode = VehicleLinkRrt.ridingModeOff();
        int damping = 0;
        int springPreload = 0;

        if (vehicle != null) {
            if (VehicleLinkValues.isSet(vehicle.speedMetersPerHour)) {
                speedKph = vehicle.speedMetersPerHour / 1000f;
            }
            if (VehicleLinkValues.isSet(vehicle.rpm)) {
                engineRpm = vehicle.rpm;
            }
            gear = vehicle.gear;
            if (VehicleLinkValues.isSet(vehicle.throttle)) {
                throttlePercent = vehicle.throttle * 100f;
            }
            drivingMode = vehicle.drivingMode;
            ridingMode = vehicle.ridingMode;
            damping = vehicle.damping;
            springPreload = vehicle.springPreload;
        }

        float tirePressureFrontBar = VehicleLinkValues.UNSET_FLOAT;
        float tirePressureRearBar = VehicleLinkValues.UNSET_FLOAT;
        float bankingAngleDeg = VehicleLinkValues.UNSET_FLOAT;
        float outsideTemperatureC = VehicleLinkValues.UNSET_FLOAT;
        if (sensors != null) {
            tirePressureFrontBar = sensors.tirePressureFrontBar;
            tirePressureRearBar = sensors.tirePressureRearBar;
            bankingAngleDeg = sensors.bankingAngleDeg;
            outsideTemperatureC = sensors.outsideTempC;
        }

        float rangeKm = VehicleLinkValues.UNSET_FLOAT;
        float energyLevelPercent = VehicleLinkValues.UNSET_FLOAT;
        if (energy != null) {
            rangeKm = energy.rangeKm;
            if (VehicleLinkValues.isSet(energy.energyLevel)) {
                energyLevelPercent = energy.energyLevel * 100f;
            }
        }

        return new VehicleTelemetry(
                sample.connected,
                sample.timestampMs,
                speedKph,
                engineRpm,
                gear,
                throttlePercent,
                tirePressureFrontBar,
                tirePressureRearBar,
                bankingAngleDeg,
                rangeKm,
                energyLevelPercent,
                outsideTemperatureC,
                drivingMode,
                ridingMode,
                damping,
                springPreload);
    }

    public static VehicleTelemetry disconnected() {
        return new VehicleTelemetry(
                false,
                0L,
                VehicleLinkValues.UNSET_FLOAT,
                VehicleLinkValues.UNSET_FLOAT,
                VehicleLinkValues.UNSET_INT,
                VehicleLinkValues.UNSET_FLOAT,
                VehicleLinkValues.UNSET_FLOAT,
                VehicleLinkValues.UNSET_FLOAT,
                VehicleLinkValues.UNSET_FLOAT,
                VehicleLinkValues.UNSET_FLOAT,
                VehicleLinkValues.UNSET_FLOAT,
                VehicleLinkValues.UNSET_FLOAT,
                VehicleLinkRrt.drivingModeOff(),
                VehicleLinkRrt.ridingModeOff(),
                0,
                0);
    }

    protected VehicleTelemetry(Parcel in) {
        connected = in.readByte() != 0;
        timestampMs = in.readLong();
        speedKph = in.readFloat();
        engineRpm = in.readFloat();
        gear = in.readInt();
        throttlePercent = in.readFloat();
        tirePressureFrontBar = in.readFloat();
        tirePressureRearBar = in.readFloat();
        bankingAngleDeg = in.readFloat();
        rangeKm = in.readFloat();
        energyLevelPercent = in.readFloat();
        outsideTemperatureC = in.readFloat();
        drivingMode = in.readInt();
        ridingMode = in.readInt();
        damping = in.readInt();
        springPreload = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (connected ? 1 : 0));
        dest.writeLong(timestampMs);
        dest.writeFloat(speedKph);
        dest.writeFloat(engineRpm);
        dest.writeInt(gear);
        dest.writeFloat(throttlePercent);
        dest.writeFloat(tirePressureFrontBar);
        dest.writeFloat(tirePressureRearBar);
        dest.writeFloat(bankingAngleDeg);
        dest.writeFloat(rangeKm);
        dest.writeFloat(energyLevelPercent);
        dest.writeFloat(outsideTemperatureC);
        dest.writeInt(drivingMode);
        dest.writeInt(ridingMode);
        dest.writeInt(damping);
        dest.writeInt(springPreload);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<VehicleTelemetry> CREATOR = new Creator<VehicleTelemetry>() {
        @Override
        public VehicleTelemetry createFromParcel(Parcel in) {
            return new VehicleTelemetry(in);
        }

        @Override
        public VehicleTelemetry[] newArray(int size) {
            return new VehicleTelemetry[size];
        }
    };
}
