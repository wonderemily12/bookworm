package kim.gaeun.bookworm.activity.home;

import java.util.*;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import kim.gaeun.bookworm.R;
import kim.gaeun.bookworm.ReadActivity;
import kim.gaeun.bookworm.model.BookSummary;

class HomeActivity extends AppCompatActivity {
    private List<BookSummary> mBookSummaries = new ArrayList<>();
    private RecyclerView recyclerView;
    private BookSummaryAdapter mAdapter;

    public void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        prepareBookSummaries();

        recyclerView = (RecyclerView) findViewById(R.id.dashBoard);
        mAdapter = new BookSummaryAdapter(mBookSummaries, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int itemPosition = recyclerView.getChildLayoutPosition(view);
                BookSummary summary = mBookSummaries.get(itemPosition);
                Log.i("BookSummaryAdapter", summary.getTitle());
                //Toast.makeText(HomeActivity.this, summary.getTitle(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HomeActivity.this, ReadActivity.class);
                intent.putExtra("title", summary.getTitle());
                intent.putExtra("author", summary.getAuthor());
                intent.putExtra("rating", summary.getRating());
                startActivity(intent);
            }
        });
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

    }

    private void prepareBookSummaries() {
        addBookSummary("Hello World", "Jongbin Park", 4.5f);
        addBookSummary("CodeWings", "Foo Bar", 3.0f);
    }

    private void addBookSummary(String title, String author, float rating) {
        BookSummary bs = new BookSummary();
        bs.setTitle(title);
        bs.setAuthor(author);
        bs.setRating(rating);
        mBookSummaries.add(bs);
    }
}