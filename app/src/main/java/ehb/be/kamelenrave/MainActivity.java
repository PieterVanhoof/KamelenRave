package ehb.be.kamelenrave;

import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ProgressBar pb1,pb2,pb3;
    private LoadingHandler lh1, lh2, lh3;
    private TextView tvProgress;
    private Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart = findViewById(R.id.btn_start);
        tvProgress = findViewById(R.id.tv_progress);

        pb1 = findViewById(R.id.pb_1);
        pb2 = findViewById(R.id.pb_2);
        pb3 = findViewById(R.id.pb_3);

        lh1 = new LoadingHandler(pb1, tvProgress);
        lh2 = new LoadingHandler(pb2, tvProgress);
        lh3 = new LoadingHandler(pb3, tvProgress);
    }
    public void onStartClick(View v) {
        //Kameel 1
        Thread pb1Thread = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i <= 100; i++)  {
                    try {
                        Thread.sleep(new Random().nextInt(100));
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    Message message = new Message();
                    message.arg1 = i;
                    lh1.sendMessage(message);
                }

            }
        });
        //kameel 2
        Thread pb2Thread = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i <= 100; i++)  {
                    try {
                        Thread.sleep(new Random().nextInt(100));
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    Message message = new Message();
                    message.arg1 = i;
                    lh2.sendMessage(message);
                }

            }
        });
        //Kameel 3
        Thread pb3Thread = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i <= 100; i++)  {
                    try {
                        Thread.sleep(new Random().nextInt(100));
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    Message message = new Message();
                    message.arg1 = i;
                    lh3.sendMessage(message);
                }

            }
        });
        pb1Thread.start();
        pb2Thread.start();
        pb3Thread.start();

    }

}
