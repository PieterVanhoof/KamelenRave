package ehb.be.kamelenrave;

import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;

import java.util.Locale;

public class LoadingHandler extends Handler {
    private ProgressBar pb3;

    public LoadingHandler(ProgressBar pb) {
        this.pb3 = pb;
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);

        pb3.setProgress(msg.arg1);



    }
}
