package server.dto;

import org.modelmapper.ModelMapper;
import server.model.PlaneEntity;
import server.model.PlaneseatEntity;

import javax.validation.constraints.NotNull;

public class PlaneSeatDto {

    @NotNull
    private int number;
    @NotNull
    private int planeid;
    @NotNull
    private boolean free;
    @NotNull
    private PlaneEntity planeByPlaneid;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPlaneid() {
        return planeid;
    }

    public void setPlaneid(int planeid) {
        this.planeid = planeid;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public PlaneEntity getPlaneByPlaneid() {
        return planeByPlaneid;
    }

    public void setPlaneByPlaneid(PlaneEntity planeByPlaneid) {
        this.planeByPlaneid = planeByPlaneid;
    }

    public PlaneseatEntity toEntity(){
        ModelMapper modelMapper = new ModelMapper();
        PlaneseatEntity planeseat = modelMapper.map(this, PlaneseatEntity.class);
        return planeseat;
    }
}
