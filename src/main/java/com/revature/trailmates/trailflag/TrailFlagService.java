package com.revature.trailmates.trailflag;

import com.revature.trailmates.trailflag.dtos.requests.GetAllByDateIntAndUserIdRequest;
import com.revature.trailmates.trailflag.dtos.requests.NewTrailFlagRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class TrailFlagService {


    private final TrailFlagRepository trailFlagRepository;

    @Autowired
    public TrailFlagService(TrailFlagRepository trailFlagRepository){
        this.trailFlagRepository=trailFlagRepository;
    }
    public Optional<List<TrailFlag>> getAllByDateIntAndUserId(GetAllByDateIntAndUserIdRequest request){
        return trailFlagRepository.getAllByDateIntAndUserId(request.getDate_int(),request.getUser_id());
    }
    public Optional<List<TrailFlag>> getAllByUserId(String user_id){
        return trailFlagRepository.getAllByUserId(user_id);
    }
    public Optional<List<TrailFlag>> getAllByTrailId(String trail_id){
        return trailFlagRepository.getAllByTrailId(trail_id);
    }
    public TrailFlag saveNewTrailFlag(NewTrailFlagRequest request){
        TrailFlag newFlag = new TrailFlag(request);
        if (!isDuplicateFlag(newFlag)){
            trailFlagRepository.save(newFlag);
            return newFlag;
        } else return null;

    }
    public boolean isDuplicateFlag(TrailFlag flag){
        if (trailFlagRepository.getAllByDateIntAndUserIdAndTrailId(flag.getDate_int(),flag.getUser_id(),flag.getTrail_id())==null){
            return false;
        } else return true;
    }

    public boolean deleteTrailFlag(String id){
        try {
            trailFlagRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
