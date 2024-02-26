package br.com.guilchaves.notification.services;

import br.com.guilchaves.notification.domain.Proposal;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.PublishRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationSnsService {

    @Autowired
    private AmazonSNS amazonSNS;

    public void sendNotification(String phone, String message){
        PublishRequest publishRequest = new PublishRequest().withMessage(message).withPhoneNumber(phone);
        amazonSNS.publish(publishRequest);
    }
}
