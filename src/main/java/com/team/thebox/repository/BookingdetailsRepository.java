package com.team.thebox.repository;

import com.team.thebox.model.BookingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface BookingdetailsRepository extends JpaRepository<BookingDetails, Long> {
    List<BookingDetails> findAllByUserid(String userid);

    @Query("select poster from BookingDetails where title = :title")
    Map<String, Object> findPoster(@Param("title") String title);
}
