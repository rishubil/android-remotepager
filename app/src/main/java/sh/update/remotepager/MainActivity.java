package sh.update.remotepager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import static sh.update.remotepager.Utils.command;
import static sh.update.remotepager.Utils.sendKey;

public class MainActivity extends AppCompatActivity {
    private AppCompatTextView result;
    private AppCompatButton saveIp;
    private AppCompatButton pageUp;
    private AppCompatButton pageDown;
    private AppCompatButton startBService;
    private AppCompatButton stopBService;
    private AppCompatEditText ip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = (AppCompatTextView) findViewById(R.id.result);
        saveIp = (AppCompatButton) findViewById(R.id.save_ip);
        pageDown = (AppCompatButton) findViewById(R.id.page_down);
        pageUp = (AppCompatButton) findViewById(R.id.page_up);
        startBService = (AppCompatButton) findViewById(R.id.start_service);
        stopBService = (AppCompatButton) findViewById(R.id.stop_service);
        ip = (AppCompatEditText) findViewById(R.id.ip);

        ip.setText(Utils.getPrefString(getApplicationContext(), "ip"));

        saveIp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.setPrefString(getApplicationContext(), "ip", ip.getText().toString().trim());
            }
        });

        startBService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(new Intent("sh.update.remotepager.buttonservice"));
            }
        });

        stopBService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(new Intent("sh.update.remotepager.buttonservice"));
            }
        });

        pageDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(Utils.sendKey(getApplicationContext(), "KEYCODE_PAGE_DOWN"));
            }
        });

        pageUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(Utils.sendKey(getApplicationContext(), "KEYCODE_PAGE_UP"));
            }
        });
    }




}
