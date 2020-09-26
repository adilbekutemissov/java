package cz.cvut.fel.nss.tripguide.dto;

import javax.validation.constraints.NotEmpty;

/**
 * The type Message dto.
 */
public class MessageDto {

    @NotEmpty
    private String text;

    /**
     * Gets text.
     *
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * Sets text.
     *
     * @param text the text
     */
    public void setText(String text) {
        this.text = text;
    }
}
