/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group14.app.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import group14.app.dao.HotelRequestDAO;
import group14.app.model.HotelRequest;

/**s
 *
 * @author christopher
 */
@Service
public class HotelRequestService {
    
    @Autowired
    private HotelRequestDAO hotel_req_dao;
    
	/**
	 * 
	 * @param request 
	 */
	public void createRequest(HotelRequest request) {
		hotel_req_dao.createRequest(request);		
	}
	
	/**
	 * 
	 * @return list of all hotel requests
	 */
    public List<HotelRequest> getAllHotelRequests(){
            List<HotelRequest> allHotelRequests = hotel_req_dao.getAllRequests();
            return allHotelRequests;
    }
    
	/**
	 * 
	 * @param pid 
	 */
    public void acceptRequest(String pid) {
	   	hotel_req_dao.acceptRequest(pid);
		
    }
    
	/**
	 * 
	 * @param id 
	 */
    public void deleteReq(String id) {
    	HotelRequest req=hotel_req_dao.getHotelRequestById(id);
    	hotel_req_dao.deleteHotelRequest(req);
    }
	
	/**
	 * 
	 * @param id
	 * @return hotel request by id
	 */
	public HotelRequest getHotelRequestsById(String id){
		HotelRequest req= hotel_req_dao.getHotelRequestById(id);
		return req;
	}


}
