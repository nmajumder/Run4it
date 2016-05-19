
package hu.ait.android.run4it.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class UserResult {

    @SerializedName("user")
    @Expose
    private User user;

    /**
     * 
     * @return
     *     The user
     */
    public User getUser() {
        return user;
    }

    /**
     * 
     * @param user
     *     The user
     */
    public void setUser(User user) {
        this.user = user;
    }

}
