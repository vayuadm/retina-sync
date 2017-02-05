package adm.vayu.retina.sync.trello;

import adm.vayu.retina.sync.common.RetinaSyncException;
import adm.vayu.retina.sync.trello.data.TrelloBoard;
import adm.vayu.retina.sync.trello.data.TrelloType;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;

class TrelloObjectFactory {

    private static final Charset UTF_8_CHAR_SET = Charset.forName("UTF-8");
    private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";

    private final JsonParser _parser = new JsonParser();
    private Gson _gson = null;

    @SuppressWarnings("unchecked")
    <T> T createObject(TypeToken<T> typeToken, InputStream jsonContent) {

        if (jsonContent == null) {
            return isList(typeToken) ? (T) Collections.emptyList() : null;
        }

        return unmarshallToObj(typeToken, unmarshallToJson(jsonContent));
    }

    private JsonElement unmarshallToJson(InputStream jsonContent) {

        try {
            JsonElement element = _parser.parse(new InputStreamReader(
                    jsonContent,
                    UTF_8_CHAR_SET));
            if (element.isJsonObject()) {
                return element.getAsJsonObject();
            } else if (element.isJsonArray()) {
                return element.getAsJsonArray();
            } else {
                throw new IllegalStateException(
                        "Unknown content found in response." + element);
            }
        } catch (Exception e) {
            throw new RetinaSyncException(e);
        } finally {
            closeStream(jsonContent);
        }
    }

    @SuppressWarnings("unchecked")
    private <T> T unmarshallToObj(TypeToken<T> typeToken, JsonElement response) {

        return (T) getGson().fromJson(response, typeToken.getType());
    }

    private Gson getGson() {

        if (_gson == null) {
            _gson = new GsonBuilder()
                    .setDateFormat(DATE_FORMAT)
                    .registerTypeAdapter(
                            TrelloBoard.PERMISSION_TYPE.class,
                            new PermissionTypeDeserializer())
                    .registerTypeAdapter(
                            TrelloType.class,
                            new TrelloTypeDeserializer())
                    .create();
        }

        return _gson;
    }

    private void closeStream(InputStream is) {

        try {
            if (is != null) {
                is.close();
            }
        } catch (IOException e) {
            throw new RetinaSyncException(e);
        }
    }

    private boolean isList(TypeToken typeToken) {

        return List.class.isAssignableFrom(typeToken.getRawType());
    }

    private static class PermissionTypeDeserializer implements JsonDeserializer<TrelloBoard.PERMISSION_TYPE> {

        public TrelloBoard.PERMISSION_TYPE deserialize(JsonElement json, Type typeOfT,
                                                       JsonDeserializationContext context) throws JsonParseException {

            final String jsonStr = json.getAsString().toUpperCase();

            TrelloBoard.PERMISSION_TYPE[] permissionTypes = TrelloBoard.PERMISSION_TYPE.values();
            for (TrelloBoard.PERMISSION_TYPE permissionType : permissionTypes) {
                if (permissionType.name().equals(jsonStr))
                    return permissionType;
            }

            return null;
        }
    }

    private static class TrelloTypeDeserializer implements JsonDeserializer<TrelloType> {

        public TrelloType deserialize(JsonElement json, Type typeOfT,
                                      JsonDeserializationContext context) throws JsonParseException {
            final String jsonStr = json.getAsString();
            return jsonStr == null ? null : TrelloType.fromString(jsonStr);
        }

    }
}
