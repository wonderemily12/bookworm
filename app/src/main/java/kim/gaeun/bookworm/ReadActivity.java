package kim.gaeun.bookworm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import kim.gaeun.bookworm.view.ProgressRing;

public class ReadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String author = intent.getStringExtra("author");
        TextView tvAuthor = (TextView) findViewById(R.id.author);
        tvAuthor.setText(author);
        TextView tvTitle = (TextView) findViewById(R.id.title);
        tvAuthor.setText(title);
        ProgressRing progressRing = (ProgressRing) findViewById(R.id.progressRing);
        progressRing.setProgress(0.3f);
    }
}
