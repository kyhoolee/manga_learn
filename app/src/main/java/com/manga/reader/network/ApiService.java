package com.manga.reader.network;

/**
 * Created by ravi on 02/03/18.
 */

import java.util.List;

import com.manga.reader.network.model.Price;
import com.manga.reader.network.model.Ticket;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("airline-tickets.php")
    Single<List<Ticket>> searchTickets(@Query("from") String from, @Query("to") String to);

    @GET("airline-tickets-price.php")
    Single<Price> getPrice(@Query("flight_number") String flightNumber, @Query("from") String from, @Query("to") String to);
}
