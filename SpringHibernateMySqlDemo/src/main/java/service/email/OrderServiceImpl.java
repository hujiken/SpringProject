package service.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.email.ProductOrder;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

	@Autowired
	private MailService mailService;
	
	public void sendOrderComfirmation(ProductOrder productOrder) {
		mailService.sendEmail(productOrder);
	}

}
