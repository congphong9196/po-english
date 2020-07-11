package com.example.recyclerview.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.recyclerview.fragment.LearningAndTrainingFragment;
import com.example.recyclerview.fragment.LearningFragment;
import com.example.recyclerview.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class LearningAndPracticeActivity
        extends AppCompatActivity
        implements
            LearningFragment.OnLearningFragmentNextListener,
            LearningAndTrainingFragment.OnLearningAndTrainingFragmentNextListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);

        nextFragment(new LearningFragment(this), R.id.learningFragmentLayout);

        getSupportActionBar().setTitle(null);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close_black);
    }

    public void nextFragment(androidx.fragment.app.Fragment fragment, int id) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(id, fragment);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.learning, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Toast.makeText(
                    getApplicationContext(), "Clicked on ActionBar",
                    Toast.LENGTH_SHORT).show();
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void OnLearningFragmentNext() {
        nextFragment(new LearningAndTrainingFragment(this), R.id.learningFragmentLayout);
    }

    @Override
    public void OnLearningAndTrainingFragmentNext() {
        nextFragment(new LearningFragment(this), R.id.learningFragmentLayout);
    }

    public interface OnClickItemHomeListener {
        void onClickItemHome();
    }
}
