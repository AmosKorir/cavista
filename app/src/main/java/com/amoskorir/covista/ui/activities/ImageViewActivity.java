package com.amoskorir.covista.ui.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.amoskorir.covista.R;
import com.amoskorir.domain.CovistaConstants;
import com.amoskorir.domain.models.Image;

import java.util.Objects;

public class ImageViewActivity extends AppCompatActivity {
    private Image image = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        image = (Image) Objects.requireNonNull(getIntent().getExtras()).getSerializable(CovistaConstants.IMAGE);
        initVIew();
    }

    private void initVIew() {

    }
}