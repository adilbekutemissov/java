package cz.cvut.fel.nss.tripguide.dto;

import javax.validation.constraints.NotEmpty;

/**
 * The type Local attr dto.
 */
public class LocalAttrDto {

    @NotEmpty
    private String name;

    @NotEmpty
    private String address;

    @NotEmpty
    private String description;

    @NotEmpty
    private String price;

    private String url;

    @NotEmpty
    private String photoUrl;

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public String getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * Gets url.
     *
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets url.
     *
     * @param url the url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Gets photo url.
     *
     * @return the photo url
     */
    public String getPhotoUrl() {
        return photoUrl;
    }

    /**
     * Sets photo url.
     *
     * @param photoUrl the photo url
     */
    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

}
