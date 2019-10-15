package com.stackroute.muzixapp.service;

import com.stackroute.muzixapp.domain.Track;

import java.util.List;

public interface TrackService {
    public Track saveTrack(Track track);

    public Track getTrackById(int id);

    public void deleteTrack(int id);

    public void deleteAllTracks();

    public List<Track> getAllTracks();

    public Track updateTrack(int id, String comment);

    List<Track> getTrackByName(String name);
}
