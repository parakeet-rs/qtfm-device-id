package moe.jixun.qtfm_device_id;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import moe.jixun.qtfm_device_id.utils.DeviceInfoHelper;

public class MainActivity extends Activity {
    public void setClipboardText(String text ) {
        ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        clipboardManager.setPrimaryClip(ClipData.newPlainText("text", text));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText deviceInfoEdit = findViewById(R.id.deviceInfoEdit);
        deviceInfoEdit.setText(DeviceInfoHelper.getDeviceInfoText());

        Button btnCopy = findViewById(R.id.btnCopy);
        btnCopy.setOnClickListener(v -> {
            setClipboardText(DeviceInfoHelper.getDeviceInfoText());
            Toast.makeText(this, getString(R.string.hint_copied_device_info), Toast.LENGTH_SHORT).show();
        });
    }

}