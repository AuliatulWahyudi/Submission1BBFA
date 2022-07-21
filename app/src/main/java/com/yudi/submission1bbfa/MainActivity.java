package com.yudi.submission1bbfa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

	private String[] dataName, dataLocation, dataRepo, dataFollowing, dataFollowers,
			dataUsername, dataUserCompany, dataYear;
	private TypedArray dataPoster;
	private UserAdapter adapter;

	private RecyclerView rvUsers;
	private ArrayList<Users> list = new ArrayList<>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		rvUsers = findViewById(R.id.recycle);
		rvUsers.setHasFixedSize(true);

		list.addAll(getListHeroes());
		showRecyclerList();
	}

	public ArrayList<Users> getListHeroes() {
		dataName = getResources().getStringArray(R.array.name);
		dataLocation = getResources().getStringArray(R.array.location);
		dataYear = getResources().getStringArray(R.array.year);
		dataRepo = getResources().getStringArray(R.array.repository);
		dataUsername = getResources().getStringArray(R.array.username);
		dataUserCompany = getResources().getStringArray(R.array.company);
		dataFollowers = getResources().getStringArray(R.array.followers);
		dataFollowing = getResources().getStringArray(R.array.following);
		dataPoster = getResources().obtainTypedArray(R.array.picture);

		ArrayList<Users> listUser = new ArrayList<>();
		for (int i = 0; i < dataName.length; i++) {
			Users user = new Users();
			user.setName(dataName[i]);
			user.setLocation(dataLocation[i]);
			user.setYear(dataYear[i]);
			user.setRepo(dataRepo[i]);
			user.setUsername(dataUsername[i]);
			user.setFollowing(dataFollowing[i]);
			user.setUser_company(dataUserCompany[i]);
			user.setFollowers(dataFollowers[i]);
			user.setPoster(dataPoster.getResourceId(i, -1));

			listUser.add(user);
		}
		return listUser;
	}

	private void showRecyclerList(){
		if(getApplicationContext().getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
			rvUsers.setLayoutManager(new GridLayoutManager(this, 2));
		} else {
			rvUsers.setLayoutManager(new LinearLayoutManager(this));
		}

		adapter = new UserAdapter(list);
		rvUsers.setAdapter(adapter);
		adapter.setOnItemClickCallback(this::showSelectedHero);

	}

	private void showSelectedHero(Users hero, int position) {
		Intent moveWithObject = new Intent(MainActivity.this, DetailListActivity.class);

		ArrayList<Users> listUser = new ArrayList<>();

		Users user = new Users();
		user.setName(dataName[position]);
		user.setLocation(dataLocation[position]);
		user.setYear(dataYear[position]);
		user.setRepo(dataRepo[position]);
		user.setUsername(dataUsername[position]);
		user.setFollowing(dataFollowing[position]);
		user.setUser_company(dataUserCompany[position]);
		user.setFollowers(dataFollowers[position]);
		user.setPoster(dataPoster.getResourceId(position, -1));

		listUser.add(user);

		moveWithObject.putParcelableArrayListExtra(DetailListActivity.EXTRA_USER, list);
		moveWithObject.putExtra(DetailListActivity.EXTRA_USER, user);
		startActivity(moveWithObject);
		Toast.makeText(this, "Kamu memilih " + hero.getName(), Toast.LENGTH_SHORT).show();
	}

}