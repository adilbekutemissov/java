package cz.cvut.fel.nss.tripguide.dto;

import javax.validation.constraints.NotEmpty;

/**
 * The type Destination dto.
 */
public class DestinationDto {

    @NotEmpty
    private String name;

    @NotEmpty
    private String country;

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
     * Gets country.
     *
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets country.
     *
     * @param country the country
     */
    public void setCountry(String country) {
        this.country = country;
    }
}
