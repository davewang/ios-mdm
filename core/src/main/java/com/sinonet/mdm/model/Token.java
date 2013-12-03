package com.sinonet.mdm.model;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 13-10-25
 * Time: 下午12:49
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "app_token")
@Indexed
@XmlRootElement
public class Token extends BaseObject implements Serializable {
    private Long id;
    private byte[] token;
    private String pushMagic;
    private byte[] unlockToken;
    private String topic;
    private String udid;
    private Device device;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @DocumentId
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getToken() {
        return token;
    }

    public void setToken(byte[] token) {
        this.token = token;
    }
    @Field
    public String getPushMagic() {
        return pushMagic;
    }

    public void setPushMagic(String pushMagic) {
        this.pushMagic = pushMagic;
    }

    @Column(length = 10000)
    public byte[] getUnlockToken() {
        return unlockToken;
    }

    public void setUnlockToken(byte[] unlockToken) {
        this.unlockToken = unlockToken;
    }
    @Field
    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
    @Field
    public String getUdid() {
        return udid;
    }

    public void setUdid(String udid) {
        this.udid = udid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Token)) return false;

        Token token1 = (Token) o;

        if (device != null ? !device.equals(token1.device) : token1.device != null) return false;
        if (id != null ? !id.equals(token1.id) : token1.id != null) return false;
        if (pushMagic != null ? !pushMagic.equals(token1.pushMagic) : token1.pushMagic != null) return false;
        if (!Arrays.equals(token, token1.token)) return false;
        if (topic != null ? !topic.equals(token1.topic) : token1.topic != null) return false;
        if (udid != null ? !udid.equals(token1.udid) : token1.udid != null) return false;
        if (!Arrays.equals(unlockToken, token1.unlockToken)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (token != null ? Arrays.hashCode(token) : 0);
        result = 31 * result + (pushMagic != null ? pushMagic.hashCode() : 0);
        result = 31 * result + (unlockToken != null ? Arrays.hashCode(unlockToken) : 0);
        result = 31 * result + (topic != null ? topic.hashCode() : 0);
        result = 31 * result + (udid != null ? udid.hashCode() : 0);
        result = 31 * result + (device != null ? device.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Token{" +
                "id=" + id +
                ", token=" + Arrays.toString(token) +
                ", pushMagic='" + pushMagic + '\'' +
                ", unlockToken=" + Arrays.toString(unlockToken) +
                ", topic='" + topic + '\'' +
                ", udid='" + udid + '\'' +
                ", device=" + device +
                '}';
    }
}
