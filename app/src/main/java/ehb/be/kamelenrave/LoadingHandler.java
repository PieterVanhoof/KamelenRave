package ehb.be.kamelenrave;

import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Locale;

public class LoadingHandler extends Handler {
    private ProgressBar pb3;
    private TextView tvProgress;

    public LoadingHandler(ProgressBar pb3, TextView tvProgress) {
        this.pb3 = pb3;
        this.tvProgress = tvProgress;
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);

        pb3.setProgress(msg.arg1);

        int maxProgress = pb3.getMax();
        String display = String.format(Locale.getDefault(), "%d/%d %%", msg.arg1, maxProgress);
        tvProgress.setText(display);

        if (msg.arg1 == maxProgress) {
            tvProgress.setText("Done");
        }

    }
}
