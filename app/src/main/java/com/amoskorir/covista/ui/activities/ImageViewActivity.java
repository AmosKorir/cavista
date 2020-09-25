package com.amoskorir.covista.ui.activities;

import android.os.Build;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.amoskorir.covista.R;
import com.amoskorir.covista.ui.adapters.CommentRecyclerAdapter;
import com.amoskorir.domain.CovistaConstants;
import com.amoskorir.domain.models.Comment;
import com.amoskorir.domain.models.Image;
import com.amoskorir.viewmodels.SearchViewModel;
import com.bumptech.glide.Glide;

import java.util.List;
import java.util.Objects;

import static org.koin.java.KoinJavaComponent.get;

public class ImageViewActivity extends AppCompatActivity {
    private Image image = null;
    private SearchViewModel searchViewModel = get(SearchViewModel.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        image = (Image) Objects.requireNonNull(getIntent().getExtras()).getSerializable(CovistaConstants.IMAGE);
        initVIew();
    }

    private void initVIew() {
        if (image != null) {
            Toolbar toolbar = findViewById(R.id.toolbar);
                toolbar.setTitle(image.getTitle());
            ImageView imageView = findViewById(R.id.app_bar_image);
            Glide.with(this)
                    .load(image.getLink())
                    .placeholder(R.drawable.placeholder)
                    .into(imageView);
            searchViewModel.getCommentLiveData().observe(this, this::showComments);
            searchViewModel.getComments(image.getId());

        }
        ImageButton sendMessage = findViewById(R.id.sendMessageBtn);
        sendMessage.setOnClickListener(v -> {
            sendComment();
        });
    }

    private void showComments(List<Comment> comments) {
        RecyclerView commentRecyclerView = findViewById(R.id.commentRecyclerView);
        commentRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        commentRecyclerView.setAdapter(new CommentRecyclerAdapter(this, comments));
    }

    private void sendComment() {
        EditText commentEditText = findViewById(R.id.commentEd);
        String comment = commentEditText.getText().toString();
        if (!comment.isEmpty()) {
            searchViewModel.comment(image.getId(), comment);
            commentEditText.setText(CovistaConstants.EMPTY_STRING);
        }
    }

}