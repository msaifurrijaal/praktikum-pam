package com.example.praktikummodul7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    private ImageView[] imgSlot = new ImageView[3];
    private Button btnGet;
    private ArrayList<String> arrayUrl = new ArrayList<>();
    private slotActivity[] slot = new slotActivity[3];
    private boolean play = false;
    private ExecutorService executorService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGet = findViewById(R.id.btn_get);
        imgSlot[0] = findViewById(R.id.img_slot1);
        imgSlot[1] = findViewById(R.id.img_slot2);
        imgSlot[2] = findViewById(R.id.img_slot3);

        executorService = Executors.newFixedThreadPool(3);

        getImage();

        btnGet.setOnClickListener(view -> play());
    }

    private void play() {
        if (play == false) {
            for (int i = 0; i < 3; i++) {
                slot[i].play = true;
            }
            for (int j = 0; j < 3; j++) {
                executorService.execute(slot[j]);
            }

            btnGet.setText("Stop");
            play = !play;
            return;
        } else
            for (int i = 0; i < 3; i++) {
                slot[i].play = false;
                btnGet.setText("Play");
                play = !play;
            }
    }

    private void getImage() {
        Handler handler = new Handler(Looper.getMainLooper());
        executorService.execute(() -> {
            try {
                final String text = loadStringFromNetwork();
                try {
                    JSONArray jsonArray = new JSONArray(text);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        arrayUrl.add(jsonObject.getString("url"));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (int j = 0; j < 3; j++) {
                slot[j] = new slotActivity(imgSlot[j], handler);
            }
        });
    }

    private String loadStringFromNetwork() throws IOException {
        final URL myUrl = new URL("https://mocki.io/v1/821f1b13-fa9a-43aa-ba9a-9e328df8270e");
        final InputStream in = myUrl.openStream();
        final StringBuilder out = new StringBuilder();
        final byte[] buffer = new byte[1024];
        try {
            for (int ctr; (ctr = in.read(buffer)) != -1; ) {
                out.append(new String(buffer, 0, ctr));
            }
        } catch (IOException e) {
            throw new RuntimeException("Gagal mendapatkan text", e);
        }
        return out.toString();
    }

    class slotActivity implements Runnable {
        ImageView imageView;
        Random random = new Random();
        boolean play = true;
        int imgIndex = 0;
        Handler handler;
        String url = "";

        public slotActivity(ImageView imageView, Handler handler) {
            this.imageView = imageView;
            this.handler = handler;
        }

        public void run() {
            while (play) {
                imgIndex = random.nextInt(3);
                runOnUiThread(() -> handler.post(() -> {
                    url = arrayUrl.get(imgIndex);
                    Glide.with(MainActivity.this).load(url).into(imageView);
                }));

                try {
                    Thread.sleep(random.nextInt(500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
    }
}

