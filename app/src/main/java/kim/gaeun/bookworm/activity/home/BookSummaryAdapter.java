package kim.gaeun.bookworm.activity.home;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

import kim.gaeun.bookworm.R;
import kim.gaeun.bookworm.model.BookSummary;

public class BookSummaryAdapter extends RecyclerView.Adapter<BookSummaryAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTitle;
        TextView mAuthor;
        RatingBar mRatingBar;

        public ViewHolder(View view) {
            super(view);
            mTitle = (TextView) view.findViewById(R.id.bookSummaryTitle);
            mAuthor = (TextView) view.findViewById(R.id.bookSummaryAuthor);
            mRatingBar = (RatingBar) view.findViewById(R.id.bookSummaryRatingBar);
        }
    }

    List<BookSummary> mBookSummaries;

    private View.OnClickListener mOnClickListener;

    public BookSummaryAdapter(List<BookSummary> summaries, View.OnClickListener listener) {
        mBookSummaries = summaries;
        mOnClickListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.book_summary, parent, false);
        itemView.setOnClickListener(mOnClickListener);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        BookSummary summary = mBookSummaries.get(position);
        holder.mTitle.setText(summary.getTitle());
        holder.mAuthor.setText(summary.getAuthor());
        holder.mRatingBar.setRating(summary.getRating());
    }

    @Override
    public int getItemCount() {
        return mBookSummaries.size();
    }

}
