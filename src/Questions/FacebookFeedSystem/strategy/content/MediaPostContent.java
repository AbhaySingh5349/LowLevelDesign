package Questions.FacebookFeedSystem.strategy.content;

import Questions.FacebookFeedSystem.enums.ContentType;

public class MediaPostContent implements IPostContent{
    private final String mediaUrl;
    private final ContentType contentType;

    public MediaPostContent(ContentType contentType, String mediaUrl) {
        this.contentType = contentType;
        this.mediaUrl = mediaUrl;
    }

    @Override
    public String getContent() {
        return String.format("%s: %s", this.contentType, this.mediaUrl);
    }
}
