package Questions.FacebookFeedSystem.strategy.content;

import Questions.FacebookFeedSystem.enums.ContentType;

public class TextPostContent implements IPostContent{
    private final String text;
    private final ContentType contentType;

    public TextPostContent(String text, ContentType contentType) {
        this.text = text;
        this.contentType = contentType;
    }

    @Override
    public String getContent() {
        return String.format("%s: %s", this.contentType, this.text);
    }
}
