package com.caloriecounter.nicoleazachee.caloriecounter;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by c_naazachee on 8/24/2017.
 */
public class SearchResultsListAdapter extends BaseAdapter {
    public static final String TAG = SearchResultsListAdapter.class.getSimpleName();
    private Context context;
    private LayoutInflater inflater;
    private ArrayList<DataModel> dataSource;

    public SearchResultsListAdapter(Context _context, ArrayList<DataModel> _dataList){
        context = _context;
        dataSource = _dataList;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return dataSource.size();
    }

    @Override
    public Object getItem(int position) {
        return dataSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parentView) {
        ViewHolder viewHolder;

        if(convertView == null){
            convertView = inflater.inflate(R.layout.list_search_result_item, parentView, false);
            viewHolder = new ViewHolder();

            viewHolder.thumbnailImageView = (ImageView)convertView.findViewById(R.id.recipe_list_thumbnail);
            viewHolder.titleTextView = (TextView)convertView.findViewById(R.id.recipe_list_title);
            viewHolder.subtitleTextView = (TextView) convertView.findViewById(R.id.recipe_list_subtitle);
            viewHolder.detailTextView = (TextView) convertView.findViewById(R.id.recipe_list_detail);

            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder)convertView.getTag();
        }

        TextView titleTextView = viewHolder.titleTextView;
        TextView subtitleTextView = viewHolder.subtitleTextView;
        TextView detailTextView = viewHolder.detailTextView;
        ImageView thumbnailImageView = viewHolder.thumbnailImageView;
        DataModel data = (DataModel)getItem(position);

        titleTextView.setText(data.title);
        subtitleTextView.setText(data.description);
        detailTextView.setText(data.label);

        Picasso.with(context).load(data.imageUrl).placeholder(R.mipmap.ic_launcher).into(thumbnailImageView);
        return convertView;
    }

    private static class ViewHolder{
        public TextView titleTextView;
        public TextView subtitleTextView;
        public TextView detailTextView;
        public ImageView thumbnailImageView;
    }
}
