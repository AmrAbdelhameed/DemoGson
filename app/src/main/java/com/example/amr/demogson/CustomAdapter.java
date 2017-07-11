package com.example.amr.demogson;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends BaseAdapter {
    private List<Response.ResultsBean> mMovieitem;
    private Context mContext;
    private LayoutInflater inflater;

    public CustomAdapter(Context mContext, List<Response.ResultsBean> mMovieitem) {
        this.mContext = mContext;
        this.mMovieitem = mMovieitem;
    }

    @Override
    public int getCount() {
        return mMovieitem.size();
    }

    @Override
    public Object getItem(int position) {
        return mMovieitem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_view_layout, parent, false);
        Response.ResultsBean item = (Response.ResultsBean) getItem(position);
        TextView title = (TextView) rowView.findViewById(R.id.title);
        TextView rating = (TextView) rowView.findViewById(R.id.published);
        ImageView thumbnail = (ImageView) rowView.findViewById(R.id.imagevi);
        if (item.getMultimedia().size()>0)
        {
            String imageUrl = item.getMultimedia().get(item.getMultimedia().size()/2).getUrl();
            Picasso.with(mContext).load(imageUrl).into(thumbnail);
        }
        title.setText(item.getTitle());
        rating.setText(item.getPublished_date());
        return rowView;
    }
}
