package com.praxis.movieviewer.seatselector;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.praxis.movieviewer.R;
import com.praxis.movieviewer.seatselector.models.Time;

import java.util.List;

public class TimesAdapter extends ArrayAdapter<Time> {

//  static class ViewHolder {
//    @BindView(android.R.id.text1)
//    TextView tvName;
//
//    public ViewHolder(View view) {
////      ButterKnife.bind(this, view);
//      tvName = view.findViewById(android.R.id.text1);
//    }
//  }

  private int mResource;
  private int mDropdownResource;

  public TimesAdapter(@NonNull Context context, int resource, @NonNull List<Time> objects) {
    super(context, resource, objects);

    mResource = resource;
  }

  @NonNull
  @Override
  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    Time time = getItem(position);

    View view = LayoutInflater.from(getContext()).inflate(mResource, parent, false);

    TextView tvName = view.findViewById(R.id.text1);
    tvName.setText(time.getLabel());

    return view;
  }

  @Override
  public void setDropDownViewResource(int resource) {
    super.setDropDownViewResource(resource);

    mDropdownResource = resource;
  }

  @Override
  public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    Time time = getItem(position);

    View view = LayoutInflater.from(getContext()).inflate(mDropdownResource, parent, false);

    TextView tvName = view.findViewById(R.id.text1);
    tvName.setText(time.getLabel());

    return view;
  }
}
