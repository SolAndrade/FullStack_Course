@PrimaryKeyJoinColumn(name="id")
public class MathSection extends Section{
    private final int mathCredit;
  
    public MathSection(int mathCredit){
      super(30);
      this.mathCredit = mathCredit;
    }
  
    // other constructors, getters, and setters were omitted for brevity
  }
  