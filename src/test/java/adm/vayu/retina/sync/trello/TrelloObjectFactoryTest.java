package adm.vayu.retina.sync.trello;

import adm.vayu.retina.sync.trello.data.TrelloCard;
import com.google.gson.reflect.TypeToken;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

public class TrelloObjectFactoryTest {

    @Test
    public void testCreateObjectNullContent() {

        Assert.assertEquals(
                new TrelloObjectFactory().createObject(
                        new TypeToken<List<TrelloCard>>() {
                        }, null),
                Collections.emptyList());
    }

    @Test
    public void testCreateCard() {

        InputStream cards = toInputStream("[\n" +
                "\t{\n" +
                "\t\t\"id\": \"569f382c98271847792ef8be\",\n" +
                "\t\t\"checkItemStates\": null,\n" +
                "\t\t\"closed\": false,\n" +
                "\t\t\"dateLastActivity\": \"2016-08-16T13:33:35.182Z\",\n" +
                "\t\t\"desc\": \"Implement Attachments as nested entity/parent-child in order to support UX design\",\n" +
                "\t\t\"descData\": {\n" +
                "\t\t\t\"emoji\": {}\n" +
                "\t\t},\n" +
                "\t\t\"idBoard\": \"56852ae7845018beb6925da1\",\n" +
                "\t\t\"idList\": \"56852ae7845018beb6925da2\",\n" +
                "\t\t\"idMembersVoted\": [],\n" +
                "\t\t\"idShort\": 17,\n" +
                "\t\t\"idAttachmentCover\": null,\n" +
                "\t\t\"manualCoverAttachment\": false,\n" +
                "\t\t\"idLabels\": [],\n" +
                "\t\t\"name\": \"Support Attachments - Iris\",\n" +
                "\t\t\"pos\": 458752,\n" +
                "\t\t\"shortLink\": \"6bz1jWWo\",\n" +
                "\t\t\"badges\": {\n" +
                "\t\t\t\"votes\": 0,\n" +
                "\t\t\t\"viewingMemberVoted\": false,\n" +
                "\t\t\t\"subscribed\": false,\n" +
                "\t\t\t\"fogbugz\": \"\",\n" +
                "\t\t\t\"checkItems\": 1,\n" +
                "\t\t\t\"checkItemsChecked\": 0,\n" +
                "\t\t\t\"comments\": 0,\n" +
                "\t\t\t\"attachments\": 0,\n" +
                "\t\t\t\"description\": true,\n" +
                "\t\t\t\"due\": null,\n" +
                "\t\t\t\"dueComplete\": false\n" +
                "\t\t},\n" +
                "\t\t\"dueComplete\": false,\n" +
                "\t\t\"due\": null,\n" +
                "\t\t\"idChecklists\": [\n" +
                "\t\t\t\"57b316207622a7f8a85e53f9\"\n" +
                "\t\t],\n" +
                "\t\t\"idMembers\": [\n" +
                "\t\t\t\"54e19c97559e3ff7492f914f\"\n" +
                "\t\t],\n" +
                "\t\t\"labels\": [],\n" +
                "\t\t\"shortUrl\": \"https://trello.com/c/6bz1jWWo\",\n" +
                "\t\t\"subscribed\": false,\n" +
                "\t\t\"url\": \"https://trello.com/c/6bz1jWWo/17-support-attachments-iris\"\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"id\": \"57bae2c206b300d37ec87473\",\n" +
                "\t\t\"checkItemStates\": null,\n" +
                "\t\t\"closed\": false,\n" +
                "\t\t\"dateLastActivity\": \"2016-08-25T10:51:21.586Z\",\n" +
                "\t\t\"desc\": \"Due to an issue with the json parser in iris - non UTF-8 characters are indexed wrong.\\ne.g.: \\\"FullName\\\": \\\"Gillian Hagström\\\" --> \\\"full-name\\\": \\\"Gillian Hagstr�m\\\"\\nThis interferes with globalization agenda for 14.00.\",\n" +
                "\t\t\"descData\": {\n" +
                "\t\t\t\"emoji\": {}\n" +
                "\t\t},\n" +
                "\t\t\"idBoard\": \"56852ae7845018beb6925da1\",\n" +
                "\t\t\"idList\": \"56852ae7845018beb6925da2\",\n" +
                "\t\t\"idMembersVoted\": [],\n" +
                "\t\t\"idShort\": 56,\n" +
                "\t\t\"idAttachmentCover\": null,\n" +
                "\t\t\"manualCoverAttachment\": false,\n" +
                "\t\t\"idLabels\": [],\n" +
                "\t\t\"name\": \"BUG: Iris does not support non-UTF-8 characters\",\n" +
                "\t\t\"pos\": 737280,\n" +
                "\t\t\"shortLink\": \"QgPwLI3G\",\n" +
                "\t\t\"badges\": {\n" +
                "\t\t\t\"votes\": 0,\n" +
                "\t\t\t\"viewingMemberVoted\": false,\n" +
                "\t\t\t\"subscribed\": false,\n" +
                "\t\t\t\"fogbugz\": \"\",\n" +
                "\t\t\t\"checkItems\": 0,\n" +
                "\t\t\t\"checkItemsChecked\": 0,\n" +
                "\t\t\t\"comments\": 0,\n" +
                "\t\t\t\"attachments\": 0,\n" +
                "\t\t\t\"description\": true,\n" +
                "\t\t\t\"due\": null,\n" +
                "\t\t\t\"dueComplete\": false\n" +
                "\t\t},\n" +
                "\t\t\"dueComplete\": false,\n" +
                "\t\t\"due\": null,\n" +
                "\t\t\"idChecklists\": [],\n" +
                "\t\t\"idMembers\": [\n" +
                "\t\t\t\"54e19c97559e3ff7492f914f\",\n" +
                "\t\t\t\"56a64ad73100b40cb77c2815\"\n" +
                "\t\t],\n" +
                "\t\t\"labels\": [],\n" +
                "\t\t\"shortUrl\": \"https://trello.com/c/QgPwLI3G\",\n" +
                "\t\t\"subscribed\": false,\n" +
                "\t\t\"url\": \"https://trello.com/c/QgPwLI3G/56-bug-iris-does-not-support-non-utf-8-characters\"\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"id\": \"56ae1cb59649cca7dceab7ba\",\n" +
                "\t\t\"checkItemStates\": null,\n" +
                "\t\t\"closed\": false,\n" +
                "\t\t\"dateLastActivity\": \"2016-08-25T10:58:55.627Z\",\n" +
                "\t\t\"desc\": \"\",\n" +
                "\t\t\"descData\": null,\n" +
                "\t\t\"idBoard\": \"56852ae7845018beb6925da1\",\n" +
                "\t\t\"idList\": \"56852ae7845018beb6925da2\",\n" +
                "\t\t\"idMembersVoted\": [],\n" +
                "\t\t\"idShort\": 20,\n" +
                "\t\t\"idAttachmentCover\": null,\n" +
                "\t\t\"manualCoverAttachment\": false,\n" +
                "\t\t\"idLabels\": [],\n" +
                "\t\t\"name\": \"UI - Add run steps tab\",\n" +
                "\t\t\"pos\": 749568,\n" +
                "\t\t\"shortLink\": \"54rX3rFl\",\n" +
                "\t\t\"badges\": {\n" +
                "\t\t\t\"votes\": 0,\n" +
                "\t\t\t\"viewingMemberVoted\": false,\n" +
                "\t\t\t\"subscribed\": false,\n" +
                "\t\t\t\"fogbugz\": \"\",\n" +
                "\t\t\t\"checkItems\": 0,\n" +
                "\t\t\t\"checkItemsChecked\": 0,\n" +
                "\t\t\t\"comments\": 0,\n" +
                "\t\t\t\"attachments\": 0,\n" +
                "\t\t\t\"description\": false,\n" +
                "\t\t\t\"due\": null,\n" +
                "\t\t\t\"dueComplete\": false\n" +
                "\t\t},\n" +
                "\t\t\"dueComplete\": false,\n" +
                "\t\t\"due\": null,\n" +
                "\t\t\"idChecklists\": [],\n" +
                "\t\t\"idMembers\": [\n" +
                "\t\t\t\"569c917e5717fd5a123fbb93\"\n" +
                "\t\t],\n" +
                "\t\t\"labels\": [],\n" +
                "\t\t\"shortUrl\": \"https://trello.com/c/54rX3rFl\",\n" +
                "\t\t\"subscribed\": false,\n" +
                "\t\t\"url\": \"https://trello.com/c/54rX3rFl/20-ui-add-run-steps-tab\"\n" +
                "\t}\n" +
                "]");
        Assert.assertEquals(3, new TrelloObjectFactory().createObject(
                new TypeToken<List<TrelloCard>>() {
                }, cards).size());
    }

    private InputStream toInputStream(String json) {

        return new ByteArrayInputStream(json.getBytes(StandardCharsets.UTF_8));
    }
}
