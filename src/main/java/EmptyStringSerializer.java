import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

 
// This is our fancy serializer that takes care of writing the value desired in the case of a null string.  We could
// write whatever we want in here, but in order to maintain backward compatibility we choose the empty string
// instead of something like "joel is awesome."
public class EmptyStringSerializer extends JsonSerializer<Object> {
  public static final JsonSerializer<Object> INSTANCE = new EmptyStringSerializer();
 
  private EmptyStringSerializer() {}
 
  // Since we know we only get to this serializer in the case where the value is null and the type is String, we can
  // do our handling without any additional logic and write that empty string we are so desperately wanting.
  @Override
  public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
    throws IOException, JsonProcessingException {
 
    jsonGenerator.writeString("");
  }
}