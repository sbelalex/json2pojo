
package loginrequest;

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
public class Bar implements Serializable, Parcelable
{

    @SerializedName("type")
    @Expose
    private String type;
    public final static Parcelable.Creator<Bar> CREATOR = new Creator<Bar>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Bar createFromParcel(Parcel in) {
            Bar instance = new Bar();
            instance.type = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Bar[] newArray(int size) {
            return (new Bar[size]);
        }

    }
    ;
    private final static long serialVersionUID = 7195353096028147690L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Bar() {
    }

    /**
     * 
     * @param type
     */
    public Bar(String type) {
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

    public Bar withType(String type) {
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
        if ((other instanceof Bar) == false) {
            return false;
        }
        Bar rhs = ((Bar) other);
        return new EqualsBuilder().append(type, rhs.type).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(type);
    }

    public int describeContents() {
        return  0;
    }

}
