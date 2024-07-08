package org.olmis.resource;

import com.mt.quarkus.repository.BECampaignRepository;
//import com.mt.quarkus.repository.RabbitMQPublisher;
import com.otz.messagebroker.rabbitmq.RabbitMQPublisher;

import org.json.JSONObject;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

/**
 * @author MILTON
 */
@Path("message")
@Slf4j
public class MessageSentResource {

	@Inject
	private BECampaignRepository beCampaignRepository;
	
	@Inject
	private RabbitMQPublisher rabbitMQPublisher;
	
	@GET
	@Path("publish")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAllCampaignList() {
		JSONObject response = new JSONObject();
		response.put("message", "Message sent successfully");
		response.put("rabbitMQPublisher", rabbitMQPublisher);
		log.info("rabbitMQPublisher: {}", rabbitMQPublisher);
//		response.put("rabbitMQPublisher", beCampaignRepository.getCampaign(BigInteger.valueOf(1)));
		
		return Response.status(Response.Status.OK).entity(response.toString()).build();
	}

}
