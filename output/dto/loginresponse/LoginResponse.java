
package loginresponse;

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
public class LoginResponse implements Serializable, Parcelable
{

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("properties")
    @Expose
    private Properties properties;
    public final static Parcelable.Creator<LoginResponse> CREATOR = new Creator<LoginResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public LoginResponse createFromParcel(Parcel in) {
            LoginResponse instance = new LoginResponse();
            instance.type = ((String) in.readValue((String.class.getClassLoader())));
            instance.properties = ((Properties) in.readValue((Properties.class.getClassLoader())));
            return instance;
        }

        public LoginResponse[] newArray(int size) {
            return (new LoginResponse[size]);
        }

    }
    ;
    private final static long serialVersionUID = 7377511096758767369L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public LoginResponse() {
    }

    /**
     * 
     * @param type
     * @param properties
     */
    public LoginResponse(String type, Properties properties) {
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

    public LoginResponse withType(String type) {
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

    public LoginResponse withProperties(Properties properties) {
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
        if ((other instanceof LoginResponse) == false) {
            return false;
        }
        LoginResponse rhs = ((LoginResponse) other);
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
