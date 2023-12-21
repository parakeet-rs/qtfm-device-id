package moe.jixun.qtfm_device_id.utils;

import android.os.Build;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public class DeviceInfoHelper {
    public static List<DeviceInfoEntry> getDeviceInfo() {
        return Arrays.asList(new DeviceInfoEntry("PRODUCT", Build.PRODUCT), new DeviceInfoEntry("DEVICE", Build.DEVICE), new DeviceInfoEntry("MANUFACTURER", Build.MANUFACTURER), new DeviceInfoEntry("BRAND", Build.BRAND), new DeviceInfoEntry("BOARD", Build.BOARD), new DeviceInfoEntry("MODEL", Build.MODEL));
    }

    public static String getDeviceInfoText() {
        StringBuilder buffer = new StringBuilder();

        List<DeviceInfoEntry> device_info = getDeviceInfo();
        for (DeviceInfoEntry item : device_info) {
            buffer.append(String.format("%s: %s\n", item.name, item.value));
        }

        String device_secret = getDeviceSecretKey(device_info);
        buffer.append(String.format("%s: %s\n", "DEVICE_SECRET", device_secret));

        return buffer.toString().trim();
    }

    private static final byte[] g_salt = new byte[]{0x26, 0x2b, 0x2b, 0x12, 0x11, 0x12, 0x14, 0x0a, 0x08, 0x00, 0x08, 0x0a, 0x14, 0x12, 0x11, 0x12};

    public static String getDeviceSecretKey(List<DeviceInfoEntry> device_info) {
        int hashCode = device_info.stream().map(item -> item.value.hashCode()).reduce(0, Integer::sum);
        byte[] deviceHashCode = String.format("%x", hashCode).getBytes(StandardCharsets.UTF_8);
        byte[] device_key = new byte[16];
        System.arraycopy(deviceHashCode, 0, device_key, 0, Math.min(deviceHashCode.length, 16));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            sb.append(String.format("%02x", (device_key[i] + g_salt[i]) & 0xFF));
        }
        return sb.toString();
    }
}
