package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuAdapter;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import de.hdodenhof.circleimageview.CircleImageView;
import nl.psdcompany.duonavigationdrawer.views.DuoDrawerLayout;
import nl.psdcompany.duonavigationdrawer.views.DuoMenuView;
import nl.psdcompany.duonavigationdrawer.widgets.DuoDrawerToggle;

/*public class recruitermain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recruitermain);
    }
}*/
public class recruitermain extends AppCompatActivity implements DuoMenuView.OnMenuClickListener
{
    private com.example.myapplication.MenuAdapter mMenuAdapter;
    private ViewHolder mViewHolder;
    CircleImageView header;
    ProgressDialog pd;
    TextView name , mail;

    private ArrayList<String> mTitles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recruitermain);

        /*new checkInternetConnection(this).checkConnection();*/
        name = findViewById(R.id.header_name);
        mail = findViewById(R.id.header_mail);

        pd = new ProgressDialog(this);
        mTitles = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.menuOptions)));
        header = findViewById(R.id.image_header);

        // Initialize the views
        mViewHolder = new ViewHolder();

        // Handle toolbar actions
        handleToolbar();

        // Handle menu actions
        handleMenu();

        // Handle drawer actions
        handleDrawer();

        mMenuAdapter.setViewSelected(0 , true);
        setTitle(mTitles.get(0));


    }

    private void handleToolbar()
    {
        setSupportActionBar(mViewHolder.mToolbar);
    }

    private void handleDrawer()
    {
        DuoDrawerToggle duoDrawerToggle = new DuoDrawerToggle(this , mViewHolder.mDuoDrawerLayout , mViewHolder.mToolbar , R.string.navigation_drawer_open , R.string.navigation_drawer_close);

        mViewHolder.mDuoDrawerLayout.setDrawerListener(duoDrawerToggle);
        duoDrawerToggle.syncState();

    }

    private void handleMenu()
    {
        mMenuAdapter = new com.example.myapplication.MenuAdapter(mTitles);

        mViewHolder.mDuoMenuView.setOnMenuClickListener(this);
        mViewHolder.mDuoMenuView.setAdapter(mMenuAdapter);
    }

    @Override
    public void onFooterClicked()
    {
        pd.setTitle("Logging out");
        pd.show();
        startActivity(new Intent(recruitermain.this , MainActivity.class));
        finish();
    }

    @Override
    public void onHeaderClicked()
    {
        Intent i = new Intent(recruitermain.this , edit_seeker.class);
        ActivityOptionsCompat actop = ActivityOptionsCompat.makeSceneTransitionAnimation(this , header , ViewCompat.getTransitionName(header));
        startActivity(i , actop.toBundle());
    }

    @Override
    public void onOptionClicked(int position , Object objectClicked)
    {
        switch(position)
        {
            case 2:
                startActivity(new Intent(recruitermain.this , seekermain.class));
                break;
            case 1:
                Intent i = new Intent(recruitermain.this , seekermain.class);
                ActivityOptionsCompat actop = ActivityOptionsCompat.makeSceneTransitionAnimation(this , header , ViewCompat.getTransitionName(header));
                startActivity(i , actop.toBundle());
                break;
            default:
                break;
        }

        // Close the drawer
        mViewHolder.mDuoDrawerLayout.closeDrawer();
    }

    private class ViewHolder
    {
        private DuoDrawerLayout mDuoDrawerLayout;
        private DuoMenuView mDuoMenuView;
        private Toolbar mToolbar;

        ViewHolder()
        {
            mDuoDrawerLayout = findViewById(R.id.drawer);
            mDuoMenuView = (DuoMenuView)mDuoDrawerLayout.getMenuView();
            mToolbar = findViewById(R.id.toolbar);
        }
    }
}
