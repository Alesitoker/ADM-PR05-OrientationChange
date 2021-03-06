package es.iessaladillo.pedrojoya.pr05.ui.avatar;

import java.util.List;

import androidx.lifecycle.ViewModel;
import es.iessaladillo.pedrojoya.pr05.data.local.Database;
import es.iessaladillo.pedrojoya.pr05.data.local.model.Avatar;

public class AvatarActivityViewModel extends ViewModel {

    private final Database database = Database.getInstance();
    private Avatar avatar;

    public Avatar getAvatar() {
        return avatar;
    }

    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

    public void changeAvatar(int position) {
        this.avatar = database.queryAvatar(database.queryAvatars().get(position).getId());
    }

    public List<Avatar> queryAvatars() {
        return database.queryAvatars();
    }
}
