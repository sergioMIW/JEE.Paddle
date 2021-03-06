package data.entities;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Token {

    @Id
    @GeneratedValue
    private int id;

    @Column(unique = true, nullable = false)
    private String value;

    @ManyToOne
    @JoinColumn
    private User user;

    @Column(unique = false, nullable = false)
    private long createConnection;

    public final long TIME_TO_EXPIRED = 3600*1000;

    public Token() {
    }

    public Token(User user) {
        assert user != null;
        this.user = user;
        this.value = new Encrypt()
                .encryptInBase64UrlSafe("" + user.getId() + user.getUsername() + Long.toString(new Date().getTime()) + user.getPassword());
        this.createConnection = Calendar.getInstance().getTimeInMillis();
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public User getUser() {
        return user;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        return id == ((Token) obj).id;
    }

    public long getCreateConnection() {
        return createConnection;
    }

    public void setCreateConnection(long createConnection) {
        this.createConnection = createConnection;
    }

    public boolean isValidTime() {
        return ((Calendar.getInstance().getTimeInMillis() - createConnection) <= TIME_TO_EXPIRED);
    }

    @Override
    public String toString() {
        return "Token [id=" + id + ", value=" + value + ", userId=" + user.getId() + ", createConnection=" + createConnection + "]";
    }
}
