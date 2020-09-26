package cz.cvut.fel.nss.tripguide.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * The type Tour dto.
 */
public class TourDto {

    @NotNull
    @NotEmpty
    private String title;

    @NotNull
    @NotEmpty
    private String start;

    @NotNull
    @NotEmpty
    private String end;

    @NotNull
    private Integer hotel;

    @NotNull
    @NotEmpty
    private String delegate;

    @NotNull
    @NotEmpty
    private String backTransferInfo;


    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets start.
     *
     * @return the start
     */
    public String getStart() {
        return start;
    }

    /**
     * Sets start.
     *
     * @param start the start
     */
    public void setStart(String start) {
        this.start = start;
    }

    /**
     * Gets end.
     *
     * @return the end
     */
    public String getEnd() {
        return end;
    }

    /**
     * Sets end.
     *
     * @param end the end
     */
    public void setEnd(String end) {
        this.end = end;
    }

    /**
     * Gets hotel.
     *
     * @return the hotel
     */
    public Integer getHotel() {
        return hotel;
    }

    /**
     * Sets hotel.
     *
     * @param hotel the hotel
     */
    public void setHotel(Integer hotel) {
        this.hotel = hotel;
    }

    /**
     * Gets delegate.
     *
     * @return the delegate
     */
    public String getDelegate() {
        return delegate;
    }

    /**
     * Sets delegate.
     *
     * @param delegate the delegate
     */
    public void setDelegate(String delegate) {
        this.delegate = delegate;
    }

    /**
     * Gets back transfer info.
     *
     * @return the back transfer info
     */
    public String getBackTransferInfo() {
        return backTransferInfo;
    }

    /**
     * Sets back transfer info.
     *
     * @param backTransferInfo the back transfer info
     */
    public void setBackTransferInfo(String backTransferInfo) {
        this.backTransferInfo = backTransferInfo;
    }
}
