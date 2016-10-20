package burgerbanjirdev.nosave;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txt_phoneNo;
    Button btn_submit ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);

        txt_phoneNo = (EditText) findViewById(R.id.editText);
        btn_submit = (Button) findViewById(R.id.button);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = txt_phoneNo.getText().toString().trim();
                if(text.matches("") || text.equals("+6")){
                    Toast.makeText(MainActivity.this, "Insert Phone Number", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent i;
                    i = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + text));
                    i.setPackage("com.whatsapp");
                    startActivity(i);
                }
            }
        });



    }
}
