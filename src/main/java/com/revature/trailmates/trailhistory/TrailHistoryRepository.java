package com.revature.trailmates.trailhistory;

import com.revature.trailmates.trailhistory.dto.response.History;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface TrailHistoryRepository extends CrudRepository<TrailHistory, String> {

    @Query(value = "select * from trailhistory where user_id = ?1", nativeQuery = true)
    List<History> getUserHistory(String userID);
}
