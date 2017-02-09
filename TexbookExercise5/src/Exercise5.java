
public class Exercise5 {
	public static void main (String [] args) {
		 
		 Ticket x = new StudentAdvanceTicket(7,1);
		 System.out.println (x.toString());
	}
	public static abstract class Ticket {
		public int number;
		public abstract int getPrice();
		public abstract String toString();
		public Ticket (int number) {
			this.number = number;
		}
	}
	public static class WalkupTicket extends Ticket {
		public WalkupTicket(int number) {
			super(number);
		}
		public int getPrice() {
			return 50;
		}
		public String toString() {
			return "Number: " + number + ", " + "Price: " + getPrice();
					 
		}
	}
	public static class AdvanceTicket extends Ticket {
		public int daysBeforeEvent;
		public AdvanceTicket(int number, int daysBeforeEvent) {
			super(number);
			this.daysBeforeEvent = daysBeforeEvent;
		}
		public int getPrice() {
			if(daysBeforeEvent >= 10) {
				return 30;
			}
			else {
				return 40;
			}
		}
		public String toString() {
			return "Number: " + number + ", " + "Price: " + getPrice();
					 
		}
	}
	public static class StudentAdvanceTicket extends AdvanceTicket {
		public int daysBeforeEvent;
		public StudentAdvanceTicket(int number, int daysBeforeEvent) {
			super(number, daysBeforeEvent);
		}
		public int getPrice() {
			int initialPrice = super.getPrice();
			return (initialPrice)/2;
		}
		public String toString() {
			return "Number: " + number + ", " + "Price: " + getPrice();
					 
		}
	}
}

