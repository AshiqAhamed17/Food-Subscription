public class Payment {
    private int paymentId;
    private double amount;
    private String paymentDate;
    private String status;

    public Payment(int paymentId, double amount, String paymentDate, String status) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.status = status;
    }

    // Getters and Setters
    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Display payment details
    public void displayPayment() {
        System.out.println("Payment ID: " + paymentId);
        System.out.println("Amount: $" + amount);
        System.out.println("Payment Date: " + paymentDate);
        System.out.println("Status: " + status);
    }
}