# vehicle-link-api

Apache-2.0 AIDL IPC contract between the Rottor app and vehicle connectors (telemetry, TBT, map projection).

## Related projects

| Repository | Role |
|------------|------|
| [rrt-proto](https://github.com/rottor-dev/rrt-proto) | Canonical `.rrt` schema and vehicle enum semantics (git submodule) |
| [connector-icc](https://github.com/rottor-dev/connector-icc) | GPL ICC/ICE connector APK |
| Rottor app | Navigation, recording, Android Auto |

Enum fields in `VehicleState` / `SensorState` / `EnergyState` store **`rrt.v1.*` protobuf ordinals**.
Use `VehicleLinkRrt` or `co.rottor.rrt.v1.RrtProto` for typed access — do not duplicate enums here.

## Setup

```bash
git clone --recurse-submodules git@github.com:rottor-dev/vehicle-link-api.git
# or after clone:
git submodule update --init --recursive
```

## Usage in Gradle

**Standalone checkout** (includes `rrt-proto` submodule — see `settings.gradle`):

```gradle
implementation project(':vehicle-link-api')
```

**Inside the Rottor monorepo** (sibling modules at the repo root):

```gradle
// settings.gradle
include ':rrt-proto'
include ':vehicle-link-api'

// app/build.gradle
implementation project(':vehicle-link-api')
```

`vehicle-link-api` exposes `rrt-proto` as an `api` dependency, so consumers receive `RrtProto` types transitively.

## Binding (ICC connector)

| Constant | Value |
|----------|-------|
| `VehicleLinkContract.API_VERSION` | `3` |
| `CONNECTOR_ICC_PACKAGE` | `co.rottor.connector.icc` |
| `ACTION_BIND_VEHICLE_LINK` | `co.rottor.vehiclelink.BIND` |
| `PERMISSION_BIND` | `co.rottor.vehiclelink.permission.BIND` |

## API surface

### `IVehicleLink` (main app → connector)

| Method | Purpose |
|--------|---------|
| `getApiVersion()` | Contract version |
| `getConnectionId()` / `isConnected()` | Link state |
| `registerCallback` / `unregisterCallback` | Event subscription |
| `registerRhmiHost(IIccRhmiHost)` | RHMI business host (main app → connector) |
| `connect(IccConnectParams)` / `disconnect()` | ICC session lifecycle |
| `pushTbt(TbtSnapshot)` | TBT projection |
| `pushMapFrame(MapFrame)` | Map frame projection |
| `pushNavigationIceMessage` | Navigation payloads (connector encodes to ICE) |
| `pushRhmiInvalidateMenu` / `pushRhmiUpdateMenuItems` | RHMI menu sync to vehicle |

### `IVehicleLinkCallback` (connector → main app)

| Method | Purpose |
|--------|---------|
| `onConnectionChanged` | Link up/down |
| `onVehicleSample` | Vehicle telemetry for UI and recording |
| `onVehicleIdentity` | ICC vehicle identity after connect |

### Data model

| Type | Role |
|------|------|
| `VehicleSample` | Top-level callback payload |
| `VehicleState` | Mirrors `rrt.v1.VehicleState` |
| `SensorState` | Mirrors `rrt.v1.SensorState` |
| `EnergyState` | Mirrors `rrt.v1.EnergyState` |
| `TbtSnapshot` | Turn-by-turn display snapshot |
| `MapFrame` | Compressed map frame (`PIXEL_FORMAT_*` are IPC-only) |
| `VehicleTelemetry` | UI summary from `VehicleTelemetry.fromSample()` |
| `VehicleLinkRrt` | Helpers over `RrtProto` enum values |
| `VehicleLinkValues` | `UNSET_FLOAT` / `UNSET_INT` sentinels |

Geo position is **not** part of IPC — the main app merges phone GPS when writing `TimelineSample`.

## Build

Standalone:

```bash
./gradlew assembleRelease
```

Inside the Rottor monorepo:

```bash
./gradlew :vehicle-link-api:assembleRelease
```

## License

Apache License 2.0. See [LICENSE](LICENSE).
