package com.olxListing.olxproject.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.olxListing.olxproject.entity.Listing;
import com.olxListing.olxproject.entity.User_Entity;

@Service
public interface ListingService {
	
	public Listing addListing(Listing listing);
	
	public List<Listing> displayListings();

	public User_Entity displayContactDetails(int id);

}