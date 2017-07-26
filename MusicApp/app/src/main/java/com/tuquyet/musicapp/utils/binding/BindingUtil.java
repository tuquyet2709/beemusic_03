package com.tuquyet.musicapp.utils.binding;

import android.databinding.BindingAdapter;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.tuquyet.musicapp.R;
import com.tuquyet.musicapp.screen.main.MainActivity;
import com.tuquyet.musicapp.screen.main.MainViewModel;

/**
 * Created by tuquyet on 26/07/2017.
 */
public class BindingUtil {

    @BindingAdapter({"toolbar", "viewModel", "activity"})
    public static void setToolBar(DrawerLayout drawerLayout, Toolbar toolbar,
                                  MainViewModel viewModel, AppCompatActivity activity) {
        activity.setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            viewModel.getActivity(), drawerLayout, toolbar, R.string.navigation_drawer_open,
            R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
    }

    @BindingAdapter({"drawerLayout", "viewModel"})
    public static void setNavigationItemSelected(NavigationView navigationView, final
    DrawerLayout drawer, final MainViewModel viewModel) {
        navigationView.setNavigationItemSelectedListener(
            new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    viewModel.onNavigationItemSelected(item);
                    drawer.closeDrawer(GravityCompat.START);
                    return true;
                }
            });
    }
}
