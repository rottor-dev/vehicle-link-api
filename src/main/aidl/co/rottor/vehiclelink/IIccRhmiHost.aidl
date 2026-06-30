package co.rottor.vehiclelink;

/** RHMI business host implemented by the main app; invoked from connector ICE servants. */
interface IIccRhmiHost {
    byte[] getHmiDescription();
    byte[] getMenuItems(in byte[] menuUuid, int rangeStart, int rangeCount);
    byte[] activateMenuItem(in byte[] menuUuid, int index);
    int findMenuItem(in byte[] menuUuid, in byte[] itemUuid);
    void invalidateMenu(in byte[] menuUuid, in byte[] menuStatusPayload);
    void updateMenuItems(in byte[] menuUuid, in byte[] updatedItemsPayload);
    void setLocale(int localeValue);
    void onNavigationSessionStarted(int localeValue);
    void onNavigationSessionStopped();
    void onPlayNextManeuverAnnouncement();
    void onStopRouteGuidance();
}
