
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
public class Properties implements Serializable, Parcelable
{

    @SerializedName("foo")
    @Expose
    private Foo foo;
    @SerializedName("bar")
    @Expose
    private Bar bar;
    @SerializedName("baz")
    @Expose
    private Baz baz;
    public final static Parcelable.Creator<Properties> CREATOR = new Creator<Properties>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Properties createFromParcel(Parcel in) {
            Properties instance = new Properties();
            instance.foo = ((Foo) in.readValue((Foo.class.getClassLoader())));
            instance.bar = ((Bar) in.readValue((Bar.class.getClassLoader())));
            instance.baz = ((Baz) in.readValue((Baz.class.getClassLoader())));
            return instance;
        }

        public Properties[] newArray(int size) {
            return (new Properties[size]);
        }

    }
    ;
    private final static long serialVersionUID = -8279907424960745012L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Properties() {
    }

    /**
     * 
     * @param bar
     * @param foo
     * @param baz
     */
    public Properties(Foo foo, Bar bar, Baz baz) {
        super();
        this.foo = foo;
        this.bar = bar;
        this.baz = baz;
    }

    /**
     * 
     * @return
     *     The foo
     */
    public Foo getFoo() {
        return foo;
    }

    /**
     * 
     * @param foo
     *     The foo
     */
    public void setFoo(Foo foo) {
        this.foo = foo;
    }

    public Properties withFoo(Foo foo) {
        this.foo = foo;
        return this;
    }

    /**
     * 
     * @return
     *     The bar
     */
    public Bar getBar() {
        return bar;
    }

    /**
     * 
     * @param bar
     *     The bar
     */
    public void setBar(Bar bar) {
        this.bar = bar;
    }

    public Properties withBar(Bar bar) {
        this.bar = bar;
        return this;
    }

    /**
     * 
     * @return
     *     The baz
     */
    public Baz getBaz() {
        return baz;
    }

    /**
     * 
     * @param baz
     *     The baz
     */
    public void setBaz(Baz baz) {
        this.baz = baz;
    }

    public Properties withBaz(Baz baz) {
        this.baz = baz;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(foo).append(bar).append(baz).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Properties) == false) {
            return false;
        }
        Properties rhs = ((Properties) other);
        return new EqualsBuilder().append(foo, rhs.foo).append(bar, rhs.bar).append(baz, rhs.baz).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(foo);
        dest.writeValue(bar);
        dest.writeValue(baz);
    }

    public int describeContents() {
        return  0;
    }

}
