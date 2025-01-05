package lk.example.asynctask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("AsyncTask Log", "Strat AsyncTask");

                AsyncTask asyncTask = new AsyncTask() {

                    @Override
                    protected void onPreExecute() {
                        Log.i("AsyncTask Log", "Strat onPreExecute");
                    }


                    @Override
                    protected Object doInBackground(Object[] objects) {

                        for (int i = 0; i <=10; i++) {
                            try {
                                publishProgress(i);
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        return null;
                    }

                    @Override
                    protected void onProgressUpdate(Object[] values) {
                        TextView textView = findViewById(R.id.textView);
                        textView.setText(String.valueOf((int) values[0]));
                    }


                    @Override
                    protected void onPostExecute(Object o) {
                        Log.i("AsyncTask Log", "Strat onPreExecute");
                    }
                };

                asyncTask.execute("");

            }
        });

    }
}