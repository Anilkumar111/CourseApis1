package com.grophin.courseapis.services;

import com.grophin.courseapis.dto.request.CourseCreateRequest;
import com.grophin.courseapis.dto.request.UpdateRequest;
import com.grophin.courseapis.dto.response.CreateResponse;
import com.grophin.courseapis.dto.response.UpdateResponse;
import com.grophin.courseapis.models.CourseDetails;

import java.util.List;

public interface CourseServiceInterface {

    CreateResponse addCourse(CourseCreateRequest courseCreateRequest) throws Exception;
    List<CourseDetails> fetchAllCourses() throws Exception;
    CourseDetails fetchByCourseId(String ticketId) throws Exception;
    List<CourseDetails> fetchByUserName(String userName) throws Exception;
    List<CourseDetails> fetchByTitle(String title) throws Exception;
    List<CourseDetails> fetchByStatus(String status) throws Exception;
    UpdateResponse updateDetails(UpdateRequest updateRequest) throws Exception;
    UpdateResponse updateStatus(UpdateRequest updateRequest) throws Exception;
    UpdateResponse updateResponse(UpdateRequest updateRequest) throws Exception;
    UpdateResponse deleteTicket(String ticketId) throws Exception;
}
