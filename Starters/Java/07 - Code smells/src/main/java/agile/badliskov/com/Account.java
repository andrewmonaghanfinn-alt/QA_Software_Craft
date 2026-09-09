package agile.badliskov.com;

import java.util.ArrayList;
import java.util.Date;

public abstract class Account {
	// We would have getters/setters for these but left out to minimise the code
	private String firstname, lastname, address;
	private int accountNumber;
	private double balance;

	public Account() {
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	public abstract void withDraw(double amount);


	public void deposit(double amount) {
		balance += amount;
	}	
	
	
	

}

class CurrentAccount extends Account {

	private double overdraftLimit;
	private OrderManagement orderManagement;


	CurrentAccount(double overdraftLimit, OrderManagement orderManagement) {
		super();
		this.overdraftLimit = overdraftLimit;
		this.orderManagement = orderManagement;
	}

	// used where account is current account
	public boolean isOverDrawn() {
		return getBalance() < 0;
	}

	@Override 
	public void withDraw(double amount) {
		if (amount > getBalance() + overdraftLimit) {
			return;
		}
		setBalance(getBalance() - amount);
	}

		// used where account is current account
	public void setOverdraftLimit(double overdraftLimit) {
		this.overdraftLimit = overdraftLimit;
	}

	public void processPayment(OrderType orderType) {
		orderManagement.processOrders(orderType);
	}
	
}

class DepositAccount extends Account {

	private double interest;

	DepositAccount(double interest) {
		super();
		this.interest = interest;
	}

	public void addInterestToAccount() { // used where account is a deposit acct
		setBalance(getBalance() + (getBalance() * interest));
	}

	@Override
	public void withDraw(double amount) {
		if (amount > getBalance()) {
			return;
		}
		setBalance(getBalance() - amount);
	}

}



class Payee {
	private String name, address;
	private Date date;
	private double amount;
}




class OrderManagement {

	ArrayList<Order> accountOrders;

	OrderManagement() {
		accountOrders = new ArrayList<>();
	}

	public void addOrder(Payee payee, OrderType orderType) {
		Order newOrder = new Order(payee, orderType);
		accountOrders.add(newOrder);
	}

	public void processOrders(OrderType orderType) {
		for(Order order : accountOrders) {
			if (order.getOrderType() == orderType){
				//process
			}
		}
	}
}

enum OrderType {
		DIRECT_DEBIT,
		STANDING_ORDER
	}


class Order {

	private Payee payee;
	private OrderType orderType;

	Order(Payee payee, OrderType orderType) {
		this.payee = payee;
		this.orderType = orderType;
	}

	public Payee getPayee() {
		return payee;
	}

	public OrderType getOrderType() {
		return orderType;
	}
}

