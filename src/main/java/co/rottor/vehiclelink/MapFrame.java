package co.rottor.vehiclelink;

import android.os.Parcel;
import android.os.Parcelable;

/** Compressed map frame for ICC or other projection sinks. */
public final class MapFrame implements Parcelable {

    /** IPC-specific pixel formats (not part of {@code rrt.v1}). */
    public static final int PIXEL_FORMAT_UNKNOWN = 0;
    public static final int PIXEL_FORMAT_JPEG = 1;
    public static final int PIXEL_FORMAT_PNG = 2;
    public static final int PIXEL_FORMAT_RGBA_8888 = 3;

    public final long timestampMs;
    public final int widthPx;
    public final int heightPx;
    public final int pixelFormat;
    public final byte[] payload;

    public MapFrame(long timestampMs, int widthPx, int heightPx, int pixelFormat, byte[] payload) {
        this.timestampMs = timestampMs;
        this.widthPx = widthPx;
        this.heightPx = heightPx;
        this.pixelFormat = pixelFormat;
        this.payload = payload;
    }

    protected MapFrame(Parcel in) {
        timestampMs = in.readLong();
        widthPx = in.readInt();
        heightPx = in.readInt();
        pixelFormat = in.readInt();
        payload = in.createByteArray();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(timestampMs);
        dest.writeInt(widthPx);
        dest.writeInt(heightPx);
        dest.writeInt(pixelFormat);
        dest.writeByteArray(payload);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MapFrame> CREATOR = new Creator<MapFrame>() {
        @Override
        public MapFrame createFromParcel(Parcel in) {
            return new MapFrame(in);
        }

        @Override
        public MapFrame[] newArray(int size) {
            return new MapFrame[size];
        }
    };
}
