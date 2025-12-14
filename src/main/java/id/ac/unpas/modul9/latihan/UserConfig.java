package id.ac.unpas.modul9.latihan;

import java.io.Serializable;

public class UserConfig implements Serializable {
    private String username;
    private int fontsize;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getFontsize() {
        return fontsize;
    }

    public void setFontsize(int fontsize) {
        this.fontsize = fontsize;
    }
}
