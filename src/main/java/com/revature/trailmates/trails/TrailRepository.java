package com.revature.trailmates.trails;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TrailRepository extends CrudRepository<Trail, String> {

    @Modifying
    @Query(value = "INSERT INTO trails (id, name, short_desc, long_desc, image_url, website_url, is_reservation_required, are_pets_permitted, do_fees_apply, duration) VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10)", nativeQuery = true)
    void saveTrailName(String id, String name, String short_desc, String long_desc, String image_url, String website_url, Boolean isReservationRequired, Boolean arePetsPermitted, Boolean doFeesApply, String duration);
    
}
