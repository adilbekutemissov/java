package cz.cvut.fel.nss.tripguide.service;

import cz.cvut.fel.nss.tripguide.exception.NotFoundException;
import cz.cvut.fel.nss.tripguide.model.Hotel;
import cz.cvut.fel.nss.tripguide.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

/**
 * The class Hotel service.
 */
@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    /**
     * Instantiates a new Hotel service.
     *
     * @param hotelRepository the hotel repository
     */
    @Autowired
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    /**
     * Save hotel.
     *
     * @param hotel the hotel
     * @return the hotel
     */
    public Hotel save(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    /**
     * Remove hotel by id.
     *
     * @param id the id
     */
    public void remove(Integer id) {
        hotelRepository.deleteById(id);
    }

    /**
     * Remove hotel.
     *
     * @param hotel the hotel to remove
     */
    public void remove(Hotel hotel) {
        hotelRepository.delete(hotel);
    }

    /**
     * Find hotel.
     *
     * @param id the id
     * @return the hotel
     */
    public Hotel findHotel(Integer id) {
        Optional<Hotel> hotel = hotelRepository.findById(id);
        if (!hotel.isPresent()) {
            throw new NotFoundException("Hotel not found! ID: " + id);
        }
        return hotel.get();
    }

    /**
     * Gets all hotels.
     *
     * @return the all hotels
     */
    public Set<Hotel> getAllHotels() {
        return hotelRepository.findAllByOrderByIdDesc();
    }

    /**
     * Gets all hotels by name.
     *
     * @return the all hotels by name
     */
    public Set<Hotel> getAllHotelsByName() {
        return hotelRepository.findAllByOrderByNameAsc();
    }
}
