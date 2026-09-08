package com.qaicpads;

public class AccountBuilder {
    public static void main(String[] args){
        
    }
  
    
}

class Account {

    private int balance;
    private String name;
    private int overdraftLimit;

    private Account(Builder builder) {
        this.balance = builder.balance;
        this.name = builder.name;
        this.overdraftLimit = builder.overdraftLimit;
    }

    public static class Builder {
        private int balance;
        private String name;
        private int overdraftLimit;

        public Builder setBalanace(int balance) {
            this.balance = balance;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }
        
        public Builder setOverdraftLimit(int overdraftLimit) {
            this.overdraftLimit = overdraftLimit;
            return this;
        }

        public Account build() {
            return new Account(this);
        }
    }


}


/*
package com.qaicpads;

public abstract class Account {
	
	protected int balance;
	protected String name;

	public abstract boolean withdraw(int amt);
	
	public int getBalance() {
		return this.balance;
	}
	
	public String getName() {
		return this.name;
	}
	
	
	@Override
	public String toString(){
		return "BALANCE="+this.getBalance()+", NAME="+this.getName();
	}
	
	public boolean deposit(int amt) {
		this.balance += amt;
		return true;
	}

}

*/