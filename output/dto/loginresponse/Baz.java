
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
public class Baz implements Serializable, Parcelable
{

    @SerializedName("type")
    @Expose
    private String type;
    public final static Parcelable.Creator<Baz> CREATOR = new Creator<Baz>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Baz createFromParcel(Parcel in) {
            Baz instance = new Baz();
            instance.type = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Baz[] newArray(int size) {
            return (new Baz[size]);
        }

    }
    ;
    private final static long serialVersionUID = 7832092926996049409L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Baz() {
    }

    /**
     * 
     * @param type
     */
    public Baz(String type) {
        super();
        this.type = type;
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

    public Baz withType(String type) {
        this.type = type;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(type).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Baz) == false) {
            return false;
        }
        Baz rhs = ((Baz) other);
        return new EqualsBuilder().append(type, rhs.type).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(type);
    }

    public int describeContents() {
        return  0;
    }

}
