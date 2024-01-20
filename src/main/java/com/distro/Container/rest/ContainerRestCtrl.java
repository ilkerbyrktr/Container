package com.distro.Container.rest;

import com.distro.Container.entity.Cargo;
import com.distro.Container.entity.Container;
import com.distro.Container.entity.Item;
import com.distro.Container.entity.Location;
import com.distro.Container.service.CargoService;
import com.distro.Container.service.ContainerService;
import com.distro.Container.service.ItemService;
import com.distro.Container.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ContainerRestCtrl {
    private ContainerService containerService;
    private CargoService cargoService;
    private ItemService itemService;
    private LocationService locationService;

    @Autowired
    public ContainerRestCtrl(ContainerService containerService, CargoService cargoService, ItemService itemService,LocationService locationService) {
        this.containerService = containerService;
        this.cargoService = cargoService;
        this.itemService = itemService;
        this.locationService = locationService;

    }



    @GetMapping("/containers")
    public List<Container> findAll(){return containerService.findAll();}

    @GetMapping("/containers/{containerId}")
    public Container getContainer(@PathVariable int containerId){
        Container container = containerService.findbyId(containerId);
        return container;
    }
    @PostMapping("/containers")
    public Container addContainer(@RequestBody Container container){
        container.setId(0);
        Container dbContainer=containerService.save(container);
        return dbContainer;
    }
    @PutMapping("/containers")
    public Container updateContainer(@RequestBody Container container){
        Container dbContainer = containerService.save(container);
        return dbContainer;
    }
    @DeleteMapping("/containers/{containerId}")
    public String removerContainer(@PathVariable int containerId){
        containerService.remove(containerId);
        return "Container id: "+containerId+" removed";
    }
    @GetMapping("/containers/{containerId}/list")
    public List<Cargo> getCargo(@PathVariable int containerId){
        Container container = containerService.findbyId(containerId);
        List<Cargo> cargoList = cargoService.findbyContainerCode(container.getContainerCode());
        return cargoList;
    }

    @GetMapping("/containers/list")
    public List<Cargo> findAllCargo(){return cargoService.findAll();}

    @GetMapping("/containers/list/{cargoId}")
    public Cargo getCargoById(@PathVariable int cargoId){
        Cargo cargo = cargoService.findbyId(cargoId);
        return cargo;
    }

    @DeleteMapping("/containers/list/{cargoId}")
    public String removeCargo(@PathVariable int cargoId){
        cargoService.remove(cargoId);
        return "Cargo id: "+cargoId+" removed";
    }

    @PostMapping("/containers/list")
    public Cargo addCargo(@RequestBody Cargo cargo){
        cargo.setCargoId(0);
        Cargo dbCargo = cargoService.save(cargo);
        return dbCargo;
    }

    @PutMapping("/containers/list/{cargoId}")
    public Cargo updateCargo(@RequestBody Cargo cargo){
        Cargo dbCargo = cargoService.save(cargo);
        return dbCargo;
    }
    @GetMapping("/items")
    public List<Item> findItems(){return itemService.findAll();}

    @GetMapping("/items/{itemId}")
    public Item getItem(@PathVariable int itemId){
        Item item = itemService.findbyId(itemId);
        return item;
    }

    @DeleteMapping("/items/{itemId}")
    public String removeItem(@PathVariable int itemId){
        itemService.remove(itemId);
        return "Item id: "+itemId+" removed";
    }

    @GetMapping("/location")
    public List<Location> findAllLoc(){return locationService.findAll();}

    @GetMapping("/location/{locId}")
    public Location findLocbyId(@PathVariable int locId){
        Location location = locationService.findbyId(locId);
        return location;
    }
}
