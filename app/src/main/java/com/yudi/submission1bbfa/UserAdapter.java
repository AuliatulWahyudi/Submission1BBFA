package com.yudi.submission1bbfa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ListViewHolder>
{

	private ArrayList<Users> listUser;
	private OnItemClickCallback onItemClickCallback;

	public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
		this.onItemClickCallback = onItemClickCallback;
	}

	public UserAdapter(ArrayList<Users> list) {
		this.listUser = list;
	}

	@NonNull
	@Override
	public UserAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
		return new ListViewHolder(view);
	}

	@Override
	public void onBindViewHolder(@NonNull UserAdapter.ListViewHolder holder, int position) {
		Users users = listUser.get(position);
		holder.imgPhoto.setImageResource(users.getPoster());
		holder.tvName.setText(users.getName());
		holder.tvLocation.setText(users.getLocation());
		holder.tvYears.setText(users.getYear());

		holder.itemView.setOnClickListener(v -> onItemClickCallback.onItemClicked(listUser.get(holder.getAdapterPosition()), position));
	}

	@Override
	public int getItemCount() {
		return listUser.size();
	}

	public class ListViewHolder extends RecyclerView.ViewHolder {

		ImageView imgPhoto;
		TextView tvName, tvLocation, tvYears;

		public ListViewHolder(@NonNull View itemView) {
			super(itemView);
			imgPhoto = itemView.findViewById(R.id.img_poster);
			tvName = itemView.findViewById(R.id.tv_item_name);
			tvLocation = itemView.findViewById(R.id.tv_item_location);
			tvYears = itemView.findViewById(R.id.tv_item_year);
		}
	}

	public interface OnItemClickCallback {
		void onItemClicked(Users data, int position);
	}
}
