package moe.jixun.qtfm_device_id;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import moe.jixun.qtfm_device_id.utils.DeviceInfoHelper;
import moe.jixun.qtfm_device_id.utils.DeviceInfoEntry;

import static org.junit.Assert.*;

public class DeviceHashTest {
    @Test
    public void TestSecretKeyDerivation() {
        List<DeviceInfoEntry> device_info = Arrays.asList(
            new DeviceInfoEntry("PRODUCT", "product"),
            new DeviceInfoEntry("DEVICE", "device"),
            new DeviceInfoEntry("MANUFACTURER", "manufacturer"),
            new DeviceInfoEntry("BRAND", "brand"),
            new DeviceInfoEntry("BOARD", "board"),
            new DeviceInfoEntry("MODEL", "model")
        );

        String device_key = DeviceInfoHelper.generateUniqueDeviceId(device_info);
        assertEquals(device_key, "596491774546756d0800080a14121112");
    }
}
