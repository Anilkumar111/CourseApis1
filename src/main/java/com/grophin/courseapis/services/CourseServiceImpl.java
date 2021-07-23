package com.grophin.courseapis.services;

import com.grophin.courseapis.constants.Constants;
import com.grophin.courseapis.dto.request.CourseCreateRequest;
import com.grophin.courseapis.dto.request.UpdateRequest;
import com.grophin.courseapis.dto.response.CreateResponse;
import com.grophin.courseapis.dto.response.UpdateResponse;
import com.grophin.courseapis.models.*;
import com.grophin.courseapis.repos.CourseDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseServiceInterface {


    CourseDetailsRepo courseDetailsRepo;

    @Autowired
    public CourseServiceImpl(CourseDetailsRepo courseDetailsRepo) {
        this.courseDetailsRepo = courseDetailsRepo;
    }



    @Override
    public CreateResponse addCourse(CourseCreateRequest courseCreateRequest) throws Exception {
        CreateResponse agentCreateResponse = new CreateResponse();
        try{


            CourseDetails courseDetails = new CourseDetails();
            courseDetails.setCourseId(courseCreateRequest.getId());
            courseDetails.setDescription(courseCreateRequest.getDescription());
            courseDetails.setCreateUser(courseCreateRequest.getUser());
            courseDetails.setTitle(courseCreateRequest.getTitle());
            courseDetails.setType(courseCreateRequest.getType());
            courseDetails.setContents(courseCreateRequest.getContents());
            courseDetails.setCost(Integer.parseInt(courseCreateRequest.getCost()));
            Date date1=new Date();
            courseDetails.setCreateDate(date1);
            this.courseDetailsRepo.save(courseDetails);

            agentCreateResponse.setId(courseCreateRequest.getId());
            agentCreateResponse.setName(courseCreateRequest.getTitle());
            agentCreateResponse.setStatus(1);
            agentCreateResponse.setMessage("Ticket Created Successfully");

        }
        catch (Exception ex){
            StringWriter stringWriter = new StringWriter();
            ex.printStackTrace(new PrintWriter(stringWriter));
            agentCreateResponse.setStatus(0);
            agentCreateResponse.setMessage("Exception while creating the ticket: \n"+stringWriter);
        }

        return agentCreateResponse;
    }

    @Override
    public List<CourseDetails> fetchAllCourses() throws Exception {
        List<CourseDetails> tickets = this.courseDetailsRepo.findAll();
        return tickets;
    }

    @Override
    public CourseDetails fetchByCourseId(String courseId) throws Exception {
        return this.courseDetailsRepo.findByCourseId(courseId);

    }

    @Override
    public List<CourseDetails> fetchByUserName(String user) throws Exception {
            return this.courseDetailsRepo.findByCreateUser(user);
    }

    @Override
    public List<CourseDetails> fetchByTitle(String title) throws Exception {
        return this.courseDetailsRepo.findByTitle(title);

    }

    @Override
    public UpdateResponse updateDetails(UpdateRequest updateRequest) throws Exception {

        UpdateResponse updateResponse = new UpdateResponse();
//        try{
//            CourseDetails courseDetails = this.courseDetailsRepo.findByTicketId(updateRequest.getTicketId());
//
//            if(updateRequest.getDataMap().get(Constants.CUSTOMER) != null){
//                courseDetails.setContents(updateRequest.getDataMap().get(Constants.CUSTOMER));
//            }
//
//            if(updateRequest.getDataMap().get(Constants.DESCRIPTION) != null){
//                courseDetails.setDescription(updateRequest.getDataMap().get(Constants.DESCRIPTION));
//            }
//
//            if(updateRequest.getDataMap().get(Constants.TYPE) != null){
//                courseDetails.setType(updateRequest.getDataMap().get(Constants.TYPE));
//            }
//
//            if(updateRequest.getDataMap().get(Constants.PRIORITY) != null){
//                courseDetails.setPriority(Integer.parseInt(updateRequest.getDataMap().get(Constants.PRIORITY)));
//            }
//
//            if(updateRequest.getDataMap().get(Constants.TITLE) != null){
//                courseDetails.setTitle(updateRequest.getDataMap().get(Constants.TITLE));
//            }
//
//            if(updateRequest.getDataMap().get(Constants.DEADLINE) != null){
//                Date date = new SimpleDateFormat("dd/MM/yyyy").parse(updateRequest.getDataMap().get(Constants.DEADLINE));
//                courseDetails.setDeadline(date);
//            }
//
//            this.courseDetailsRepo.save(courseDetails);
//            updateResponse.setTicketId(updateRequest.getTicketId());
//            updateResponse.setMessage("Successfully Updated.");
//            updateResponse.setUpdatedFields(updateRequest.getDataMap());
//
//        }
//        catch (Exception ex){
//            StringWriter stringWriter = new StringWriter();
//            ex.printStackTrace(new PrintWriter(stringWriter));
//            updateResponse.setTicketId(updateRequest.getTicketId());
//            updateResponse.setMessage("Exception while updating details\n."+stringWriter);
//            updateResponse.setUpdatedFields(updateRequest.getDataMap());
//        }
        return updateResponse;
    }

    @Override
    public UpdateResponse updateStatus(UpdateRequest updateRequest) throws Exception {
        UpdateResponse updateResponse = new UpdateResponse();
//        try{
//            TicketStatus ticketStatus = this.ticketStatusRepo.findByTicketId(updateRequest.getTicketId());
//            if(updateRequest.getDataMap().get(Constants.STATUS) != null){
//                ticketStatus.setStatus(updateRequest.getDataMap().get(Constants.STATUS));
//            }
//
//            this.ticketStatusRepo.save(ticketStatus);
//
//            updateResponse.setTicketId(updateRequest.getTicketId());
//            updateResponse.setMessage("Successfully Updated.");
//            updateResponse.setUpdatedFields(updateRequest.getDataMap());
//        }
//        catch (Exception ex){
//            StringWriter stringWriter = new StringWriter();
//            ex.printStackTrace(new PrintWriter(stringWriter));
//            updateResponse.setTicketId(updateRequest.getTicketId());
//            updateResponse.setMessage("Exception while updating details\n."+stringWriter);
//            updateResponse.setUpdatedFields(updateRequest.getDataMap());
//        }

        return updateResponse;
    }

    @Override
    public UpdateResponse updateResponse(UpdateRequest updateRequest) throws Exception {
        UpdateResponse updateResponse = new UpdateResponse();
//        try{
//            TicketResponse ticketStatus = this.ticketResponseRepo.findByTicketId(updateRequest.getTicketId());
//            if(updateRequest.getDataMap().get(Constants.RESPONSE) != null){
//                ticketStatus.setResponse(updateRequest.getDataMap().get(Constants.RESPONSE));
//            }
//
//            this.ticketResponseRepo.save(ticketStatus);
//
//            updateResponse.setTicketId(updateRequest.getTicketId());
//            updateResponse.setMessage("Successfully Updated.");
//            updateResponse.setUpdatedFields(updateRequest.getDataMap());
//        }
//        catch (Exception ex){
//            StringWriter stringWriter = new StringWriter();
//            ex.printStackTrace(new PrintWriter(stringWriter));
//            updateResponse.setTicketId(updateRequest.getTicketId());
//            updateResponse.setMessage("Exception while updating details\n."+stringWriter);
//            updateResponse.setUpdatedFields(updateRequest.getDataMap());
//        }

        return updateResponse;
    }

    @Override
    public UpdateResponse deleteTicket(String ticketId) throws Exception {
        UpdateResponse updateResponse = new UpdateResponse();
//        try{
//            TicketResponse ticketResponse = this.ticketResponseRepo.findByTicketId(ticketId);
////            CourseDetails courseDetails = this.courseDetailsRepo.findByTicketId(ticketId);
//            TicketStatus ticketStatus1 = this.ticketStatusRepo.findByTicketId(ticketId);
//            AssignedAgent assignedAgent = this.assignedAgentRepo.findByTicketId(ticketId);
//
////            this.courseDetailsRepo.delete(courseDetails);
//            this.ticketStatusRepo.delete(ticketStatus1);
//            this.ticketResponseRepo.delete(ticketResponse);
//            this.assignedAgentRepo.delete(assignedAgent);
//
//            updateResponse.setTicketId(ticketId);
//            updateResponse.setMessage("Successfully Deleted.");
//            updateResponse.setUpdatedFields(null);
//        }
//        catch (Exception ex){
//            StringWriter stringWriter = new StringWriter();
//            ex.printStackTrace(new PrintWriter(stringWriter));
//            updateResponse.setTicketId(ticketId);
//            updateResponse.setMessage("Exception while Deleting\n."+stringWriter);
//            updateResponse.setUpdatedFields(null);
//        }

        return updateResponse;
    }
}
