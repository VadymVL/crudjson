import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.ser.SerializerFactory;

// We need to customize the DefaultSerializerProvider so that when it is looking for a NullSerializer it
// will use one that is class sensitive, writing strings as "" and everything else using the default value.
public class CustomNullStringSerializerProvider extends DefaultSerializerProvider {
 
  /**
	 * 
	 */
	private static final long serialVersionUID = -5543283473040470742L;

// A couple of constructors and factory methods to keep the compiler happy
  public CustomNullStringSerializerProvider() { super(); }
  public CustomNullStringSerializerProvider(CustomNullStringSerializerProvider provider, SerializationConfig config,
    SerializerFactory jsf) {
    super(provider, config, jsf);
  }
  @Override
  public CustomNullStringSerializerProvider createInstance(SerializationConfig config,
    SerializerFactory jsf) {
    return new CustomNullStringSerializerProvider(this, config, jsf);
  }
 
  // This is the interesting part.  When the property has a null value it will call this method to get the
  // serializer for that null value.  At this point, we have the BeanProperty, which contains information about
  // the field that we are trying to serialize (including the type!)  So we can discriminate on the type to determine
  // which serializer is used to output the null value.
  @Override
  public JsonSerializer<Object> findNullValueSerializer(BeanProperty property) throws JsonMappingException {
    if (property.getType().getRawClass().equals(String.class)) {
      return EmptyStringSerializer.INSTANCE;
    } else {
      return super.findNullValueSerializer(property);
    }
  }
}
