package com.example.load.controller;

import com.example.load.model.Load;
import com.example.load.repository.LoadRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class LoadController {
    @Autowired
    private LoadRepository loadRepository;

    @GetMapping("/load")
    public ResponseEntity<List<Load>> getAllLoad(){
        try{
            List<Load> loads = new ArrayList<Load>();
            loadRepository.findAll().forEach(loads::add);
            return new ResponseEntity<>(loads, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/load/{id}")
    public ResponseEntity<Load> getLoadById(@PathVariable("id") long id) {
        Optional<Load> loadData = loadRepository.findById(id);

        if(loadData.isPresent()) {
            return new ResponseEntity<>(loadData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/load")
    public ResponseEntity<Load> getLoadById(@RequestBody Load load) {
        try{
            Load _load = loadRepository.save(new Load(load.getNoOfTrucks(), load.getLoadingPoint(), load.getUnloadingPoint(), load.getProductType(), load.getTruckType(), load.getNoOfTrucks(), load.getWeight(), load.getShipperId(), load.getCreationDate()));
            return new ResponseEntity<>(_load, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/load/{shipperId}")
    public ResponseEntity<Load> updateLoad(@PathVariable("id") long id, @RequestBody Load load){
        Optional<Load> loadData = loadRepository.findById(id);

        if(loadData.isPresent()){
            Load _load = loadData.get();
            _load.setLoadingPoint(load.getLoadingPoint());
            _load.setUnloadingPoint(load.getUnloadingPoint());
            _load.setNoOfTrucks(load.getNoOfTrucks());
            _load.setProductType(load.getProductType());
            _load.setTruckType(load.getTruckType());
            _load.setWeight(load.getWeight());
            _load.setShipperId(load.getShipperId());
            _load.setCreationDate(load.getCreationDate());
            return new ResponseEntity<>(loadRepository.save(_load), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/load/{id}")
    public ResponseEntity<HttpStatus> deleteLoad(@PathVariable("id") long id) {
        try {
            loadRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
