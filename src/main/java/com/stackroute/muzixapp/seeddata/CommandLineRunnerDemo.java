package com.stackroute.muzixapp.seeddata;

import com.stackroute.muzixapp.domain.Track;
import com.stackroute.muzixapp.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class CommandLineRunnerDemo implements CommandLineRunner {

    @Autowired
    private TrackRepository trackRepository;

    @Override
    public void run(String... args) throws Exception {
        trackRepository.save(new Track(2, "Sanorita", "Global favorite music"));
    }
}
