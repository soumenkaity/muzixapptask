package com.stackroute.muzixapp.controller;

import com.stackroute.muzixapp.domain.Track;
import com.stackroute.muzixapp.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzixapp.exceptions.TrackNotFoundException;
import com.stackroute.muzixapp.service.TrackService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1")
public class TrackController {

    TrackService trackService;

    public TrackController(TrackService trackService){
        this.trackService = trackService;
    }

    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) throws TrackAlreadyExistsException {

        ResponseEntity responseEntity;

        trackService.saveTrack(track);
        responseEntity = new ResponseEntity("Successfully Created", HttpStatus.CREATED);

        return responseEntity;
    }

    @DeleteMapping(value = "deleteall")
    public ResponseEntity<?> deleteAllTracks(){
        ResponseEntity<?> responseEntity;

        try{
            trackService.deleteAllTracks();
            responseEntity = new ResponseEntity("Deleted Successfully", HttpStatus.OK);

        } catch (Exception ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }

        return responseEntity;
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteTrack(@PathVariable Integer id) throws TrackNotFoundException {

        ResponseEntity responseEntity;

        trackService.deleteTrack(id);
        responseEntity = new ResponseEntity("Deleted Successfully", HttpStatus.OK);


        return responseEntity;
    }

    @PutMapping(value = "/update/{id}/{comment}")
    public ResponseEntity<?> updateTrack(@PathVariable int id, @PathVariable String comment) throws TrackNotFoundException {

        ResponseEntity responseEntity;

        trackService.updateTrack(id,comment);
        responseEntity = new ResponseEntity<String>("Updated Successfully", HttpStatus.CREATED);

        return responseEntity;

    }

    @GetMapping("track")
    public ResponseEntity<?> getAllTracks() {
        return new ResponseEntity<>(trackService.getAllTracks(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> getTrackById(@PathVariable int id) throws TrackNotFoundException {
        ResponseEntity responseEntity;

        trackService.getTrackById(id);
        responseEntity = new ResponseEntity<String>("Track Details", HttpStatus.FOUND);

        return responseEntity;
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<?> getTracksByName(@PathVariable String name) {
        System.out.println(trackService.getTrackByName(name).toString());
        return new ResponseEntity<>(trackService.getTrackByName(name), HttpStatus.OK);
    }
}

