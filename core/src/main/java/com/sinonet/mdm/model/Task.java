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
 * Date: 13-10-29
 * Time: 下午7:08
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "app_Task")
@Indexed
@XmlRootElement
public class Task extends BaseObject implements Serializable {
    private Long id;
    private String name;
    private String status;
    private String commandUUID;
    private Device device;
    private byte[] command;
    private byte[] result;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @DocumentId
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Field
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Field
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCommandUUID() {
        return commandUUID;
    }

    public void setCommandUUID(String commandUUID) {
        this.commandUUID = commandUUID;
    }
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "device_id")
    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }
    @Column(length = 10000)
    public byte[] getCommand() {
        return command;
    }

    public void setCommand(byte[] command) {
        this.command = command;
    }
    @Column(length = 10000)
    public byte[] getResult() {
        return result;
    }

    public void setResult(byte[] result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;

        Task task = (Task) o;

        if (!Arrays.equals(command, task.command)) return false;
        if (commandUUID != null ? !commandUUID.equals(task.commandUUID) : task.commandUUID != null) return false;
        if (device != null ? !device.equals(task.device) : task.device != null) return false;
        if (id != null ? !id.equals(task.id) : task.id != null) return false;
        if (name != null ? !name.equals(task.name) : task.name != null) return false;
        if (!Arrays.equals(result, task.result)) return false;
        if (status != null ? !status.equals(task.status) : task.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result1 = id != null ? id.hashCode() : 0;
        result1 = 31 * result1 + (name != null ? name.hashCode() : 0);
        result1 = 31 * result1 + (status != null ? status.hashCode() : 0);
        result1 = 31 * result1 + (commandUUID != null ? commandUUID.hashCode() : 0);
        result1 = 31 * result1 + (device != null ? device.hashCode() : 0);
        result1 = 31 * result1 + (command != null ? Arrays.hashCode(command) : 0);
        result1 = 31 * result1 + (result != null ? Arrays.hashCode(result) : 0);
        return result1;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", commandUUID='" + commandUUID + '\'' +
                ", device=" + device +
                ", command=" + Arrays.toString(command) +
                ", result=" + Arrays.toString(result) +
                '}';
    }
}
