
package com.example.project.dto.loginrequest;

import java.io.Serializable;
import javax.annotation.Generated;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class LoginRequest implements Serializable, Parcelable
{

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("properties")
    @Expose
    private Properties properties;
    public final static Parcelable.Creator<LoginRequest> CREATOR = new Creator<LoginRequest>() {


        @SuppressWarnings({
            "unchecked"
        })
        public LoginRequest createFromParcel(Parcel in) {
            LoginRequest instance = new LoginRequest();
            instance.type = ((String) in.readValue((String.class.getClassLoader())));
            instance.properties = ((Properties) in.readValue((Properties.class.getClassLoader())));
            return instance;
        }

        public LoginRequest[] newArray(int size) {
            return (new LoginRequest[size]);
        }

    }
    ;
    private final static long serialVersionUID = 1646669448555723502L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public LoginRequest() {
    }

    /**
     * 
     * @param properties
     * @param type
     */
    public LoginRequest(String type, Properties properties) {
        super();
        this.type = type;
        this.properties = properties;
    }

    /**
     * 
     * @return
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    public void setType(String type) {
        this.type = type;
    }

    public LoginRequest withType(String type) {
        this.type = type;
        return this;
    }

    /**
     * 
     * @return
     *     The properties
     */
    public Properties getProperties() {
        return properties;
    }

    /**
     * 
     * @param properties
     *     The properties
     */
    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public LoginRequest withProperties(Properties properties) {
        this.properties = properties;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(type).append(properties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof LoginRequest) == false) {
            return false;
        }
        LoginRequest rhs = ((LoginRequest) other);
        return new EqualsBuilder().append(type, rhs.type).append(properties, rhs.properties).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(type);
        dest.writeValue(properties);
    }

    public int describeContents() {
        return  0;
    }

}
