package server.dto;

import org.modelmapper.ModelMapper;
import server.model.PlaneEntity;
import server.model.PlaneseatEntity;

import javax.validation.constraints.NotNull;
import java.util.List;

public class PlaneDto {

    @NotNull
    private int id;
    @NotNull
    private int airlineid;
//    @NotNull
//    private AirlineEntity airlineByAirlineid;
    @NotNull
    private List<PlaneseatEntity> planeseatsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAirlineid() {
        return airlineid;
    }

    public void setAirlineid(int airlineid) {
        this.airlineid = airlineid;
    }

//    public AirlineEntity getAirlineByAirlineid() {
//        return airlineByAirlineid;
//    }
//
//    public void setAirlineByAirlineid(AirlineEntity airlineByAirlineid) {
//        this.airlineByAirlineid = airlineByAirlineid;
//    }
//
    public List<PlaneseatEntity> getPlaneseatsById() {
        return planeseatsById;
    }

    public void setPlaneseatsById(List<PlaneseatEntity> planeseatsById) {
        this.planeseatsById = planeseatsById;
    }

    public PlaneEntity toEntity(){
        ModelMapper modelMapper = new ModelMapper();
        PlaneEntity plane = modelMapper.map(this, PlaneEntity.class);
        return plane;
    }
}
