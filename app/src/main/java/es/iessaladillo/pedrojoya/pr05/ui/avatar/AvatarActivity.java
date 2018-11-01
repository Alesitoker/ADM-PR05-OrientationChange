package es.iessaladillo.pedrojoya.pr05.ui.avatar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.ViewModelProviders;
import es.iessaladillo.pedrojoya.pr05.R;
import es.iessaladillo.pedrojoya.pr05.data.local.Database;
import es.iessaladillo.pedrojoya.pr05.data.local.model.Avatar;
import es.iessaladillo.pedrojoya.pr05.utils.ResourcesUtils;

public class AvatarActivity extends AppCompatActivity {

    @VisibleForTesting
    public static final String EXTRA_AVATAR = "EXTRA_AVATAR";
    private ImageView imgAvatar1;
    private ImageView imgAvatar2;
    private ImageView imgAvatar3;
    private ImageView imgAvatar4;
    private ImageView imgAvatar5;
    private ImageView imgAvatar6;
    private TextView lblAvatar1;
    private TextView lblAvatar2;
    private TextView lblAvatar3;
    private TextView lblAvatar4;
    private TextView lblAvatar5;
    private TextView lblAvatar6;
    private final byte positionAvatar1 = 0;
    private final byte positionAvatar2 = 1;
    private final byte positionAvatar3 = 2;
    private final byte positionAvatar4 = 3;
    private final byte positionAvatar5 = 4;
    private final byte positionAvatar6 = 5;
    private AvatarActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avatar);
        viewModel = ViewModelProviders.of(this).get(AvatarActivityViewModel.class);
        getIntentData();
        initViews();
    }

    private void getIntentData() {
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(EXTRA_AVATAR) && viewModel.getAvatar() == null) {
                viewModel.setAvatar(intent.getParcelableExtra(EXTRA_AVATAR));
            }
        }
    }

    private void initViews() {
        imgAvatar1 = ActivityCompat.requireViewById(this, R.id.imgAvatar1);
        imgAvatar2 = ActivityCompat.requireViewById(this, R.id.imgAvatar2);
        imgAvatar3 = ActivityCompat.requireViewById(this, R.id.imgAvatar3);
        imgAvatar4 = ActivityCompat.requireViewById(this, R.id.imgAvatar4);
        imgAvatar5 = ActivityCompat.requireViewById(this, R.id.imgAvatar5);
        imgAvatar6 = ActivityCompat.requireViewById(this, R.id.imgAvatar6);
        lblAvatar1 = ActivityCompat.requireViewById(this, R.id.lblAvatar1);
        lblAvatar2 = ActivityCompat.requireViewById(this, R.id.lblAvatar2);
        lblAvatar3 = ActivityCompat.requireViewById(this, R.id.lblAvatar3);
        lblAvatar4 = ActivityCompat.requireViewById(this, R.id.lblAvatar4);
        lblAvatar5 = ActivityCompat.requireViewById(this, R.id.lblAvatar5);
        lblAvatar6 = ActivityCompat.requireViewById(this, R.id.lblAvatar6);

        startAvatar();
        selectedImage();
        imgAvatar1.setOnClickListener(v -> changeSelectedAvatar(positionAvatar1));
        imgAvatar2.setOnClickListener(v -> changeSelectedAvatar(positionAvatar2));
        imgAvatar3.setOnClickListener(v -> changeSelectedAvatar(positionAvatar3));
        imgAvatar4.setOnClickListener(v -> changeSelectedAvatar(positionAvatar4));
        imgAvatar5.setOnClickListener(v -> changeSelectedAvatar(positionAvatar5));
        imgAvatar6.setOnClickListener(v -> changeSelectedAvatar(positionAvatar6));
        lblAvatar1.setOnClickListener(v -> changeSelectedAvatar(positionAvatar1));
        lblAvatar2.setOnClickListener(v -> changeSelectedAvatar(positionAvatar2));
        lblAvatar3.setOnClickListener(v -> changeSelectedAvatar(positionAvatar3));
        lblAvatar4.setOnClickListener(v -> changeSelectedAvatar(positionAvatar4));
        lblAvatar5.setOnClickListener(v -> changeSelectedAvatar(positionAvatar5));
        lblAvatar6.setOnClickListener(v -> changeSelectedAvatar(positionAvatar6));
    }


    private void startAvatar() {
        List<Avatar> avatars = viewModel.queryAvatars();

        imgAvatar1.setImageResource(avatars.get(positionAvatar1).getImageResId());
        imgAvatar1.setTag(avatars.get(positionAvatar1).getImageResId());
        lblAvatar1.setText(avatars.get(positionAvatar1).getName());

        imgAvatar2.setImageResource(avatars.get(positionAvatar2).getImageResId());
        imgAvatar2.setTag(avatars.get(positionAvatar2).getImageResId());
        lblAvatar2.setText(avatars.get(positionAvatar2).getName());

        imgAvatar3.setImageResource(avatars.get(positionAvatar3).getImageResId());
        imgAvatar3.setTag(avatars.get(positionAvatar3).getImageResId());
        lblAvatar3.setText(avatars.get(positionAvatar3).getName());

        imgAvatar4.setImageResource(avatars.get(positionAvatar4).getImageResId());
        imgAvatar4.setTag(avatars.get(positionAvatar4).getImageResId());
        lblAvatar4.setText(avatars.get(positionAvatar4).getName());

        imgAvatar5.setImageResource(avatars.get(positionAvatar5).getImageResId());
        imgAvatar5.setTag(avatars.get(positionAvatar5).getImageResId());
        lblAvatar5.setText(avatars.get(positionAvatar5).getName());

        imgAvatar6.setImageResource(avatars.get(positionAvatar6).getImageResId());
        imgAvatar6.setTag(avatars.get(positionAvatar6).getImageResId());
        lblAvatar6.setText(avatars.get(positionAvatar6).getName());

    }

    private void selectedImage() {
        List<Avatar> avatarToSelect = viewModel.queryAvatars();
        Long avatarId = viewModel.getAvatar().getId();

        if (avatarId == avatarToSelect.get(positionAvatar1).getId()) {
            selectAvatar(imgAvatar1, lblAvatar1);
        } else if (avatarId == avatarToSelect.get(positionAvatar2).getId()) {
            selectAvatar(imgAvatar2, lblAvatar2);
        } else if (avatarId == avatarToSelect.get(positionAvatar3).getId()) {
            selectAvatar(imgAvatar3, lblAvatar3);
        } else if (avatarId == avatarToSelect.get(positionAvatar4).getId()) {
            selectAvatar(imgAvatar4, lblAvatar4);
        } else if (avatarId == avatarToSelect.get(positionAvatar5).getId()) {
            selectAvatar(imgAvatar5, lblAvatar5);
        } else if (avatarId == avatarToSelect.get(positionAvatar6).getId()) {
            selectAvatar(imgAvatar6, lblAvatar6);
        }
    }

    private void deselectedImage() {
        List<Avatar> avatarToSelect = viewModel.queryAvatars();
        Long avatarId = viewModel.getAvatar().getId();

        if (avatarId == avatarToSelect.get(positionAvatar1).getId()) {
            deselectAvatar(imgAvatar1, lblAvatar1);
        } else if (avatarId == avatarToSelect.get(positionAvatar2).getId()) {
            deselectAvatar(imgAvatar2, lblAvatar2);
        } else if (avatarId == avatarToSelect.get(positionAvatar3).getId()) {
            deselectAvatar(imgAvatar3, lblAvatar3);
        } else if (avatarId == avatarToSelect.get(positionAvatar4).getId()) {
            deselectAvatar(imgAvatar4, lblAvatar4);
        } else if (avatarId == avatarToSelect.get(positionAvatar5).getId()) {
            deselectAvatar(imgAvatar5, lblAvatar5);
        } else if (avatarId == avatarToSelect.get(positionAvatar6).getId()) {
            deselectAvatar(imgAvatar6, lblAvatar6);
        }
    }

    private void changeSelectedAvatar(int position) {
        deselectedImage();
        viewModel.changeAvatar(position);
        selectedImage();
    }

    private void selectAvatar(ImageView imgAvatar, TextView lblAvatar) {
        selectImage(imgAvatar);
        imgAvatar.setEnabled(false);
        lblAvatar.setEnabled(false);
    }

    private void deselectAvatar(ImageView imgAvatar, TextView lblAvatar) {
        deselectImage(imgAvatar);
        imgAvatar.setEnabled(true);
        lblAvatar.setEnabled(true);
    }

    private void selectImage(ImageView imageView) {
        imageView.setAlpha(ResourcesUtils.getFloat(this, R.dimen.avatar_selected_image_alpha));
    }

    private void deselectImage(ImageView imageView) {
        imageView.setAlpha(ResourcesUtils.getFloat(this, R.dimen.avatar_not_selected_image_alpha));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_avatar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.mnuSelect) {
            submitAvatar();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public static void startForResult(Activity activity, int requestCode, Avatar avatar) {
        Intent intent = new Intent(activity, AvatarActivity.class);
        intent.putExtra(EXTRA_AVATAR, avatar);
        activity.startActivityForResult(intent, requestCode);
    }

    private void submitAvatar() {
        Intent result = new Intent();
        Avatar avatar = viewModel.getAvatar();

        result.putExtra(EXTRA_AVATAR, avatar);
        setResult(RESULT_OK, result);
        finish();
    }
}
