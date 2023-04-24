public enum SubscriptionType {
    GOLD,
    SILVER,
    FREE,
    BANNED
}

public class Player {
    private String name;
    private String email;
    private int points;
    private SubscriptionType subscriptionType;

    public Player(String name, String email, int points, SubscriptionType subscriptionType) {
        this.name = name;
        this.email = email;
        this.points = points;
        this.subscriptionType = subscriptionType;
    }

    public void applyReward(int reward) {
        switch (subscriptionType) {
            case GOLD:
                this.points+=reward*3;
                break;
            case SILVER:
                this.points+=reward*2;
                break;
            case FREE:
                this.points+=reward;
                break;
            default:
                break;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public SubscriptionType getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(SubscriptionType subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

} enumsI {
    
}
