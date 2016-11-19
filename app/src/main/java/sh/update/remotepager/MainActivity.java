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
    private AppCompatEditText ip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startService(new Intent("sh.update.remotepager.buttonservice"));
        result = (AppCompatTextView) findViewById(R.id.result);
        saveIp = (AppCompatButton) findViewById(R.id.save_ip);
        pageDown = (AppCompatButton) findViewById(R.id.page_down);
        pageUp = (AppCompatButton) findViewById(R.id.page_up);
        ip = (AppCompatEditText) findViewById(R.id.ip);

        ip.setText(Utils.getPrefString(getApplicationContext(), "ip"));

        saveIp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.setPrefString(getApplicationContext(), "ip", ip.getText().toString().trim());
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
