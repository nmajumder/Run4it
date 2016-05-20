package hu.ait.android.run4it;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.backendless.Backendless;

import hu.ait.android.run4it.adapter.ProfPagerAdapter;
import hu.ait.android.run4it.network.FitbitAPI;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static String KEY_PROF_INTENT = "profIntentKey";
    public static int INTENT_PROF_MAIN_INFO = 0;
    public static int INTENT_PROF_STATS = 1;
    public static int INTENT_PROF_GOALS = 2;

    protected DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        Backendless.initApp(this,
                "A94E262B-238C-C591-FFC2-7311BC2CEC00",
                "5A91BE01-A040-9159-FFB7-FF93974F9000",
                "v1");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Retrofit retrofit = new Retrofit.Builder().
                baseUrl("https://www.fitbit.com/").
                addConverterFactory(GsonConverterFactory.create()).
                build();
        final FitbitAPI fitbitAPI = retrofit.create(FitbitAPI.class);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Intent nextPageIntent;
        switch(id) {
            case R.id.nav_profInfo:
                nextPageIntent = new Intent(BaseActivity.this, ProfileActivity.class);
                nextPageIntent.putExtra(KEY_PROF_INTENT, INTENT_PROF_MAIN_INFO);
                startActivity(nextPageIntent);
                break;
            case R.id.nav_stats:
                nextPageIntent = new Intent(BaseActivity.this, ProfileActivity.class);
                nextPageIntent.putExtra(KEY_PROF_INTENT, INTENT_PROF_STATS);
                startActivity(nextPageIntent);
                break;
            case R.id.nav_goals:
                nextPageIntent = new Intent(BaseActivity.this, ProfileActivity.class);
                nextPageIntent.putExtra(KEY_PROF_INTENT,INTENT_PROF_GOALS);
                startActivity(nextPageIntent);
                break;
            case R.id.nav_competitions:
                nextPageIntent = new Intent(BaseActivity.this, CompetitionsActivity.class);
                startActivity(nextPageIntent);
                break;
            case R.id.nav_objectives:
                nextPageIntent = new Intent(BaseActivity.this, ObjectivesActivity.class);
                startActivity(nextPageIntent);
                break;
            case R.id.nav_settings:
                // do something with settings
                break;
            default:
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
