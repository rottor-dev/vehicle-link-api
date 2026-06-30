package co.rottor.vehiclelink;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * IMU, environment, brake, tire, and fluid sensor state.
 *
 * <p>Field semantics align with {@code rrt.v1.SensorState}.</p>
 */
public final class SensorState implements Parcelable {

    public final float accLongitudinal;
    public final float accLateral;
    public final float accVertical;
    public final float bankingAngleDeg;
    public final float outsideTempC;
    public final float engineTempC;
    public final float brakePressureFrontBar;
    public final float brakePressureRearBar;
    public final float tirePressureFrontBar;
    public final float tirePressureRearBar;

    /** {@code rrt.v1.OilLevel} ordinal. */
    public final int engineOilLevel;
    /** {@code rrt.v1.CoolantTemperature} ordinal. */
    public final int oilCoolantTemp;
    /** {@code rrt.v1.FrontLiftOff} ordinal. */
    public final int frontLiftOff;
    /** {@code rrt.v1.TirePressure} ordinal. */
    public final int tirePressureStatus;
    /** {@code rrt.v1.Tire} ordinal. */
    public final int tirePressureAffected;

    public SensorState(
            float accLongitudinal,
            float accLateral,
            float accVertical,
            float bankingAngleDeg,
            float outsideTempC,
            float engineTempC,
            float brakePressureFrontBar,
            float brakePressureRearBar,
            float tirePressureFrontBar,
            float tirePressureRearBar,
            int engineOilLevel,
            int oilCoolantTemp,
            int frontLiftOff,
            int tirePressureStatus,
            int tirePressureAffected) {
        this.accLongitudinal = accLongitudinal;
        this.accLateral = accLateral;
        this.accVertical = accVertical;
        this.bankingAngleDeg = bankingAngleDeg;
        this.outsideTempC = outsideTempC;
        this.engineTempC = engineTempC;
        this.brakePressureFrontBar = brakePressureFrontBar;
        this.brakePressureRearBar = brakePressureRearBar;
        this.tirePressureFrontBar = tirePressureFrontBar;
        this.tirePressureRearBar = tirePressureRearBar;
        this.engineOilLevel = engineOilLevel;
        this.oilCoolantTemp = oilCoolantTemp;
        this.frontLiftOff = frontLiftOff;
        this.tirePressureStatus = tirePressureStatus;
        this.tirePressureAffected = tirePressureAffected;
    }

    protected SensorState(Parcel in) {
        accLongitudinal = in.readFloat();
        accLateral = in.readFloat();
        accVertical = in.readFloat();
        bankingAngleDeg = in.readFloat();
        outsideTempC = in.readFloat();
        engineTempC = in.readFloat();
        brakePressureFrontBar = in.readFloat();
        brakePressureRearBar = in.readFloat();
        tirePressureFrontBar = in.readFloat();
        tirePressureRearBar = in.readFloat();
        engineOilLevel = in.readInt();
        oilCoolantTemp = in.readInt();
        frontLiftOff = in.readInt();
        tirePressureStatus = in.readInt();
        tirePressureAffected = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeFloat(accLongitudinal);
        dest.writeFloat(accLateral);
        dest.writeFloat(accVertical);
        dest.writeFloat(bankingAngleDeg);
        dest.writeFloat(outsideTempC);
        dest.writeFloat(engineTempC);
        dest.writeFloat(brakePressureFrontBar);
        dest.writeFloat(brakePressureRearBar);
        dest.writeFloat(tirePressureFrontBar);
        dest.writeFloat(tirePressureRearBar);
        dest.writeInt(engineOilLevel);
        dest.writeInt(oilCoolantTemp);
        dest.writeInt(frontLiftOff);
        dest.writeInt(tirePressureStatus);
        dest.writeInt(tirePressureAffected);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SensorState> CREATOR = new Creator<SensorState>() {
        @Override
        public SensorState createFromParcel(Parcel in) {
            return new SensorState(in);
        }

        @Override
        public SensorState[] newArray(int size) {
            return new SensorState[size];
        }
    };
}
