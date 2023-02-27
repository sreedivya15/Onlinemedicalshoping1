package controller;

import java.util.List;



import entity.Order;
import service.OrderService;

import entity.Order;
import service.OrderService;



@RestController
@RequestMapping("/orderstore")

public class OrderRestController {

	@Autowired
	OrderService orderService;
	
	public OrderRestController() {
		System.out.println("\n\n\n=======>> Inside Contructor "+this);
	}

	@GetMapping("/welcome")
	public String welcome()
	{
		
		return "Welcome to Order Store";
		
	}
	
	@PostMapping("/addorder")
	public ResponseEntity<String> addOrder(@RequestBody Order order)
	{
		try {
			Order savedOrder = orderService.insertOrder(order);
			String responseMsg = savedOrder.getUserName()+"BookName"+savedOrder.getBookName();
			return new ResponseEntity<String>(responseMsg,HttpStatus.OK);
		}catch(Exception e) {
			String errorMsg = "Contact customer care Ph.no:- 1800-250-900 or mail to:- bookstore@gmail.com";
			return new ResponseEntity<String>(errorMsg,HttpStatus.INTERNAL_SERVER_ERROR); 
		}
		
	}
	
	@GetMapping("/orders")
	public List<Order> getAllOrders()
	{
		try {
			List<Order> allExtractedOrders = orderService.getAllOrders();
			return allExtractedOrders;
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	/*@GetMapping("username/{searchUserName}")
	  public User getUserByUserName(@PathVariable String searchUserName) throws Exception
	  {
		  return userService.getUserByUserName(searchUserName);
     }
	@GetMapping("userrole/{searchUserRole}")
	public User getUserByUserRole(@PathVariable String searchUserRole) throws Exception
	{
		return userService.getUserByRole(searchUserRole);
	}*/
	
	
	@DeleteMapping("/orderid/{searchOrderId}")   
    public void deleteUser(@PathVariable int searchOrderId)
    {  
      try {
        orderService.delete(searchOrderId);
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }  
    }
	/*@PutMapping("/orderid/{orderId}")
    public   Order updateOrder(@PathVariable int orderId, @RequestBody Order orderDetails) throws Exception {
        orderService.get
        orderDetails.setUserId(userId);
        User updateUser = userService.addUser(userDetails);
        return updateUser;
    }*/
	
}
