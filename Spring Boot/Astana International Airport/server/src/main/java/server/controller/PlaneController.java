package server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import server.dto.PlaneDto;
import server.model.PlaneEntity;
import server.service.PlaneService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/plane")
public class PlaneController {

    @Autowired
    private PlaneService service;

    public PlaneController(PlaneService service){
        this.service = service;
    }

    @RequestMapping(value="/create", method= RequestMethod.POST)
    public PlaneEntity create(@RequestBody PlaneDto planeDto){
        return service.create(planeDto);
    }

    @GetMapping(value="/getPlaneByID")
    public Optional<PlaneEntity> getPlaneByID(@Validated @RequestParam("id") Integer id) {
        return service.getPlaneByID(id);
    }

    @GetMapping(value="/getAllPlanes")
    public List<PlaneEntity> getAllPlanes(){
        return service.getAllPlane();
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id){
        service.deleteById(id);
    }
}
