package service.email;

import model.email.ProductOrder;

public interface OrderService {

	public void sendOrderComfirmation(ProductOrder productOrder);
}
