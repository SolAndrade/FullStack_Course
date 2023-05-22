@PrimaryKeyJoinColumn(name="id")
public class ComputerSection extends Section {
    private final int computerCredit;
  
    public ComputerSection(int computerCredit) {
      super(15);
      this.computerCredit = computerCredit;
    }
  
    // other constructors, getters, and setters were omitted for brevity
  }
  