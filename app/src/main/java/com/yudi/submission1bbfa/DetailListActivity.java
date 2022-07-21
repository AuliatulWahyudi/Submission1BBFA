package com.yudi.submission1bbfa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailListActivity extends AppCompatActivity {

	String name, username, user_company, repo, following, followers, location;
	int path;

	public static final String EXTRA_USER = "test_extra_user";

	TextView tViewName, tViewUserName, tViewUserCompany, tViewRepo,
			textViewFollowing, tViewFollowers, tViewLocation;

	ImageView imagePoster;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail_list);

		tViewName = findViewById(R.id.detail_name);
		tViewUserName = findViewById(R.id.detail_username);
		tViewUserCompany = findViewById(R.id.detail_company);
		tViewRepo = findViewById(R.id.detail_repository);
		textViewFollowing = findViewById(R.id.detail_following);
		tViewFollowers = findViewById(R.id.detail_followers);
		tViewLocation = findViewById(R.id.detail_location);
		imagePoster = findViewById(R.id.detail_avatar);

		Users user = getIntent().getParcelableExtra(EXTRA_USER);

		if (user != null) {
			name = user.getName();
			tViewName.setText(name);

		}

		if (user != null) {
			username = user.getUsername();
			tViewUserName.setText(getString(R.string.username, username));

		}

		if (user != null) {
			user_company = user.getUser_company();
			tViewUserCompany.setText(getString(R.string.companyname, user_company));

		}

		if (user != null) {
			repo = user.getRepo();
			tViewRepo.setText(getString(R.string.repository, repo));

		}

		if (user != null) {
			following = user.getFollowing();
			textViewFollowing.setText(getString(R.string.following, following));
		}

		if (user != null) {
			followers = user.getFollowers();
			tViewFollowers.setText(getString(R.string.followers, followers));

		}

		if (user != null) {
			location = user.getLocation();
			tViewLocation.setText(getString(R.string.location, location));

		}

		if (user != null) {
			path = user.getPoster();
			imagePoster.setImageResource(path);

		}
	}
}