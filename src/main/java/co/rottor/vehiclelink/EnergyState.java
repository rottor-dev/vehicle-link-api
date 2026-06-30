package co.rottor.vehiclelink;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Fuel, battery, range, and consumption state.
 *
 * <p>Field semantics align with {@code rrt.v1.EnergyState}.</p>
 */
public final class EnergyState implements Parcelable {

    public final float energyLevel;
    public final float stateOfCharge;
    public final int chargingTimeMin;
    /** {@code rrt.v1.ChargingMode} ordinal. */
    public final int chargingMode;
    public final float rangeKm;
    public final float rangeElectricKm;
    public final float energyDischargeWh;
    public final float energyChargeWh;
    public final float consumptionL100km;
    public final float avgConsumptionL100km;
    public final float avgConsumptionKwh100km;
    public final float avgConsumptionRangeL100km;
    public final float avgConsumptionTrip1Kwh100km;
    public final float avgConsumptionTrip2Kwh100km;

    public EnergyState(
            float energyLevel,
            float stateOfCharge,
            int chargingTimeMin,
            int chargingMode,
            float rangeKm,
            float rangeElectricKm,
            float energyDischargeWh,
            float energyChargeWh,
            float consumptionL100km,
            float avgConsumptionL100km,
            float avgConsumptionKwh100km,
            float avgConsumptionRangeL100km,
            float avgConsumptionTrip1Kwh100km,
            float avgConsumptionTrip2Kwh100km) {
        this.energyLevel = energyLevel;
        this.stateOfCharge = stateOfCharge;
        this.chargingTimeMin = chargingTimeMin;
        this.chargingMode = chargingMode;
        this.rangeKm = rangeKm;
        this.rangeElectricKm = rangeElectricKm;
        this.energyDischargeWh = energyDischargeWh;
        this.energyChargeWh = energyChargeWh;
        this.consumptionL100km = consumptionL100km;
        this.avgConsumptionL100km = avgConsumptionL100km;
        this.avgConsumptionKwh100km = avgConsumptionKwh100km;
        this.avgConsumptionRangeL100km = avgConsumptionRangeL100km;
        this.avgConsumptionTrip1Kwh100km = avgConsumptionTrip1Kwh100km;
        this.avgConsumptionTrip2Kwh100km = avgConsumptionTrip2Kwh100km;
    }

    protected EnergyState(Parcel in) {
        energyLevel = in.readFloat();
        stateOfCharge = in.readFloat();
        chargingTimeMin = in.readInt();
        chargingMode = in.readInt();
        rangeKm = in.readFloat();
        rangeElectricKm = in.readFloat();
        energyDischargeWh = in.readFloat();
        energyChargeWh = in.readFloat();
        consumptionL100km = in.readFloat();
        avgConsumptionL100km = in.readFloat();
        avgConsumptionKwh100km = in.readFloat();
        avgConsumptionRangeL100km = in.readFloat();
        avgConsumptionTrip1Kwh100km = in.readFloat();
        avgConsumptionTrip2Kwh100km = in.readFloat();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeFloat(energyLevel);
        dest.writeFloat(stateOfCharge);
        dest.writeInt(chargingTimeMin);
        dest.writeInt(chargingMode);
        dest.writeFloat(rangeKm);
        dest.writeFloat(rangeElectricKm);
        dest.writeFloat(energyDischargeWh);
        dest.writeFloat(energyChargeWh);
        dest.writeFloat(consumptionL100km);
        dest.writeFloat(avgConsumptionL100km);
        dest.writeFloat(avgConsumptionKwh100km);
        dest.writeFloat(avgConsumptionRangeL100km);
        dest.writeFloat(avgConsumptionTrip1Kwh100km);
        dest.writeFloat(avgConsumptionTrip2Kwh100km);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<EnergyState> CREATOR = new Creator<EnergyState>() {
        @Override
        public EnergyState createFromParcel(Parcel in) {
            return new EnergyState(in);
        }

        @Override
        public EnergyState[] newArray(int size) {
            return new EnergyState[size];
        }
    };
}
