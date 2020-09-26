package server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import server.model.PlaneseatEntity;
import server.repositories.PlaneSeatRepository;
import server.service.PlaneSeatService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/planeseat")
public class PlaneseatController {

    @Autowired
    private PlaneSeatService service;

    @Autowired
    private final PlaneSeatRepository repository;

    public PlaneseatController(PlaneSeatService service, PlaneSeatRepository repository){
        this.service = service;
        this.repository = repository;
    }

    @RequestMapping(value="bookingPlaneSeat/{planeid}/{number}", method = RequestMethod.PUT)
    public void bookingPlaneSeat(@PathVariable Integer planeid, @PathVariable Integer number, @RequestParam("free") boolean newFree){
        service.updateFree(number, planeid, newFree);
    }

    @GetMapping(value="/getPlaneSeatByID/{planeid}/{number}")
    public PlaneseatEntity getPlaneSeatByID(@PathVariable Integer planeid, @PathVariable Integer number){
//        return service.getPlaneSeatByID(planeid, number);
        return repository.findPlaneseatEntitiesByNumberAndPlaneid(number, planeid);
    }

    @GetMapping(value="/getAllPlaneseats")
    public List<PlaneseatEntity> getAllPlaneseats(){
        return service.getAllPlaneSeat();
    }

    @GetMapping("/showNumbersByPlaneid/{planeid}")
    public List<PlaneseatEntity> findAllNumberByPlaneid(@PathVariable Integer planeid) {
        return repository.findAllNumberByPlaneidOrderByNumberAsc(planeid);
    }

    @RequestMapping(value="update/{planeid}/{number}", method= RequestMethod.PUT)
    public void update(@PathVariable PlaneseatEntity planeSeat){
//        service.update(planeSeat);
    }
}
