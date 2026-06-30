package co.rottor.vehiclelink;

import co.rottor.vehiclelink.IVehicleLinkCallback;
import co.rottor.vehiclelink.IIccRhmiHost;
import co.rottor.vehiclelink.IccConnectParams;
import co.rottor.vehiclelink.TbtSnapshot;
import co.rottor.vehiclelink.MapFrame;

interface IVehicleLink {
    int getApiVersion();
    String getConnectionId();
    boolean isConnected();
    void registerCallback(in IVehicleLinkCallback callback);
    void unregisterCallback(in IVehicleLinkCallback callback);
    void registerRhmiHost(in IIccRhmiHost host);
    void connect(in IccConnectParams params);
    void disconnect();
    void pushTbt(in TbtSnapshot snapshot);
    void pushMapFrame(in MapFrame frame);
    void pushNavigationIceMessage(int messageType, in byte[] payload);
    void pushRhmiInvalidateMenu(in byte[] menuUuid, in byte[] menuStatusPayload);
    void pushRhmiUpdateMenuItems(in byte[] menuUuid, in byte[] updatedItemsPayload);
}
